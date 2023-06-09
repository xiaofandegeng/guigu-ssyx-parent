package com.atguigu.ssyx.product.service;

import com.atguigu.ssyx.model.product.Category;
import com.atguigu.ssyx.vo.product.CategoryQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface CategoryService {
    IPage<Category> selectPage(Page<Category> pageParam, CategoryQueryVo categoryQueryVo);

    Category getById(Long id);

    void save(Category category);

    void updateById(Category category);

    void removeById(Long id);

    void removeByIds(List<Long> idList);

    List<Category> findAllList();
}
