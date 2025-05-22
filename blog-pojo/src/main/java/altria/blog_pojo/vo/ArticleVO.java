package altria.blog_pojo.vo;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO {
    
    private Integer id;

    private String title;
    
    private String img;

    private String description;

    private String content;

    private CategoryVO category;

    private List<TagVO> tags;

    private String status;

    private Long views;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}
