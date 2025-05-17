package altria.blog_server.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altria.blog_pojo.dto.TagDTO;
import altria.blog_pojo.entity.Tag;
import altria.blog_server.mapper.TagMapper;

@Service
public class TagService {

    @Autowired
    TagMapper tagMapper;

    public void insert(TagDTO tagDTO) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagDTO, tag);
        tag.setCreateTime(LocalDateTime.now());
        tag.setUpdateTime(LocalDateTime.now());
        tagMapper.insert(tag);
    }

    public List<Tag> getAll() {
        return tagMapper.getAll();
    }

}
