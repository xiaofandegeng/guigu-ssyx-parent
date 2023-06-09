package com.atguigu.ssyx.acl.service;

import com.atguigu.ssyx.model.acl.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> queryAllMenu();

    void save(Permission permission);

    void updateById(Permission permission);

    boolean removeChildById(Long id);
}
