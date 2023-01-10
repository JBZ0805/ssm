package com.jbz.controller;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Product;
import com.jbz.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    //依赖注入service接口
    @Autowired
    private IProductService productService;

    /**
     * @author: jbz
     * @description: 分页查询+条件查询
     * @date: 2022/12/23 18:50
     * @param: pageNum
     * @param: pageSize
     * @param: productName
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping("/queryProductList")
    public String queryProductList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "4") int pageSize,
                                   @RequestParam(value = "productName", required = false) String productName, Model model) {
        //调用service的查询产品列表的方法
        PageInfo<Product> pageInfo = productService.queryAllProduct(pageNum, pageSize, productName);
        //设置数据 保存容器中
        model.addAttribute("pageInfo", pageInfo);
        //返回给视图
        return "product-list";
    }

    /**
     * @author: jbz
     * @description: 新增一个产品
     * @date: 2022/12/22 16:18
     * @param: product
     * @return: java.lang.String
     */
    @RequestMapping("/add")
    public String addProduct(Product product) {
        //调用service的新增
        productService.addProduct(product);
        //重定向至查询所有产品列表
        return "redirect:queryProductList";
    }

    /**
     * @author: jbz
     * @description: 根据id查询一条产品记录
     * @date: 2022/12/22 16:50
     * @param: id
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping("/queryProductById")
    public String queryProductById(Integer id, Model model) {
        //调用service的查询一条记录的方法
        Product product = productService.queryProductById(id);
        //设置数据 默认存在request容器中
        model.addAttribute("product", product);
        //重定向至编辑产品页面
        return "product-edit";
    }

    /**
     * @author: jbz
     * @description: 修改产品信息
     * @date: 2022/12/22 18:06
     * @param: product
     * @return: java.lang.String
     */
    @RequestMapping("/edit")
    public String editProduct(Product product) {
        //调用service的修改
        productService.updateProductById(product);
        //重定向至查询所有产品列表
        return "redirect:queryProductList";
    }

    /**
     * @author: jbz
     * @description: 删除产品
     * @date: 2022/12/22 18:52
     * @param: id
     * @return: java.lang.String
     */
    @RequestMapping("/delProductById")
    public String deleteProductById(Integer id) {
        //调用service的删除
        productService.deleteProductById(id);
        //重定向至查询所有产品列表
        return "redirect:queryProductList";
    }

    /**
     * @author: jbz
     * @description: 批量删除
     * @date: 2022/12/23 9:04
     * @param: ids
     * @return: java.lang.String
     */
    @RequestMapping("/batchDeleteProduct")
    public String batchDeleteProduct(int[] ids) {
        //调用service的批量删除
        productService.batchDeleteProductByIds(ids);
        //重定向至查询所有产品列表
        return "redirect:queryProductList";
    }

    /**
     * @author: jbz
     * @description: 批量上架
     * @date: 2022/12/23 9:26
     * @param: ids
     * @return: java.lang.String
     */
    @RequestMapping("/batchOpenProduct")
    public String batchOpenProduct(int[] ids) {
        //调用service的批量上架
        productService.batchOpenProductByIds(ids);
        //重定向至查询所有产品列表
        return "redirect:queryProductList";
    }

    /**
     * @author: jbz
     * @description: 批量下架
     * @date: 2022/12/23 9:32
     * @param: ids
     * @return: java.lang.String
     */
    @RequestMapping("/batchCloseProduct")
    public String batchCloseProduct(int[] ids) {
        //调用service的批量下架
        productService.batchCloseProductByIds(ids);
        //重定向至查询所有产品列表
        return "redirect:queryProductList";
    }
}
