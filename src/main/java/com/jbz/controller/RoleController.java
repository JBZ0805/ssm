package com.jbz.controller;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Permission;
import com.jbz.domain.Role;
import com.jbz.service.IRoleService;
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
 * @description:
 * @version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    //依赖注入
    @Autowired
    private IRoleService roleService;

    /**
     * @author: jbz
     * @description: 查询所有角色
     * @date: 2022/12/24 15:19
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryAllRole")
    public String queryAllRole(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "6") int pageSize,
                               @RequestParam(value = "roleDesc", required = false) String roleDesc, Model model) {
        //调用service的查询所有角色的方法
        PageInfo<Role> pageInfo = roleService.queryAllRole(pageNum, pageSize, roleDesc);
        //设置数据
        model.addAttribute("pageInfo", pageInfo);
        return "role-list";
    }

    /**
     * @author: jbz
     * @description: 获得添加角色所需要的数据
     * @date: 2023/1/9 13:20
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryData")
    public String queryData(Model model) {
        List<Permission> data = roleService.queryData();
        model.addAttribute("data", data);
        return "role-add";
    }

    /**
     * @author: jbz
     * @description: 添加角色
     * @date: 2022/12/24 15:58
     * @param: role
     * @return: java.lang.String
    */
    @RequestMapping("/add")
    public String addRole(Role role,int[] permissionIds) {
        //调用service的添加角色的方法
        roleService.addRole(role,permissionIds);
        //重定向至查询所有角色
        return "redirect:queryAllRole";
    }

    /**
     * @author: jbz
     * @description: 根据id查询role
     * @date: 2022/12/24 16:21
     * @param: id
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryRoleById")
    public String queryRoleById(Integer id, Model model) {
        //调用service的查询的方法
        Map<String, Object> data = roleService.queryRoleById(id);
        //设置数据
        model.addAttribute("data", data);
        return "role-edit";
    }
    /**
     * @author: jbz
     * @description: 修改role
     * @date: 2022/12/24 16:23
     * @param: role
     * @return: java.lang.String
    */
    @RequestMapping("/edit")
    public String updateRoleById(Role role,int[] permissionIds) {
        //调用service的修改的方法
        roleService.updateRoleById(role,permissionIds);
        //重定向至查询所有角色
        return "redirect:queryAllRole";
    }
    /**
     * @author: jbz
     * @description: 删除role
     * @date: 2022/12/24 16:24
     * @param: id
     * @return: java.lang.String
    */
    @RequestMapping("/del")
    public String deleteRoleById(Integer id) {
        //调用service的删除的方法
        roleService.deleteRoleById(id);
        //重定向至查询所有角色
        return "redirect:queryAllRole";
    }
    /**
     * @author: jbz
     * @description: 批量删除Role
     * @date: 2022/12/24 16:35
     * @param: ids
     * @return: java.lang.String
    */
    //TODO 没有考虑到外键约束，后续进行改进
    @RequestMapping("/batchDeleteRole")
    public String batchDeleteRole(int[] ids) {
        //调用service的批量删除
        roleService.batchDeleteRoleByIds(ids);
        //重定向至查询所有角色
        return "redirect:queryAllRole";
    }


}
