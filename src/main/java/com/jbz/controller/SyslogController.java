package com.jbz.controller;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Syslog;
import com.jbz.service.ISyslogService;
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
@RequestMapping("/sysLog")
public class SyslogController {
    //依赖注入service接口
    @Autowired
    private ISyslogService syslogService;


   /**
    * @author: jbz
    * @description: 分页查询+条件查询
    * @date: 2023/1/5 8:40
    * @param: pageNum
    * @param: pageSize
    * @param: username
    * @param: model
    * @return: java.lang.String
   */
    @RequestMapping("/findAll")
    public String querySyslog(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "6") int pageSize,
                                   @RequestParam(value = "username", required = false) String username, Model model) {
        //调用service的查询日志的方法
        PageInfo<Syslog> pageInfo = syslogService.queryAllSyslog(pageNum, pageSize, username);
        //设置数据 保存容器中
        model.addAttribute("pageInfo", pageInfo);
        //返回给视图
        return "syslog-list";
    }

    /**
     * @author: jbz
     * @description: 删除一条日志
     * @date: 2023/1/6 10:59
     * @param: id
     * @return: java.lang.String
    */
    @RequestMapping("/delSyslogById")
    public String deleteSyslogById(int id) {
        syslogService.deleteSyslogById(id);
        return "redirect:findAll";
    }

    /**
     * @author: jbz
     * @description: 批量删除日志
     * @date: 2023/1/6 12:32
     * @param: ids
     * @return: java.lang.String
    */
    @RequestMapping("/batchDeleteSyslog")
    public String batchDeleteSyslog(int[] ids) {
        syslogService.batchDeleteSyslog(ids);
        return "redirect:findAll";
    }


}
