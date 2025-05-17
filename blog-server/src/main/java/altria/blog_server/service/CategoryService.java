package altria.blog_server.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import altria.blog_pojo.dto.CategoryDTO;
import altria.blog_pojo.entity.Category;
import altria.blog_server.mapper.CategoryMapper;

@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public void insert(CategoryDTO categoryDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDTO, category);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insert(category);
    }

    public List<Category> getAll() {
        
        return categoryMapper.getAll();

    }

}
