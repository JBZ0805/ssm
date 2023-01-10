package com.jbz.controller;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Orders;
import com.jbz.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author: jbz
 * @date: 2023/1/7
 * @description:
 * @version: 1.0
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService ordersService;

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
    @RequestMapping("/queryAllOrders")
    public String queryAllOrders(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "6") int pageSize,
                              @RequestParam(value = "orderNum", required = false) String orderNum , Model model) {
        //调用service的查询日志的方法
        PageInfo<Orders> pageInfo = ordersService.queryAllOrders(pageNum, pageSize, orderNum);
        //设置数据 保存容器中
        model.addAttribute("pageInfo", pageInfo);
        //返回给视图
        return "orders-list";
    }

    /**
     * @author: jbz
     * @description: 查询添加订单时所需要的数据
     * @date: 2023/1/8 18:01
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryData")
    public String queryData(Model model) {
        Map<String, Object> map = ordersService.queryData();
        //设置数据 保存到容器中
        model.addAttribute("data", map);
        //返回给视图
        return "orders-add";
    }

    /**
     * @author: jbz
     * @description: 新增一个订单
     * @date: 2023/1/9 8:19
     * @param: order
     * @param: productId
     * @param: memberId
     * @param: travellerIds
     * @return: java.lang.String
    */
    @RequestMapping("/add")
    public String addOrder(Orders order,int productId,int memberId,int[] travellerIds) {
        ordersService.addOrder(order, productId, memberId, travellerIds);
        return "redirect:queryAllOrders";
    }

    /**
     * @author: jbz
     * @description: 根据id查询订单
     * @date: 2023/1/9 8:19
     * @param: id
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryOrdersById")
    public String queryOrdersById(int id, Model model) {
        Map<String, Object> map = ordersService.queryOrderById(id);
        model.addAttribute("data", map);
        return "orders-edit";
    }
    /**
     * @author: jbz
     * @description: 修改订单信息
     * @date: 2023/1/9 8:57
     * @param: order
     * @param: productId
     * @param: memberId
     * @param: travellerIds
     * @return: java.lang.String
    */
    @RequestMapping("/edit")
    public String updateOrder(Orders order,int productId,int memberId,int[] travellerIds) {
        ordersService.updateOrder(order, productId, memberId, travellerIds);
        return "redirect:queryAllOrders";
    }

    /**
     * @author: jbz
     * @description: 删除订单
     * @date: 2023/1/9 9:10
     * @param: id
     * @return: java.lang.String
    */
    @RequestMapping("/delOrderById")
    public String deleteOrder(int id) {
        ordersService.deleteOrder(id);
        return "redirect:queryAllOrders";
    }
    /**
     * @author: jbz
     * @description: 批量删除订单以及订单与游客的中间表的对应记录
     * @date: 2023/1/9 9:15
     * @param: ids
     * @return: java.lang.String
    */
    @RequestMapping("/batchDeleteOrders")
    public String batchDeleteOrders(int[] ids){
        ordersService.batchDeleteOrders(ids);
        return "redirect:queryAllOrders";
    }



}
