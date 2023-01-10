package com.jbz.controller;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Member;
import com.jbz.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: jbz
 * @date: 2023/1/7
 * @description:
 * @version: 1.0
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private IMemberService memberService;

    /**
     * @author: jbz
     * @description: 分页查询
     * @date: 2023/1/8 14:53
     * @param: pageNum
     * @param: pageSize
     * @param: name
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryAllMember")
    public String queryAllMember(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "6") int pageSize,
                              @RequestParam(value = "name", required = false) String name, Model model) {
        //调用service的查询日志的方法
        PageInfo<Member> pageInfo = memberService.queryAllMember(pageNum, pageSize, name);
        //设置数据 保存容器中
        model.addAttribute("pageInfo", pageInfo);
        //返回给视图
        return "member-list";
    }

    /**
     * @author: jbz
     * @description: 添加成员
     * @date: 2023/1/8 15:09
     * @param: member
     * @return: java.lang.String
    */
    @RequestMapping("/add")
    public String addMember(Member member) {
        memberService.insertMember(member);
        return "redirect:queryAllMember";
    }

    /**
     * @author: jbz
     * @description: 根据id查询成员
     * @date: 2023/1/8 15:11
     * @param: id
     * @param: model
     * @return: java.lang.String
    */
    @RequestMapping("/queryMemberById")
    public String queryMemberById(int id, Model model) {
        Member member = memberService.queryMemberById(id);
        model.addAttribute("member", member);
        return "member-edit";
    }

    /**
     * @author: jbz
     * @description: 修改成员信息
     * @date: 2023/1/8 15:16
     * @param: member
     * @return: java.lang.String
    */
    @RequestMapping("/save")
    public String updateMember(Member member) {
        memberService.updateMember(member);
        return "redirect:queryAllMember";
    }


    /**
     * @author: jbz
     * @description: 删除成员（外键约束）
     * @date: 2023/1/9 10:22
     * @param: id
     * @return: java.lang.String
    */
    @RequestMapping("/delMemberById")
    public String deleteMemberById(int id) {
        memberService.deleteMemberById(id);
        return "redirect:queryAllMember";
    }
    /**
     * @author: jbz
     * @description: 批量删除成员（外键约束）
     * @date: 2023/1/9 10:22
     * @param: id
     * @return: java.lang.String
     */
    @RequestMapping("/batchDeleteMemberByIds")
    public String batchDeleteMemberByIds(int[] ids) {
        memberService.batchDeleteMemberByIds(ids);
        return "redirect:queryAllMember";
    }


}
