package com.jbz.service;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Permission;


/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
public interface IPermissionService {

    /**
     * @author: jbz
     * @description: 查询所有的权限
     * @date: 2023/1/8 16:16
     * @param: pageNum
     * @param: pageSize
     * @param: permissionName
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Permission>
    */
    PageInfo<Permission> queryAllPermission(int pageNum, int pageSize, String permissionName);

    /**
     * @author: jbz
     * @description: 新增权限
     * @date: 2023/1/9 15:50
     * @param: permission
     * @return: void
     */
    void insertPermission(Permission permission);

    /**
     * @author: jbz
     * @description: 根据id查询权限
     * @date: 2023/1/9 15:55
     * @param: id
     * @return: com.jbz.domain.Permission
     */
    Permission queryPermissionById(int id);

    /**
     * @author: jbz
     * @description: 修改权限
     * @date: 2023/1/9 15:51
     * @param: permission
     * @return: void
     */
    void updatePermission(Permission permission);

    /**
     * @author: jbz
     * @description: 删除权限
     * @date: 2023/1/9 15:52
     * @param: id
     * @return: void
     */
    void deletePermissionById(int id);

    /**
     * @author: jbz
     * @description: 批量删除权限
     * @date: 2023/1/9 15:53
     * @param: ids
     * @return: void
     */
    void batchDeletePermissionByIds(int[] ids);


}
