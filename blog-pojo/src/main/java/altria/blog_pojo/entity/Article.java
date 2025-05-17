package altria.blog_pojo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    
    private Integer id;

    private String title;
    
    private String img;

    private String description;

    private String content;

    private Integer categoryId;

    private String status;

    private Long views;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}


