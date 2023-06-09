package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.AttrGroup;
import com.atguigu.ssyx.product.mapper.AttrGroupMapper;
import com.atguigu.ssyx.product.service.AttrGroupService;
import com.atguigu.ssyx.vo.product.AttrGroupQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AttrGroupServiceImpl implements AttrGroupService {

    @Autowired
    private AttrGroupMapper attrGroupMapper;

    @Override
    public IPage<AttrGroup> selectPage(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo) {
        String name = attrGroupQueryVo.getName();
        LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(AttrGroup::getName, name);
        }
        IPage<AttrGroup> attrGroupPage = attrGroupMapper.selectPage(pageParam, wrapper);
        return attrGroupPage;
    }

    @Override
    public AttrGroup getById(Long id) {
        return attrGroupMapper.selectById(id);
    }

    @Override
    public void save(AttrGroup attrGroup) {
        attrGroupMapper.insert(attrGroup);
    }

    @Override
    public void updateById(AttrGroup attrGroup) {
        attrGroupMapper.updateById(attrGroup);
    }

    @Override
    public void removeById(Long id) {
        attrGroupMapper.deleteById(id);
    }

    @Override
    public void removeByIds(List<Long> idList) {
        attrGroupMapper.deleteBatchIds(idList);
    }

    @Override
    public List<AttrGroup> findAllList() {
        return attrGroupMapper.selectList(null);
    }
}
