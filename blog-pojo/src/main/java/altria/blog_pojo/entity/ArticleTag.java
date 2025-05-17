package altria.blog_pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleTag {
    private Integer id;
    
    private Integer articleId;

    private Integer tagId;
}
