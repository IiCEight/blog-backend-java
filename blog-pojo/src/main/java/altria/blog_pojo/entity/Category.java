package altria.blog_pojo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Integer id;

    private String name;

    private String description;

    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;
}
