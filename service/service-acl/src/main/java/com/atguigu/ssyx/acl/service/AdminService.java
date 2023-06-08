package com.atguigu.ssyx.acl.service;

import com.atguigu.ssyx.model.acl.Admin;
import com.atguigu.ssyx.vo.acl.AdminQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface AdminService {
    IPage<Admin> selectPage(Page<Admin> pageParam, AdminQueryVo userQueryVo);

    Admin getById(Long id);

    int removeByIds(List<Long> idList);

    int removeById(Long id);

    int updateById(Admin user);

    int save(Admin user);
}
