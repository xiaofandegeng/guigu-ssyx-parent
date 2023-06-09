package com.atguigu.ssyx.product.service.impl;

import com.atguigu.ssyx.model.product.Attr;
import com.atguigu.ssyx.product.mapper.AttrMapper;
import com.atguigu.ssyx.product.service.AttrService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    private AttrMapper attrMapper;

    @Override
    public List<Attr> findByAttrGroupId(Long attrGroupId) {
        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getAttrGroupId, attrGroupId);
        List<Attr> attrList = attrMapper.selectList(wrapper);
        return attrList;
    }

    @Override
    public Attr getById(Long id) {
        return attrMapper.selectById(id);
    }

    @Override
    public void save(Attr attr) {
        attrMapper.insert(attr);
    }

    @Override
    public void updateById(Attr attr) {
        attrMapper.updateById(attr);
    }

    @Override
    public void removeByIds(List<Long> idList) {
        attrMapper.deleteBatchIds(idList);
    }

    @Override
    public void removeById(Long id) {
        attrMapper.deleteById(id);
    }
}
