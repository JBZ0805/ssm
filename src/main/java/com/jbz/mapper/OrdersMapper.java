package com.jbz.mapper;

import com.jbz.domain.Orders;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jbz
 * @date: 2023/1/8
 * @description:
 * @version: 1.0
 */
@Repository
public interface OrdersMapper {
    /**
     * @author: jbz
     * @description: 查询所有的订单
     * @date: 2023/1/8 14:47
     * @param: name
     * @return: java.util.List<com.jbz.domain.Member>
     */
    List<Orders> queryAllOrders(String orderNum);

    /**
     * @author: jbz
     * @description: 新增订单
     * @date: 2023/1/8 20:21
     * @param: orders
     * @param: productId
     * @param: memberId
     * @param: travellerIds
     * @return: void
     */
    int addOrders(@Param("order") Orders orders, @Param("productId") int productId, @Param("memberId") int memberId);

    /**
     * @author: jbz
     * @description: 根据id查询订单信息
     * @date: 2023/1/9 8:07
     * @param: id
     * @return: com.jbz.domain.Orders
     */
    Orders queryOrderById(int id);

    /**
     * @author: jbz
     * @description: 修改订单
     * @date: 2023/1/9 9:00
     * @param: orders
     * @param: productId
     * @param: memberId
     * @return: void
     */
    void updateOrders(@Param("order") Orders orders, @Param("productId") int productId, @Param("memberId") int memberId);

    /**
     * @author: jbz
     * @description: 删除订单
     * @date: 2023/1/9 9:10
     * @param: id
     * @return: void
     */
    @Delete("delete from orders where id=#{id}")
    void deleteOrder(int id);

    /**
     * @author: jbz
     * @description: 批量删除订单
     * @date: 2023/1/9 9:22
     * @param: ids
     * @return: void
    */
    void batchDeleteOrder(int[] ids);

    /**
     * @author: jbz
     * @description: 根据多个产品id查询对应的订单
     * @date: 2023/1/9 9:29
     * @param: productId
     * @return: com.jbz.domain.Orders
    */
    int[] queryOrdersByProductIds(int[] productIds);

    /**
     * @author: jbz
     * @description: 根据1个产品id查询对应的订单
     * @date: 2023/1/9 9:35
     * @param: productId
     * @return: int[]
     */
    @Select("select id from orders where productId=#{productId}")
    int[] queryOrdersByProductId(int productId);


    /**
     * @author: jbz
     * @description: 根据memberId查询对应的订单
     * @date: 2023/1/9 9:38
     * @param: memberId
     * @return: int[]
     */
    @Select("select id from orders where memberId=#{memberId}")
    int[] queryOrdersByMemberId(int memberId);

    /**
     * @author: jbz
     * @description: 根据多个memberId查询对应的订单
     * @date: 2023/1/9 9:41
     * @param: memberIds
     * @return: int[]
    */
    int[] queryOrdersByMemberIds(int[] memberIds);

}
