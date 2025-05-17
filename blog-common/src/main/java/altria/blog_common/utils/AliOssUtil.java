package altria.blog_common.utils;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.SignVersion;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.ByteArrayInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@Component
// Use this to auto read value in application.yml configuration file 
// Note: This only works if the fields have getters and setters
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOssUtil {
    
    // Use @value to read value in application.yml configuration file 
    // @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    // @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    // @Value("${aliyun.oss.region}")
    private String region;

    public String upload(byte[] content, String originalFileName) throws Exception  {
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量
        // OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = 
            CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 填写Object完整路径，完整路径中不能包含Bucket名称，
        // 例如exampledir/exampleobject.txt。
        String prefix = "blog";
        String dir = LocalDateTime.now().format(DateTimeFormatter.
                                                ofPattern("yyyy-MM-dd"));
        // Create a new random name to avoid duplication
        String newName = UUID.randomUUID() + originalFileName.substring(
                                    originalFileName.lastIndexOf("."));
        String objectName =prefix + "/" + dir + "/" + newName;


        // log.info("Upload file to Aliyun OSS, endpoint: {}, bucketName: {}, region: {}",
                // endpoint, bucketName, region);


        // 创建OSSClient实例。
        ClientBuilderConfiguration clientBuilderConfiguration = new 
                                                ClientBuilderConfiguration();
        clientBuilderConfiguration.setSignatureVersion(SignVersion.V4);        
        OSS ossClient = OSSClientBuilder.create()
        .endpoint(endpoint)
        .credentialsProvider(credentialsProvider)
        .clientConfiguration(clientBuilderConfiguration)
        .region(region)               
        .build();

        // URL url = null;

        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, 
                        objectName, new ByteArrayInputStream(content));

            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);
            
            // 上传对象
            PutObjectResult result = ossClient.putObject(putObjectRequest);

            // // 设置预签名URL过期时间，单位为毫秒。本示例以设置过期时间为5天为例。
            // Date expiration = new Date(new Date().getTime() + 5 * 24 * 60 * 60 * 1000L);
            // // 生成以GET方法访问的预签名URL。本示例没有额外请求头，其他人可以直接通过浏览器访问相关内容。
            // url = ossClient.generatePresignedUrl(bucketName, objectName, expiration);
            // System.out.println(url);

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }

        // url: https://BucketName.Endpoint/ObjectName
        String endpointHeaderRemoved = endpoint.substring(endpoint.indexOf("oss")); //remove "https://"
        String url = "https://" + bucketName + "." + endpointHeaderRemoved + "/" +
                        objectName;

        log.info("Upload file to Aliyun OSS success, url: {}", url);

        return url;
    }
}
