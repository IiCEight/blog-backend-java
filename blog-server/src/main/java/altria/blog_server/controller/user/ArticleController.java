package altria.blog_server.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import altria.blog_common.result.Result;
import altria.blog_pojo.dto.ArticlePageQueryDTO;
import altria.blog_pojo.vo.ArticleInfoVO;
import altria.blog_pojo.vo.ArticleVO;
import altria.blog_server.service.ArticleService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/page")
    public Result<List<ArticleInfoVO>> page(ArticlePageQueryDTO articlePageQueryDTO) {
        log.info("Page query: page {}, pageSize {}", articlePageQueryDTO.getPage(),
            articlePageQueryDTO.getPageSize());
        return Result.success(articleService.pageQuery(articlePageQueryDTO));
    }

    @GetMapping("/{id}")
    public Result<ArticleVO> getById(@PathVariable Integer id) {
        log.info("Article id: {}", id);
        return Result.success(articleService.getById(id));
    }
    
}
