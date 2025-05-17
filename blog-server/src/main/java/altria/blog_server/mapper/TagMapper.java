package altria.blog_server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import altria.blog_pojo.entity.Tag;

@Mapper
public interface TagMapper {

    @Insert("INSERT INTO tag (name, description, create_time, update_time) " +
            "VALUES (#{name}, #{description}, #{createTime}, #{updateTime})")
    void insert(Tag tag);

    @Select("select * from tag")
    List<Tag> getAll();
}
