package com.jbz.mapper;

import com.jbz.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jbz
 * @date: 2023/1/8
 * @description:
 * @version: 1.0
 */
@Repository
public interface PermissionMapper {
    /**
     * @author: jbz
     * @description: 查询所有的权限
     * @date: 2023/1/8 14:47
     * @param: name
     * @return: java.util.List<com.jbz.domain.Permission>
     */
    List<Permission> queryAllPermission(String permissionName);

    /**
     * @author: jbz
     * @description: 新增权限
     * @date: 2023/1/9 15:50
     * @param: permission
     * @return: void
    */
    @Insert("insert into permission values (#{id},#{permissionName},#{url})")
    void insertPermission(Permission permission);

    /**
     * @author: jbz
     * @description: 根据id查询权限
     * @date: 2023/1/9 15:55
     * @param: id
     * @return: com.jbz.domain.Permission
    */
    @Select("select * from permission where id=#{id}")
    Permission queryPermissionById(int id);

    /**
     * @author: jbz
     * @description: 修改权限
     * @date: 2023/1/9 15:51
     * @param: permission
     * @return: void
    */
    @Update("update permission set permissionName=#{permissionName},url=#{url} where id=#{id}")
    void updatePermission(Permission permission);

    /**
     * @author: jbz
     * @description: 删除权限
     * @date: 2023/1/9 15:52
     * @param: id
     * @return: void
    */
    @Delete("delete from permission where id=#{id}")
    void deletePermissionById(int id);

    /**
     * @author: jbz
     * @description: 批量删除权限
     * @date: 2023/1/9 15:53
     * @param: ids
     * @return: void
    */
    void batchDeletePermissionByIds(int[] ids);

    /**
     * @author: jbz
     * @description: 查询权限具有哪些请求路径
     * @date: 2023/1/9 16:36
     * @param: ids
     * @return: java.lang.String[]
    */
    String[] queryUrlByPermissionIds(int[] ids);



}
