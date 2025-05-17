package altria.blog_server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import altria.blog_pojo.entity.Category;

@Mapper
public interface CategoryMapper {

    @Insert("INSERT INTO category (name, description, create_time, update_time) " +
            "VALUES (#{name}, #{description}, #{createTime}, #{updateTime})")
    void insert(Category category);

    @Select("select * from category")
    List<Category> getAll();
    
}
