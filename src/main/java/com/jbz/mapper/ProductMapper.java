package com.jbz.mapper;

import com.jbz.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
@Repository
public interface ProductMapper {
    /**
     * @author: jbz
     * @description: 查询所有的产品列表
     * @date: 2022/12/22 14:06
     * @param: productName
     * @return: java.util.List<com.jbz.domain.Product>
    */
    //@Select("select * from product")
    List<Product> queryAllProduct(String productName);
    /**
     * @author: jbz
     * @description: 新增一个产品
     * @date: 2022/12/22 16:17
     * @param: product
     * @return: void
    */
    //@Insert("insert into product values (#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void addProduct(Product product);
    /**
     * @author: jbz
     * @description: 根据id查询一条记录
     * @date: 2022/12/22 17:47
     * @param: id
     * @return: void
    */
    //@Select("select * from product where id=#{id}")
    Product queryProductById(Integer id);

    /**
     * @author: jbz
     * @description: 修改产品信息
     * @date: 2022/12/22 18:10
     * @param: product
     * @return: void
    */
//    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void updateProductById(Product product);

    /**
     * @author: jbz
     * @description: 根据id删除产品
     * @date: 2022/12/22 18:56
     * @param: id
     * @return: void
    */
    //@Delete("delete from product where id =#{id}")
    void deleteProduceById(Integer id);

    /**
     * @author: jbz
     * @description: 批量删除
     * @date: 2022/12/23 9:06
     * @param: ids
     * @return: void
    */
    void batchDeleteProductByIds(int[] ids);

    /**
     * @author: jbz
     * @description: 批量上架
     * @date: 2022/12/23 9:27
     * @param: ids
     * @return: void
    */
    void batchOpenProductByIds(int[] ids);

    /**
     * @author: jbz
     * @description: 批量下架
     * @date: 2022/12/23 9:34
     * @param: ids
     * @return: void
    */
    void batchCloseProductByIds(int[] ids);


}
