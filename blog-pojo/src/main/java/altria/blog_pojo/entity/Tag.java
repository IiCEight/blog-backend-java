package altria.blog_pojo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Tag {
    private Integer id;

    private String name;

    private String description;

    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}
