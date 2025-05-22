package altria.blog_server.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import altria.blog_common.result.Result;
import altria.blog_pojo.dto.ArticleDTO;
import altria.blog_pojo.dto.ArticlePageQueryDTO;
import altria.blog_pojo.vo.ArticleInfoVO;
import altria.blog_server.service.ArticleService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/page")
    public Result<List<ArticleInfoVO>> page(ArticlePageQueryDTO articlePageQueryDTO) {
        log.info("Page query: page {}, pageSize {}", articlePageQueryDTO.getPage(),
            articlePageQueryDTO.getPageSize());
        return Result.success(articleService.pageQuery(articlePageQueryDTO));
    }

    @PostMapping
    public Result<String> insert(@RequestBody ArticleDTO articleDTO) {
        log.info("Insert article {}", articleDTO);

        articleService.insert(articleDTO);

        return Result.success();
    }
}
