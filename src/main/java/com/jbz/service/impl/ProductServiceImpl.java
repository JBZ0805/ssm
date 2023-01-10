package com.jbz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbz.domain.Product;
import com.jbz.mapper.OrdersMapper;
import com.jbz.mapper.ProductMapper;
import com.jbz.service.IOrdersService;
import com.jbz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
@Service
public class ProductServiceImpl implements IProductService {
    //依赖注入mapper接口
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private IOrdersService ordersService;

    /**
     * @author: jbz
     * @description: 分页查询和条件查询
     * @date: 2022/12/23 19:01
     * @param: pageNum
     * @param: pageSize
     * @param: productName
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Product>
    */
    @Override
    public PageInfo<Product> queryAllProduct(int pageNum, int pageSize, String productName) {
        //用mybatis提供的分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = productMapper.queryAllProduct(productName);
        return new PageInfo<>(productList,pageSize);
    }

    /**
     * @author: jbz
     * @description: 新增一个产品
     * @date: 2022/12/22 16:18
     * @param: product
     * @return: void
     */
    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    /**
     * @author: jbz
     * @description: 根据id查询一条记录
     * @date: 2022/12/22 17:46
     * @param: id
     * @return: com.jbz.domain.Product
     */
    @Override
    public Product queryProductById(Integer id) {
        return productMapper.queryProductById(id);
    }

    /**
     * @author: jbz
     * @description: 修改产品信息
     * @date: 2022/12/22 18:14
     * @param: product
     * @return: void
     */
    @Override
    public void updateProductById(Product product) {
        productMapper.updateProductById(product);
    }

    /**
     * @author: jbz
     * @description: 根据id删除产品（也要删除订单表对应记录）
     * @date: 2022/12/22 18:55
     * @param: id
     * @return: void
     */
    @Override
    public void deleteProductById(Integer id) {
        //先根据id查询订单表对应的记录
        int[] orders = ordersMapper.queryOrdersByProductId(id);
        //删除对应的订单中间表与订单表
        ordersService.batchDeleteOrders(orders);
        //最后删除产品
        productMapper.deleteProduceById(id);
    }

    /**
     * @author: jbz
     * @description: 批量删除（也要删除订单表对应记录）
     * @date: 2022/12/23 9:07
     * @param: ids
     * @return: void
     */
    @Override
    public void batchDeleteProductByIds(int[] ids) {
        //先根据ids查询订单表对应的记录
        int[] orders = ordersMapper.queryOrdersByProductIds(ids);
        //删除对应的订单中间表与订单表
        ordersService.batchDeleteOrders(orders);
        //最后删除产品
        productMapper.batchDeleteProductByIds(ids);
    }

    /**
     * @author: jbz
     * @description: 批量上架
     * @date: 2022/12/23 9:30
     * @param: ids
     * @return: void
     */
    @Override
    public void batchOpenProductByIds(int[] ids) {
        productMapper.batchOpenProductByIds(ids);
    }

    /**
     * @author: jbz
     * @description: 批量下架
     * @date: 2022/12/23 9:33
     * @param: ids
     * @return: void
     */
    @Override
    public void batchCloseProductByIds(int[] ids) {
        productMapper.batchCloseProductByIds(ids);
    }
}
