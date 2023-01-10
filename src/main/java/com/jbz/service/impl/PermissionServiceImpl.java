package com.jbz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbz.domain.Permission;
import com.jbz.mapper.PermissionMapper;
import com.jbz.mapper.RolePermissionMapper;
import com.jbz.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jbz
 * @date: 2023/1/9
 * @description:
 * @version: 1.0
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
     * @author: jbz
     * @description: 分页查询
     * @date: 2023/1/9 13:45
     * @param: pageNum
     * @param: pageSize
     * @param: permissionName
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Permission>
    */
    @Override
    public PageInfo<Permission> queryAllPermission(int pageNum, int pageSize, String permissionName) {
        //用mybatis提供的分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Permission> permissionList = permissionMapper.queryAllPermission(permissionName);
        return new PageInfo<>(permissionList,pageSize);
    }

    /**
     * @author: jbz
     * @description: 新增权限
     * @date: 2023/1/9 15:58
     * @param: permission
     * @return: void
    */
    @Override
    public void insertPermission(Permission permission) {
        permissionMapper.insertPermission(permission);
    }

    /**
     * @author: jbz
     * @description: 根据id查询权限
     * @date: 2023/1/9 15:55
     * @param: id
     * @return: com.jbz.domain.Permission
     */
    @Override
    public Permission queryPermissionById(int id) {
        return permissionMapper.queryPermissionById(id);
    }

    /**
     * @author: jbz
     * @description: 修改权限
     * @date: 2023/1/9 15:51
     * @param: permission
     * @return: void
     */
    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updatePermission(permission);
    }
    /**
     * @author: jbz
     * @description: 删除权限
     * @date: 2023/1/9 15:57
     * @param: id
     * @return: void
    */
    @Override
    public void deletePermissionById(int id) {
        rolePermissionMapper.deleteRolePermissionByPermissionId(id);
        permissionMapper.deletePermissionById(id);
    }

    /**
     * @author: jbz
     * @description: 批量删除
     * @date: 2023/1/9 15:57
     * @param: ids
     * @return: void
    */
    @Override
    public void batchDeletePermissionByIds(int[] ids) {
        rolePermissionMapper.batchDeleteRolePermissionByPermissionIds(ids);
        permissionMapper.batchDeletePermissionByIds(ids);
    }
}
