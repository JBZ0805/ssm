package com.jbz.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: jbz
 * @date: 2023/1/8
 * @description:
 * @version: 1.0
 */
@Repository
public interface OrderTravellerMapper {

    /**
     * @author: jbz
     * @description: 新增记录（订单游客中间表）
     * @date: 2023/1/8 20:53
     * @param: id
     * @param: travellerIds
     * @return: void
    */
    void insertOrderTraveller(@Param("orderId") int orderId, @Param("array") int[] travellerIds);

    /**
     * @author: jbz
     * @description: 根据orderId删除对应的记录
     * @date: 2023/1/9 9:04
     * @param: orderId
     * @return: void
    */
    @Delete("delete from order_traveller where orderId=#{orderId}")
    void deleteOrderByOrderId(int orderId);

    /**
     * @author: jbz
     * @description: 根据travellerId删除对应的记录
     * @date: 2023/1/9 9:04
     * @param: orderId
     * @return: void
     */
    @Delete("delete from order_traveller where travellerId=#{travellerId}")
    void deleteOrderByTravellerId(int travellerId);

    /**
     * @author: jbz
     * @description: 根据travellerId批量删除
     * @date: 2023/1/9 9:19
     * @param: ids
     * @return: void
     */
    void batchDeleteOrderTravelerByTravellerIds(int[] ids);

    /**
     * @author: jbz
     * @description: 批量删除
     * @date: 2023/1/9 9:19
     * @param: ids
     * @return: void
    */
    void batchDeleteOrderTraveler(int[] ids);



}
