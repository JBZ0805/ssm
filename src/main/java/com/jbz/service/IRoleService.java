package com.jbz.service;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Permission;
import com.jbz.domain.Role;

import java.util.List;
import java.util.Map;

/**
 * @author: jbz
 * @date: 2022/12/24
 * @description:
 * @version: 1.0
 */
public interface IRoleService {

    /**
     * @author: jbz
     * @description: 分页查询
     * @date: 2023/1/9 12:06
     * @param: pageNum
     * @param: pageSize
     * @param: roleDesc
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Role>
    */
    PageInfo<Role> queryAllRole(int pageNum, int pageSize, String roleDesc);

    /**
     * @author: jbz
     * @description: 查询添加角色所需要的权限
     * @date: 2023/1/9 13:54
     * @param:
     * @return: java.util.List<com.jbz.domain.Permission>
    */
    List<Permission> queryData();

    /**
     * @author: jbz
     * @description: 添加角色以及角色与权限的中间表
     * @date: 2022/12/24 15:57
     * @param: role
     * @param: permissionIds
     * @return: void
    */
    void addRole(Role role,int[] permissionIds);

   /**
    * @author: jbz
    * @description: 根据id查询角色以及所需要的数据
    * @date: 2023/1/9 14:24
    * @param: id
    * @return: java.util.Map<java.lang.String,java.lang.Object>
   */
    Map<String,Object> queryRoleById(Integer id);

    /**
     * @author: jbz
     * @description: 修改role
     * @date: 2022/12/24 16:18
     * @param: role
     * @return: void
    */
    void updateRoleById(Role role,int[] permissionIds);

    /**
     * @author: jbz
     * @description: 根据id删除role
     * @date: 2022/12/24 16:18
     * @param: id
     * @return: void
    */
    void deleteRoleById(Integer id);

    /**
     * @author: jbz
     * @description: 批量删除role
     * @date: 2022/12/24 16:36
     * @param: ids
     * @return: void
    */
    void batchDeleteRoleByIds(int[] ids);
}
