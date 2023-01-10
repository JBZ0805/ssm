package com.jbz.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: jbz
 * @date: 2023/1/5
 * @description:
 * @version: 1.0
 */
@Repository
public interface UserRoleMapper {
    /**
     * @author: jbz
     * @description: 查询用户具有的角色
     * @date: 2023/1/9 16:30
     * @param: userId
     * @return: int[]
    */
    @Select("select roleId from user_role where userId=#{userId}")
    int[] queryRolesByUserId(int userId);

    /**
     * @author: jbz
     * @description: 添加用户的角色
     * @date: 2023/1/5 21:30
     * @param: userId
     * @param: roleId
     * @return: void
    */
    void insertUserRole(@Param("userId") int userId, @Param("array") int[] roleId);

    /**
     * @author: jbz
     * @description: 删除用户的角色
     * @date: 2023/1/6 9:23
     * @param: userId
     * @return: void
    */
    void deleteUserRole(int userId);

    /**
     * @author: jbz
     * @description: 删除用户的角色
     * @date: 2023/1/6 9:23
     * @param: roleId
     * @return: void
     */
    @Delete("delete from user_role where roleId=#{roleId}")
    void deleteUserRoleByRoleId(int roleId);

    /**
     * @author: jbz
     * @description: 批量删除用户的角色
     * @date: 2023/1/6 10:38
     * @param: ids
     * @return: void
    */
    void batchDeleteUserRole(int[] ids);
     /**
     * @author: jbz
     * @description: 批量删除用户的角色
     * @date: 2023/1/6 10:38
     * @param: ids
     * @return: void
     */
    void batchDeleteUserRoleByRoleIds(int[] ids);
}
