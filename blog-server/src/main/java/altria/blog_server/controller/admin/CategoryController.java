package altria.blog_server.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import altria.blog_common.result.Result;
import altria.blog_pojo.dto.CategoryDTO;
import altria.blog_pojo.entity.Category;
import altria.blog_server.service.CategoryService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin/category")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;


    @GetMapping
    public Result<List<Category>> getAll() {
        log.info("Get all categories");
        
        return Result.success(categoryService.getAll());

    }

    @PostMapping
    public Result<String> insert(@RequestBody CategoryDTO categoryDTO) {
        log.info("categoryDTO: {}", categoryDTO);
        categoryService.insert(categoryDTO);

        return Result.success();
    }
}
