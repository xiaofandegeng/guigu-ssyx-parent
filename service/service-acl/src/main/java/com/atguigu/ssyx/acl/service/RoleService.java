package com.atguigu.ssyx.acl.service;

import com.atguigu.ssyx.model.acl.Role;
import com.atguigu.ssyx.vo.acl.RoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.models.auth.In;

import java.util.List;

public interface RoleService {
    // 角色分页列表
    IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo);

    Role getById(Long id);

    Integer save(Role role);

    Integer updateById(Role role);

    Integer removeById(Long id);

    Integer removeByIds(List<Long> idList);
}
