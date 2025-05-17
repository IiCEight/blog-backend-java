package altria.blog_pojo.dto;

import java.util.List;

import lombok.Data;

@Data
public class ArticleDTO {

    private String title;
    
    private String img;

    private String description;

    private String content;

    private Integer categoryId; 

    private List<Integer> tagIds;
}
