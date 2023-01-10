package com.jbz.controller;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Permission;
import com.jbz.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: jbz
 * @date: 2023/1/7
 * @description:
 * @version: 1.0
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;


    /**
     * @author: jbz
     * @description: 分页查询
     * @date: 2023/1/8 14:53
     * @param: pageNum
     * @param: pageSize
     * @param: orderNum
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryAllPermission")
    public String queryAllOrders(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "6") int pageSize,
                              @RequestParam(value = "permissionName", required = false) String permissionName , Model model) {
        //调用service的查询日志的方法
        PageInfo<Permission> pageInfo = permissionService.queryAllPermission(pageNum, pageSize, permissionName);
        //设置数据 保存容器中
        model.addAttribute("pageInfo", pageInfo);
        //返回给视图
        return "permission-list";
    }

    /**
     * @author: jbz
     * @description: 新增权限
     * @date: 2023/1/9 16:02
     * @param: permission
     * @return: java.lang.String
    */
    @RequestMapping("/add")
    public String addPermission(Permission permission) {
        permissionService.insertPermission(permission);
        return "redirect:queryAllPermission";
    }

    /**
     * @author: jbz
     * @description: 根据id查询
     * @date: 2023/1/9 16:06
     * @param: id
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryPermissionById")
    public String queryPermissionById(int id, Model model) {
        Permission permission = permissionService.queryPermissionById(id);
        model.addAttribute("permission", permission);
        return "permission-edit";
    }

    /**
     * @author: jbz
     * @description: 修改权限
     * @date: 2023/1/9 16:07
     * @param: permission
     * @return: java.lang.String
    */
    @RequestMapping("/save")
    public String updatePermission(Permission permission) {
        permissionService.updatePermission(permission);
        return "redirect:queryAllPermission";
    }
    /**
     * @author: jbz
     * @description: 删除权限
     * @date: 2023/1/9 16:11
     * @param: id
     * @return: java.lang.String
    */
    @RequestMapping("/del")
    public String updatePermission(int id) {
        permissionService.deletePermissionById(id);
        return "redirect:queryAllPermission";
    }
    /**
     * @author: jbz
     * @description: 批量删除
     * @date: 2023/1/9 16:11
     * @param: ids
     * @return: java.lang.String
    */
    @RequestMapping("/batchDeletePermission")
    public String updatePermission(int[] ids) {
        permissionService.batchDeletePermissionByIds(ids);
        return "redirect:queryAllPermission";
    }






}
