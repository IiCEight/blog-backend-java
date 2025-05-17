package altria.blog_server.controller.admin;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import altria.blog_common.constant.MessageConstant;
import altria.blog_common.result.Result;
import altria.blog_server.service.ImageUploadService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RestController
@RequestMapping("/admin")
public class ImageUploadController {

    @Autowired
    ImageUploadService imageUploadService;

    @PostMapping("upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        log.info("Upload file {}", file);
        String result = imageUploadService.uploadImage(file.getBytes(), file.getOriginalFilename());
        if (result == MessageConstant.UPLOAD_IMAGE_FAILED)
            return Result.error(result);
        return Result.success(result);
    }
    
}
