package com.jbz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbz.domain.Permission;
import com.jbz.domain.Role;
import com.jbz.mapper.PermissionMapper;
import com.jbz.mapper.RoleMapper;
import com.jbz.mapper.RolePermissionMapper;
import com.jbz.mapper.UserRoleMapper;
import com.jbz.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: jbz
 * @date: 2022/12/24
 * @description:
 * @version: 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {
    //依赖注入
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * @author: jbz
     * @description: 查询所有角色
     * @date: 2022/12/24 15:18
     * @param:
     * @return: java.util.List<com.jbz.domain.Role>
    */
    @Override
    public PageInfo<Role> queryAllRole(int pageNum, int pageSize, String roleDesc) {
        //用mybatis提供的分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Role> roleList = roleMapper.queryAllRole(roleDesc);
        return new PageInfo<>(roleList,pageSize);
    }

    /**
     * @author: jbz
     * @description: 查询添加角色所需要的数据
     * @date: 2023/1/9 13:54
     * @param:
     * @return: java.util.List<com.jbz.domain.Permission>
    */
    @Override
    public List<Permission> queryData() {
        return permissionMapper.queryAllPermission(null);
    }

    /**
     * @author: jbz
     * @description: 添加角色以及角色与权限的中间表
     * @date: 2022/12/24 15:57
     * @param: role
     * @return: void
    */
    @Override
    public void addRole(Role role,int[] permissionIds) {
        roleMapper.addRole(role);
        rolePermissionMapper.addRolePermission(permissionIds,role.getId());
    }

    /**
     * @author: jbz
     * @description: 根据id查询角色以及所需要的数据
     * @date: 2023/1/9 14:25
     * @param: id
     * @return: java.util.Map<java.lang.String,java.lang.Object>
    */
    @Override
    public Map<String, Object> queryRoleById(Integer id) {
        Role role = roleMapper.queryRoleById(id);
        List<Permission> permissions = queryData();
        //创建Map对象
        Map<String, Object> map = new HashMap<>();
        map.put("role", role);
        map.put("permissions", permissions);
        return map;
    }


    /**
     * @author: jbz
     * @description: 根据id修改role
     * @date: 2022/12/24 16:19
     * @param: role
     * @return: void
    */
    @Override
    public void updateRoleById(Role role,int[]permissionIds) {
        roleMapper.updateRoleById(role);
        rolePermissionMapper.deleteRolePermission(role.getId());
        rolePermissionMapper.addRolePermission(permissionIds,role.getId());
    }

    /**
     * @author: jbz
     * @description: 根据id删除role
     * @date: 2022/12/24 16:19
     * @param: id
     * @return: void
    */
    @Override
    public void deleteRoleById(Integer id) {
        userRoleMapper.deleteUserRoleByRoleId(id);
        rolePermissionMapper.deleteRolePermission(id);
        roleMapper.deleteRoleById(id);
    }

    /**
     * @author: jbz
     * @description: 批量删除Role
     * @date: 2022/12/24 16:36
     * @param: ids
     * @return: void
    */
    @Override
    public void batchDeleteRoleByIds(int[] ids) {
        userRoleMapper.batchDeleteUserRoleByRoleIds(ids);
        rolePermissionMapper.batchDeleteRolePermissionByRoleIds(ids);
        roleMapper.batchDeleteRoleByIds(ids);
    }
}
