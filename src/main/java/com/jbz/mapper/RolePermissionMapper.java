package com.jbz.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: jbz
 * @date: 2023/1/9
 * @description:
 * @version: 1.0
 */
@Repository
public interface RolePermissionMapper {

    /**
     * @author: jbz
     * @description: 给角色与权限中间表添加记录
     * @date: 2023/1/9 14:14
     * @param: permissionIds
     * @param: roleId
     * @return: void
    */
    void addRolePermission(@Param("array") int[] permissionIds, @Param("roleId") int roleId);

    /**
     * @author: jbz
     * @description: 删除角色对应的中间表
     * @date: 2023/1/9 14:51
     * @param: roleId
     * @return: void
    */
    @Delete("delete from role_permission where roleId=#{roleId}")
    void deleteRolePermission(int roleId);

    /**
     * @author: jbz
     * @description: 根据RoleId批量删除中间表
     * @date: 2023/1/9 15:25
     * @param: ids
     * @return: void
    */
    void batchDeleteRolePermissionByRoleIds(int[] ids);
    /**
     * @author: jbz
     * @description: 删除角色对应的中间表
     * @date: 2023/1/9 14:51
     * @param: roleId
     * @return: void
     */
    @Delete("delete from role_permission where permissionId=#{permissionId}")
    void deleteRolePermissionByPermissionId(int permissionId);

    /**
     * @author: jbz
     * @description: 根据permissionId批量删除中间表
     * @date: 2023/1/9 15:25
     * @param: ids
     * @return: void
     */
    void batchDeleteRolePermissionByPermissionIds(int[] ids);

    /**
     * @author: jbz
     * @description: 查询角色具有的权限
     * @date: 2023/1/9 16:32
     * @param: ids
     * @return: int[]
    */
    int[] queryAllPermissionByRoleIds(int[] ids);
}

