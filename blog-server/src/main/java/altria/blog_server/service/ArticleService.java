package altria.blog_server.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import altria.blog_common.constant.ArticleStatusConstant;
import altria.blog_pojo.dto.ArticleDTO;
import altria.blog_pojo.dto.ArticlePageQueryDTO;
import altria.blog_pojo.entity.Article;
import altria.blog_pojo.entity.ArticleTag;
import altria.blog_pojo.vo.ArticleInfoVO;
import altria.blog_server.mapper.ArticleMapper;
import altria.blog_server.mapper.ArticleTagMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleTagMapper articleTagMapper;

    @Transactional
    public void insert(ArticleDTO articleDTO) {
        Article article =new Article();
        BeanUtils.copyProperties(articleDTO, article);
        article.setStatus(ArticleStatusConstant.PUBLISHED);
        article.setViews(0L);
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        articleMapper.insert(article);

        List<ArticleTag> articleTags = articleDTO.getTagIds().stream()
                        .map(tagId -> new ArticleTag(null, article.getId(), tagId))
                        .toList();
        
        articleTagMapper.insertBatch(articleTags);
    }

    public List<ArticleInfoVO> pageQuery(ArticlePageQueryDTO articlePageQueryDTO) {
        PageHelper.startPage(articlePageQueryDTO.getPage(), 
                    articlePageQueryDTO.getPageSize());
        List<ArticleInfoVO> articleInfoVOs = articleMapper.pageQuery(articlePageQueryDTO).getResult();

        // For each article, find its tags.
        articleInfoVOs.forEach((articleInfoVO) -> {
            articleInfoVO.setTags((articleTagMapper.findTagsByArticleId(articleInfoVO.getId())));
            log.info("articleIfoVO {}", articleInfoVO);
        });
        
        return articleInfoVOs;
    }

    public ArticleInfoVO getInfoById(Integer id) {
        return articleMapper.getInfoById(id);
    }

    public String getById(Integer id) {

        return articleMapper.getContentById(id);
    }
}
