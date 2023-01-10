package com.jbz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbz.domain.Traveller;
import com.jbz.mapper.OrderTravellerMapper;
import com.jbz.mapper.TravellerMapper;
import com.jbz.service.IOrdersService;
import com.jbz.service.ITravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jbz
 * @date: 2023/1/7
 * @description:
 * @version: 1.0
 */
@Service
public class TravellerServiceImpl implements ITravellerService {
    @Autowired
    private TravellerMapper travellerMapper;
    @Autowired
    private OrderTravellerMapper orderTravellerMapper;
    /**
     * @author: jbz
     * @description: 分页查询
     * @date: 2023/1/7 9:32
     * @param: pageNum
     * @param: pageSize
     * @param: name
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Traveller>
    */
    @Override
    public PageInfo<Traveller> queryAllTraveller(int pageNum, int pageSize, String name) {
        //用mybatis提供的分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Traveller> travellerList = travellerMapper.queryAllTraveller(name);
        return new PageInfo<>(travellerList, pageSize);
    }

    /**
     * @author: jbz
     * @description: 新增旅客
     * @date: 2023/1/7 10:10
     * @param: traveller
     * @return: void
    */
    @Override
    public void addTraveller(Traveller traveller) {
        travellerMapper.addTraveller(traveller);
    }

    /**
     * @author: jbz
     * @description: 根据id查询旅客
     * @date: 2023/1/7 11:04
     * @param: id
     * @return: com.jbz.domain.Traveller
    */
    @Override
    public Traveller queryTravellerById(int id) {
        return travellerMapper.queryTravellerById(id);
    }

    /**
     * @author: jbz
     * @description: 修改旅客
     * @date: 2023/1/7 11:04
     * @param: traveller
     * @return: void
    */
    @Override
    public void updateTraveller(Traveller traveller) {
        travellerMapper.updateTraveller(traveller);
    }

    /**
     * @author: jbz
     * @description: 删除旅客信息（需要删除旅客与订单的中间表的对应记录）
     * @date: 2023/1/7 11:20
     * @param: id
     * @return: void
    */
    @Override
    public void deleteTraveler(int id) {
        //先删除中间表对应记录
        orderTravellerMapper.deleteOrderByTravellerId(id);
        //最后删除旅客
        travellerMapper.deleteTraveller(id);

    }
    /**
     * @author: jbz
     * @description: 批量删除旅客信息（需要删除旅客与订单的中间表的对应记录）
     * @date: 2023/1/7 11:19
     * @param: id
     * @return: void
     */
    @Override
    public void batchDeleteTraveler(int[] ids) {
        //先删除中间表对应记录
        orderTravellerMapper.batchDeleteOrderTravelerByTravellerIds(ids);
        //最后删除旅客
        travellerMapper.batchDeleteTraveller(ids);
    }
}
