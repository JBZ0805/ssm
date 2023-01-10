package com.jbz.service;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Orders;

import java.util.Map;


/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
public interface IOrdersService {

    /**
     * @author: jbz
     * @description: 查询所有的订单
     * @date: 2023/1/8 16:16
     * @param: pageNum
     * @param: pageSize
     * @param: orderNum
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Orders>
    */
    PageInfo<Orders> queryAllOrders(int pageNum, int pageSize, String orderNum);

    /**
     * @author: jbz
     * @description: 查询添加订单所需要的数据
     * @date: 2023/1/8 16:48
     * @param:
     * @return: java.util.Map<java.lang.String,java.lang.Object>
    */
    Map<String, Object> queryData();

    /**
     * @author: jbz
     * @description: 新增订单以及订单与游客的中间表
     * @date: 2023/1/8 20:21
     * @param: orders
     * @param: productId
     * @param: memberId
     * @param: travellerIds
     * @return: void
    */
    void addOrder(Orders orders, int productId, int memberId, int[] travellerIds);

    /**
     * @author: jbz
     * @description: 根据id查询订单信息
     * @date: 2023/1/9 8:05
     * @param: id
     * @return: java.util.Map<java.lang.String,java.lang.Object>
    */
    Map<String, Object> queryOrderById(int id);

    /**
     * @author: jbz
     * @description: 修改订单以及订单与游客的中间表
     * @date: 2023/1/9 8:58
     * @param: orders
     * @param: productId
     * @param: memberId
     * @param: travellerIds
     * @return: void
    */
    void updateOrder(Orders orders, int productId, int memberId, int[] travellerIds);

    /**
     * @author: jbz
     * @description: 删除订单以及订单与游客的中间表的对应记录
     * @date: 2023/1/9 9:10
     * @param: id
     * @return: void
    */
    void deleteOrder(int id);

    /**
     * @author: jbz
     * @description: 批量删除订单以及订单与游客的中间表的对应记录
     * @date: 2023/1/9 9:16
     * @param: ids
     * @return: void
    */
    void batchDeleteOrders(int[] ids);




}
