package altria.blog_pojo.dto;

import lombok.Data;

@Data
public class ArticlePageQueryDTO {

    private String searchWord;

    private Integer categoryId;

    private Integer page;

    private Integer pageSize;
}
