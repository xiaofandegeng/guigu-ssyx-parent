package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.mapper.AdminRoleMapper;
import com.atguigu.ssyx.acl.mapper.RoleMapper;
import com.atguigu.ssyx.acl.service.RoleService;
import com.atguigu.ssyx.model.acl.AdminRole;
import com.atguigu.ssyx.model.acl.Role;
import com.atguigu.ssyx.vo.acl.RoleQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo) {
        String roleName = roleQueryVo.getRoleName();
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(roleName)) {
            wrapper.like(Role::getRoleName, roleName);
        }
        return roleMapper.selectPage(pageParam, wrapper);
    }

    @Override
    public Role getById(Long id) {
        return roleMapper.selectById(id);
    }

    @Override
    public Integer save(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public Integer updateById(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public Integer removeById(Long id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public Integer removeByIds(List<Long> idList) {
        return roleMapper.deleteBatchIds(idList);
    }

    @Override
    public Map<String, Object> findRoleByUserId(Long adminId) {
        List<Role> adminRoleList = roleMapper.selectList(null);

        // 拥有的角色id
        QueryWrapper<AdminRole> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_id", adminId);
        wrapper.select("role_id");
        List<AdminRole> adminRoles = adminRoleMapper.selectList(wrapper);

        List<Long> collect = adminRoles.stream().map(c -> c.getRoleId()).collect(Collectors.toList());

        // 对角色分类
        ArrayList<Role> assignRoles = new ArrayList<>();
        for (Role role : adminRoleList) {
            if(collect.contains(role.getId())) {
                assignRoles.add(role);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assignRoles", assignRoles);
        roleMap.put("allRolesList", adminRoleList);
        return roleMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUserRoleRelationShip(Long adminId, Long[] roleIds) {
        // 删除用户原有的角色数据
        QueryWrapper<AdminRole> wrapper = new QueryWrapper<>();
        wrapper.eq("admin_id", adminId);
        int delete = adminRoleMapper.delete(wrapper);

        // 分配新的角色
        for (Long roleId : roleIds) {
            if(StringUtils.isEmpty(roleId))
                continue;
            AdminRole userRole = new AdminRole();
            userRole.setAdminId(adminId);
            userRole.setRoleId(roleId);
            adminRoleMapper.insert(userRole);
        }
    }
}