package com.jbz.controller;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Role;
import com.jbz.domain.User;
import com.jbz.service.IRoleService;
import com.jbz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Map;

/**
 * @author: jbz
 * @date: 2022/12/24
 * @description: 用户接口
 * @version: 2.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * @author: jbz
     * @description: 分页查询所有用户
     * @date: 2023/1/5 20:05
     * @param: pageNum
     * @param: pageSize
     * @param: username
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping("/findAllUser")
    public String queryAllUser(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "6") int pageSize,
                               @RequestParam(value = "username", required = false) String username, Model model) {
        //调用service的查询产品列表的方法
        PageInfo<User> pageInfo = userService.queryAllUser(pageNum, pageSize, username);
        //设置数据 保存容器中
        model.addAttribute("pageInfo", pageInfo);
        //返回给视图
        return "user-list";
    }


    /**
     * @author: jbz
     * @description: 跳转添加用户
     * @date: 2023/1/5 20:43
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping("/add")
    public String add(Model model) {
        //调用roleService查询所有角色的方法
        List<Role> roleList = userService.queryData();
        //设置数据 保存容器中
        model.addAttribute("roleList", roleList);
        //返回给视图
        return "user-add";
    }

    /**
     * @author: jbz
     * @description: 添加用户
     * @date: 2023/1/6 8:15
     * @param: user
     * @param: roleIds
     * @return: java.lang.String
     */
    @RequestMapping("/save")
    public String addUser(User user, int[] roleIds) {
        userService.addUser(user, roleIds);
        return "redirect:findAllUser";
    }

    /**
     * @author: jbz
     * @description: 根据id查询用户
     * @date: 2023/1/6 8:16
     * @param: id
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping("/queryUserById")
    public String queryUserById(int id, Model model) {
        //调用Service中查询用户以及所有的角色的方法
        Map<String, Object> result = userService.queryUserById(id);
        //设置数据 保存容器中
        model.addAttribute("result", result);
        return "user-edit";
    }

    /**
     * @author: jbz
     * @description: 编辑用户
     * @date: 2023/1/6 9:11
     * @param: user
     * @param: roleIds
     * @return: java.lang.String
     */
    @RequestMapping("/edit")
    public String updateUser(User user, int[] roleIds) {
        userService.updateUser(user, roleIds);
        return "redirect:findAllUser";
    }

    /**
     * @author: jbz
     * @description: 删除用户
     * @date: 2023/1/6 10:01
     * @param: id
     * @return: java.lang.String
     */
    @RequestMapping("/delUserById")
    public String deleteUserById(int id) {
        userService.deleteUserById(id);
        return "redirect:findAllUser";
    }
    /**
     * @author: jbz
     * @description: 批量删除用户
     * @date: 2023/1/6 10:30
     * @param: ids
     * @return: java.lang.String
     */
    @RequestMapping("/batchDeleteUser")
    public String batchDeleteUser(int[] ids) {
        userService.batchDeleteUser(ids);
        return "redirect:findAllUser";
    }
}
