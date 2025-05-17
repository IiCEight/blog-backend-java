package altria.blog_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altria.blog_common.constant.MessageConstant;
import altria.blog_common.result.Result;
import altria.blog_common.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageUploadService {
    @Autowired
    AliOssUtil aliOssUtil;

    public String uploadImage(byte[] fileBytes, String fileName) {
        log.info("fileName : {}", fileName);
        try {
            String url = aliOssUtil.upload(fileBytes, fileName);
            return url;
        } catch (Exception e) {
            log.error("Upload file error {}", e);
        }
        return MessageConstant.UPLOAD_IMAGE_FAILED;
    }
}
