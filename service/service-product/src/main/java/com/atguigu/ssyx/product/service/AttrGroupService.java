package com.atguigu.ssyx.product.service;

import com.atguigu.ssyx.model.product.AttrGroup;
import com.atguigu.ssyx.vo.product.AttrGroupQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface AttrGroupService {
    IPage<AttrGroup> selectPage(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo);

    AttrGroup getById(Long id);

    void save(AttrGroup attrGroup);

    void updateById(AttrGroup attrGroup);

    void removeById(Long id);

    void removeByIds(List<Long> idList);

    List<AttrGroup> findAllList();
}
