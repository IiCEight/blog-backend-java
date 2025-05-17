package altria.blog_server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.Page;

import altria.blog_pojo.dto.ArticlePageQueryDTO;
import altria.blog_pojo.entity.Article;
import altria.blog_pojo.vo.ArticleInfoVO;

@Mapper
public interface ArticleMapper {

    void insert(Article article);

    Page<ArticleInfoVO> pageQuery(ArticlePageQueryDTO articlePageQueryDTO);

    @Select("select content from article where id = #{id}")
    String getContentById(Integer id);

    ArticleInfoVO getInfoById(Integer id);

}
