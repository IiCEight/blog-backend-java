package altria.blog_server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import altria.blog_pojo.entity.ArticleTag;
import altria.blog_pojo.vo.TagVO;

@Mapper
public interface ArticleTagMapper {

    void insertBatch(List<ArticleTag> articleTags);

    List<TagVO> findTagsByArticleId(Integer articleId);
}
