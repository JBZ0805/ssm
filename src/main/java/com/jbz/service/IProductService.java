package com.jbz.service;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Product;

import java.util.List;

/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
public interface IProductService {

    /**
     * @author: jbz
     * @description: 查询所有的产品
     * @date: 2022/12/22 14:03
     * @param:
     * @return: java.util.List<com.jbz.domain.Product>
    */
    PageInfo<Product> queryAllProduct(int pageNum, int pageSize, String productName);
    /**
     * @author: jbz
     * @description: 新增产品
     * @date: 2022/12/22 16:13
     * @param: product
     * @return: void
    */
    void addProduct(Product product);

    /**
     * @author: jbz
     * @description: 根据id查询一条记录
     * @date: 2022/12/22 17:45
     * @param: id
     * @return: com.jbz.domain.Product
    */
    Product queryProductById(Integer id);

    /**
     * @author: jbz
     * @description: 修改产品信息
     * @date: 2022/12/22 18:09
     * @param: product
     * @return: void
    */
    void updateProductById(Product product);

    /**
     * @author: jbz
     * @description: 根据id删除产品(也要删除订单表对应记录)
     * @date: 2022/12/22 18:54
     * @param: id
     * @return: void
    */
    void deleteProductById(Integer id);

    /**
     * @author: jbz
     * @description: 批量删除（也要删除订单表对应记录）
     * @date: 2022/12/23 9:06
     * @param: ids
     * @return: void
    */
    void batchDeleteProductByIds(int[] ids);

    /**
     * @author: jbz
     * @description: 批量上架
     * @date: 2022/12/23 9:25
     * @param: ids
     * @return: void
    */
    void batchOpenProductByIds(int[] ids);

    /**
     * @author: jbz
     * @description: 批量下架
     * @date: 2022/12/23 9:33
     * @param: ids
     * @return: void
    */
    void batchCloseProductByIds(int[] ids);
}
