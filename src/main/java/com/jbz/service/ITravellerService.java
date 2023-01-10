package com.jbz.service;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Traveller;


/**
 * @author: jbz
 * @date: 2023/1/7
 * @description:
 * @version: 1.0
 */
public interface ITravellerService {
    /**
     * @author: jbz
     * @description: 分页查询
     * @date: 2023/1/7 9:31
     * @param: pageNum
     * @param: pageSize
     * @param: name
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Traveller>
    */
    PageInfo<Traveller> queryAllTraveller(int pageNum, int pageSize, String name);

    /**
     * @author: jbz
     * @description: 新增旅客
     * @date: 2023/1/7 10:10
     * @param: traveller
     * @return: void
    */
    void addTraveller(Traveller traveller);
    /**
     * @author: jbz
     * @description: 根据id查询旅客
     * @date: 2023/1/7 10:58
     * @param: id
     * @return: com.jbz.domain.Traveller
     */
    Traveller queryTravellerById(int id);

    /**
     * @author: jbz
     * @description: 修改旅客信息
     * @date: 2023/1/7 10:59
     * @param: traveller
     * @return: void
     */
    void updateTraveller(Traveller traveller);

    /**
     * @author: jbz
     * @description: 删除旅客信息（需要删除旅客与订单的中间表的对应记录）
     * @date: 2023/1/7 11:19
     * @param: id
     * @return: void
    */
    void deleteTraveler(int id);

    /**
     * @author: jbz
     * @description: 批量删除旅客信息（需要删除旅客与订单的中间表的对应记录）
     * @date: 2023/1/7 11:19
     * @param: id
     * @return: void
     */
    void batchDeleteTraveler(int[] ids);




}

