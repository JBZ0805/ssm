package com.jbz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbz.domain.Member;
import com.jbz.domain.Orders;
import com.jbz.domain.Product;
import com.jbz.domain.Traveller;
import com.jbz.mapper.*;
import com.jbz.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: jbz
 * @date: 2023/1/8
 * @description:
 * @version: 1.0
 */
@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private TravellerMapper travellerMapper;
    @Autowired
    private OrderTravellerMapper orderTravellerMapper;

    /**
     * @author: jbz
     * @description: 查询所有的订单
     * @date: 2023/1/8 16:17
     * @param: pageNum
     * @param: pageSize
     * @param: orderNum
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Orders>
    */
    @Override
    public PageInfo<Orders> queryAllOrders(int pageNum, int pageSize, String orderNum) {
        //用mybatis提供的分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> ordersList = ordersMapper.queryAllOrders(orderNum);
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList, pageSize);
        pageInfo.setTotal(ordersList.size());
        return pageInfo;
    }

    /**
     * @author: jbz
     * @description: 查询订单时所需要的数据
     * @date: 2023/1/8 17:57
     * @param:
     * @return: java.util.Map<java.lang.String,java.lang.Object>
    */
    @Override
    public Map<String, Object> queryData() {
        //查询所有的产品
        List<Product> products = productMapper.queryAllProduct(null);
        //查询所有的成员
        List<Member> members = memberMapper.queryAllMember(null);
        //查询所有的的旅客
        List<Traveller> travellers = travellerMapper.queryAllTraveller(null);
        //创建Map对象
        Map<String, Object> map = new HashMap<>();
        map.put("products", products);
        map.put("members", members);
        map.put("travellers", travellers);
        return map;
    }

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
    @Override
    public void addOrder(Orders orders, int productId, int memberId, int[] travellerIds) {
        ordersMapper.addOrders(orders, productId, memberId);
        orderTravellerMapper.insertOrderTraveller(orders.getId(), travellerIds);
    }

    /**
     * @author: jbz
     * @description: 根据id查询订单信息以及所需要的数据
     * @date: 2023/1/9 8:06
     * @param: id
     * @return: java.util.Map<java.lang.String,java.lang.Object>
    */
    @Override
    public Map<String, Object> queryOrderById(int id) {
        Orders orders = ordersMapper.queryOrderById(id);
        Map<String, Object> map = queryData();
        map.put("orders", orders);
        return map;
    }

    /**
     * @author: jbz
     * @description: 修改订单以及订单与游客的中间表
     * @date: 2023/1/9 8:59
     * @param: orders
     * @param: productId
     * @param: memberId
     * @param: travellerIds
     * @return: void
    */
    @Override
    public void updateOrder(Orders orders, int productId, int memberId, int[] travellerIds) {
        ordersMapper.updateOrders(orders, productId, memberId);
        orderTravellerMapper.deleteOrderByOrderId(orders.getId());
        orderTravellerMapper.insertOrderTraveller(orders.getId(), travellerIds);
    }

    /**
     * @author: jbz
     * @description: 删除订单以及订单与游客的中间表的对应记录
     * @date: 2023/1/9 9:11
     * @param: id
     * @return: void
    */
    @Override
    public void deleteOrder(int id) {
        //先删除中间表对应记录
        orderTravellerMapper.deleteOrderByOrderId(id);
        //再删除订单
        ordersMapper.deleteOrder(id);
    }

    /**
     * @author: jbz
     * @description: 批量删除订单以及订单与游客的中间表的对应记录
     * @date: 2023/1/9 9:17
     * @param: ids
     * @return: void
    */
    @Override
    public void batchDeleteOrders(int[] ids) {
        //先批量删除中间表对应记录
        orderTravellerMapper.batchDeleteOrderTraveler(ids);
        //再批量删除订单
        ordersMapper.batchDeleteOrder(ids);
    }
}
