package com.jbz.controller;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Traveller;
import com.jbz.service.ITravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



/**
 * @author: jbz
 * @date: 2023/1/6
 * @description:
 * @version: 1.0
 */
@Controller
@RequestMapping("/traveller")
public class TravellerController {
    //依赖注入service接口
    @Autowired
    private ITravellerService travellerService;

    /**
     * @author: jbz
     * @description: 分页查询+条件查询
     * @date: 2023/1/6 22:20
     * @param: pageNum
     * @param: pageSize
     * @param: name
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping("/queryAllTraveller")
    public String queryProductList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "6") int pageSize,
                                   @RequestParam(value = "name", required = false) String name, Model model) {
        //调用service的查询旅客列表的方法
        PageInfo<Traveller> pageInfo = travellerService.queryAllTraveller(pageNum, pageSize, name);
        //设置数据 保存容器中
        model.addAttribute("pageInfo", pageInfo);
        //返回给视图
        return "traveller-list";
    }

    /**
     * @author: jbz
     * @description: 添加旅客信息
     * @date: 2023/1/8 19:56
     * @param: traveller
     * @return: java.lang.String
    */
    @RequestMapping("/addTraveller")
    public String addTraveller(Traveller traveller) {
        travellerService.addTraveller(traveller);
        return "redirect:queryAllTraveller";
    }

    /**
     * @author: jbz
     * @description: 根据id查询旅客
     * @date: 2023/1/7 10:19
     * @param: id
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping("/queryTravellerById")
    public String queryTravellerById(int id, Model model) {
        Traveller traveller = travellerService.queryTravellerById(id);
        model.addAttribute("traveller",traveller);
        return "traveller-edit";
    }

    /**
     * @author: jbz
     * @description: 修改旅客信息
     * @date: 2023/1/7 11:08
     * @param: traveller
     * @return: java.lang.String
     */
    @RequestMapping("/save")
    public String updateTraveller(Traveller traveller) {
        travellerService.updateTraveller(traveller);
        return "redirect:queryAllTraveller";
    }

    /**
     * @author: jbz
     * @description: 删除旅客（外键约束）
     * @date: 2023/1/9 10:43
     * @param: id
     * @return: java.lang.String
    */
    @RequestMapping("/delTravellerById")
    public String deleteTravellerById(int id) {
        travellerService.deleteTraveler(id);
        return "redirect:queryAllTraveller";
    }
    /**
     * @author: jbz
     * @description: 批量删除（外键约束）
     * @date: 2023/1/9 10:44
     * @param: ids
     * @return: java.lang.String
    */
    @RequestMapping("/batchDeleteTravellerByIds")
    public String batchDeleteTravellerById(int[] ids) {
        travellerService.batchDeleteTraveler(ids);
        return "redirect:queryAllTraveller";
    }



}
