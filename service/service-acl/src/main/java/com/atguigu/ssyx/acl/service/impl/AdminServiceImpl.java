package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.mapper.AdminMapper;
import com.atguigu.ssyx.acl.service.AdminService;
import com.atguigu.ssyx.model.acl.Admin;
import com.atguigu.ssyx.vo.acl.AdminQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo) {
        String username = userQueryVo.getUsername();
        String name = userQueryVo.getName();

        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();

        if(!StringUtils.isEmpty(username)) {
            wrapper.eq(Admin::getUsername, username);
        }
        if(!StringUtils.isEmpty(name)){
            wrapper.like(Admin::getName, name);
        }
        return adminMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public Admin getById(Long id) {
        return adminMapper.selectById(id);
    }

    @Override
    public int removeByIds(List<Long> idList) {
        return adminMapper.deleteBatchIds(idList);
    }

    @Override
    public int removeById(Long id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public int updateById(Admin user) {
        return adminMapper.updateById(user);
    }

    @Override
    public int save(Admin user) {
        return adminMapper.insert(user);
    }
}
