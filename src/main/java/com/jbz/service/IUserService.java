package com.jbz.service;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Permission;
import com.jbz.domain.Role;
import com.jbz.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author: jbz
 * @date: 2022/12/24
 * @description:
 * @version: 1.0
 */
public interface IUserService {
    /**
     * @author: jbz
     * @description: 分页查询
     * @date: 2023/1/5 18:26
     * @param: pageNum
     * @param: pageSize
     * @param: username
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.User>
    */
    PageInfo<User> queryAllUser(int pageNum, int pageSize, String username);

    /**
     * @author: jbz
     * @description: 新增用户以及对应的角色
     * @date: 2023/1/5 21:22
     * @param: user
     * @param: roleIds
     * @return: void
    */
    void addUser(User user, int[] roleIds);

    /**
     * @author: jbz
     * @description: 根据id查询用户并查出所有的角色
     * @date: 2023/1/6 8:16
     * @param: id
     * @return: java.util.Map<java.lang.String,java.lang.Object>
    */
    Map<String, Object> queryUserById(int id);
    /**
     * @author: jbz
     * @description: 更新用户以及对应的角色关系
     * @date: 2023/1/6 9:16
     * @param: user
     * @param: roleIds
     * @return: void
    */
    void updateUser(User user, int[] roleIds);

    /**
     * @author: jbz
     * @description: 删除用户以及对应的角色关系
     * @date: 2023/1/6 10:02
     * @param: id
     * @return: void
    */
    void deleteUserById(int id);

    /**
     * @author: jbz
     * @description: 批量删除用户以及对应的角色关系
     * @date: 2023/1/6 10:36
     * @param: ids
     * @return: void
    */
    void batchDeleteUser(int[] ids);

    /**
     * @author: jbz
     * @description: 个人登录
     * @date: 2022/12/24 21:55
     * @param: username
     * @param: password
     * @return: com.jbz.domain.User
     */
    User login(String username, String password);

    /**
     * @author: jbz
     * @description: 查询个人信息
     * @date: 2023/1/6 19:28
     * @param: id
     * @return: com.jbz.domain.User
     */
    User queryPersonalUserById(int id);

    /**
     * @author: jbz
     * @description: 修改个人信息
     * @date: 2023/1/6 19:37
     * @param: user
     * @return: void
     */
    void updatePersonalUser(User user);

    /**
     * @author: jbz
     * @description: 更新个人头像
     * @date: 2023/1/6 18:43
     * @param: user
     * @return: void
    */
    void updateUserImg(User user);

    /**
     * @author: jbz
     * @description: 查询添加用户时所需要的数据
     * @date: 2023/1/9 12:15
     * @param:
     * @return: List
    */
    List<Role> queryData();

    /**
     * @author: jbz
     * @description: 根据id查询用户具有哪些请求路径
     * @date: 2023/1/9 16:24
     * @param: id
     * @return: java.lang.String[]
    */
    String[] queryUserPermissionsById(int id);

}

