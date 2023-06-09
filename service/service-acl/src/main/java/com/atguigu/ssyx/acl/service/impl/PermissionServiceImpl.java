package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.helper.PermissionHelper;
import com.atguigu.ssyx.acl.mapper.PermissionMapper;
import com.atguigu.ssyx.acl.service.PermissionService;
import com.atguigu.ssyx.model.acl.Permission;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 获取所有的菜单
     * @return
     */
    @Override
    public List<Permission> queryAllMenu() {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("CAST(id AS SIGNED)");
        List<Permission> allPermissionList = permissionMapper.selectList(wrapper);
        List<Permission> result = PermissionHelper.bulid(allPermissionList);
        return result;
    }

    @Override
    public void save(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void updateById(Permission permission) {
        permissionMapper.updateById(permission);
    }

    @Override
    public boolean removeChildById(Long id) {
        List<Long> idList = new ArrayList<>();
        this.selectChildListById(id,idList);
        idList.add(id);
        permissionMapper.deleteBatchIds(idList);
        return true;
    }

    /**
     *	递归获取子节点
     * @param id
     * @param idList
     */
    private void selectChildListById(Long id, List<Long> idList) {
        List<Permission> childList = permissionMapper.selectList(new QueryWrapper<Permission>().eq("pid", id).select("id"));
        childList.stream().forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(), idList);
        });
    }
}
