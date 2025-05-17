package altria.blog_server.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import altria.blog_common.result.Result;
import altria.blog_pojo.dto.TagDTO;
import altria.blog_pojo.entity.Tag;
import altria.blog_server.service.TagService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin/tag")
public class TagController {
    
    @Autowired
    TagService tagService;

    @GetMapping
    public Result<List<Tag>> getAll() {
        log.info("Get all tags");
        
        return Result.success(tagService.getAll());
    }

    @PostMapping
    public Result<String> insert(@RequestBody TagDTO tagDTO) {
        log.info("tagDTO: {}", tagDTO);
        tagService.insert(tagDTO);
        return Result.success();
    }
}
