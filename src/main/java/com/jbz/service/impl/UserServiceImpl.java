package com.jbz.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbz.domain.Permission;
import com.jbz.domain.Role;
import com.jbz.domain.User;
import com.jbz.mapper.*;
import com.jbz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;



    /**
     * @author: jbz
     * @description: 分页查询+条件查询
     * @date: 2023/1/5 15:16
     * @param: pageNum
     * @param: pageSize
     * @param: username
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.User>
     */
    @Override
    public PageInfo<User> queryAllUser(int pageNum, int pageSize, String username) {
        //用mybatis提供的分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.queryAllUser(username);
        return new PageInfo<>(userList, pageSize);
    }

    /**
     * @author: jbz
     * @description: 新增用户以及对应的角色
     * @date: 2023/1/5 21:23
     * @param: user
     * @param: roleIds
     * @return: void
     */
    @Override
    public void addUser(User user, int[] roleIds) {
        //对密码进行加密处理
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.insertUser(user);
        userRoleMapper.insertUserRole(user.getId(), roleIds);
    }

    /**
     * @author: jbz
     * @description: 根据id查询用户并查出所有的角色
     * @date: 2023/1/6 8:17
     * @param: id
     * @return: com.jbz.domain.User
     */
    @Override
    public Map<String, Object> queryUserById(int id) {
        //创建Map对象
        Map<String, Object> result = new HashMap<>();
        User user = userMapper.queryUserById(id);
        List<Role> roles = roleMapper.queryAllRole(null);
        //将结果封装到map中
        result.put("user", user);
        result.put("roles", roles);
        return result;
    }


    /**
     * @author: jbz
     * @description: 更新用户以及对应的角色关系
     * @date: 2023/1/6 9:17
     * @param: user
     * @param: roleIds
     * @return: void
     */
    @Override
    public void updateUser(User user, int[] roleIds) {
        //对密码进行加密处理
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        //更新用户
        userMapper.updateUser(user);
        //更新用户对应的中间表user-role(用户对应的角色关系)
        //由于涉及到一对多的update,这里的简单做法是先删除用户id对应的角色
        //再对其进行添加
        userRoleMapper.deleteUserRole(user.getId());
        userRoleMapper.insertUserRole(user.getId(), roleIds);
    }

    /**
     * @author: jbz
     * @description: 删除用户以及对应的角色关系
     * @date: 2023/1/6 10:03
     * @param: id
     * @return: void
     */
    @Override
    public void deleteUserById(int id) {
        //先删除用户对应的角色关系
        userRoleMapper.deleteUserRole(id);
        //再删除用户
        userMapper.deleteUserById(id);
    }

    /**
     * @author: jbz
     * @description: 批量删除用户以及对应的角色关系
     * @date: 2023/1/6 10:36
     * @param: ids
     * @return: void
     */
    @Override
    public void batchDeleteUser(int[] ids) {
        //先批量删除用户对应的角色关系
        userRoleMapper.batchDeleteUserRole(ids);
        //再批量删除用户
        userMapper.batchDeleteUser(ids);
    }

    /**
     * @author: jbz
     * @description: 个人登录
     * @date: 2022/12/24 21:57
     * @param: username
     * @return: com.jbz.domain.User
     */
    @Override
    public User login(String username, String password) {
        //调用userMapper的根据用户名查user的方法
        User user = userMapper.queryUserByUsername(username);
        //判断user是否为null
        if (user != null) {
            //判断密码是否一致
            if (passwordEncoder.matches(password,user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    /**
     * @author: jbz
     * @description: 查询个人信息
     * @date: 2023/1/6 19:28
     * @param: id
     * @return: com.jbz.domain.User
     */
    @Override
    public User queryPersonalUserById(int id) {
        return userMapper.queryPersonalUserById(id);
    }

    /**
     * @author: jbz
     * @description: 修改个人信息
     * @date: 2023/1/6 19:41
     * @param: user
     * @return: void
     */
    @Override
    public void updatePersonalUser(User user) {
        //对密码进行加密处理
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.updateUser(user);
    }

    /**
     * @author: jbz
     * @description: 更新个人头像
     * @date: 2023/1/6 18:44
     * @param: user
     * @return: void
     */
    @Override
    public void updateUserImg(User user) {
        userMapper.updateUserImg(user);
    }

    /**
     * @author: jbz
     * @description: 查询添加用户所需要的数据
     * @date: 2023/1/9 12:15
     * @param:
     * @return: void
    */
    @Override
    public List<Role> queryData() {
        return roleMapper.queryAllRole(null);
    }

    /**
     * @author: jbz
     * @description: 根据id查询用户具有哪些请求路径
     * @date: 2023/1/9 16:38
     * @param: id
     * @return: java.lang.String[]
    */
    @Override
    public String[] queryUserPermissionsById(int id) {
        //查询用户具有哪些角色
        int[] roleIds = userRoleMapper.queryRolesByUserId(id);
        //查询这些角色具有哪些权限
        int[] permissionIds = rolePermissionMapper.queryAllPermissionByRoleIds(roleIds);
        return permissionMapper.queryUrlByPermissionIds(permissionIds);
    }
}
