package com.jbz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbz.domain.Member;
import com.jbz.mapper.MemberMapper;
import com.jbz.mapper.OrdersMapper;
import com.jbz.service.IMemberService;
import com.jbz.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jbz
 * @date: 2023/1/8
 * @description:
 * @version: 1.0
 */
@Service
public class MemberServiceImpl implements IMemberService {

    //依赖注入
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private IOrdersService ordersService;

    /**
     * @author: jbz
     * @description: 分页查询
     * @date: 2023/1/8 14:46
     * @param: pageNum
     * @param: pageSize
     * @param: name
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Member>
    */
    @Override
    public PageInfo<Member> queryAllMember(int pageNum, int pageSize, String name) {
        //用mybatis提供的分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Member> memberList = memberMapper.queryAllMember(name);
        return new PageInfo<>(memberList,pageSize);
    }

    /**
     * @author: jbz
     * @description: 新增成员
     * @date: 2023/1/8 15:01
     * @param: member
     * @return: void
    */
    @Override
    public void insertMember(Member member) {
        memberMapper.insertMember(member);
    }
    /**
     * @author: jbz
     * @description: 根据id查询成员
     * @date: 2023/1/8 15:12
     * @param: id
     * @return: com.jbz.domain.Member
    */
    @Override
    public Member queryMemberById(int id) {
        return memberMapper.queryMemberById(id);
    }

    /**
     * @author: jbz
     * @description: 更新成员信息
     * @date: 2023/1/8 15:13
     * @param: member
     * @return: void
    */
    @Override
    public void updateMember(Member member) {
        memberMapper.updateMember(member);
    }

    /**
     * @author: jbz
     * @description: 删除成员（也要删除对应的订单与订单中间表）
     * @date: 2023/1/9 10:16
     * @param: id
     * @return: void
     */
    @Override
    public void deleteMemberById(int id) {
        //先根据id查询对应的订单
        int[] orders = ordersMapper.queryOrdersByMemberId(id);
        //删除订单与订单游客中间表对应的记录
        ordersService.batchDeleteOrders(orders);
        //最后删除成员
        memberMapper.deleteMemberById(id);
    }
    /**
     * @author: jbz
     * @description: 批量删除成员（也要删除对应的订单与订单中间表）
     * @date: 2023/1/9 10:17
     * @param: ids
     * @return: void
     */
    @Override
    public void batchDeleteMemberByIds(int[] ids) {
        //先根据id查询对应的订单
        int[] orders = ordersMapper.queryOrdersByMemberIds(ids);
        //删除订单与订单游客中间表对应的记录
        ordersService.batchDeleteOrders(orders);
        //最后删除成员
        memberMapper.batchDeleteMemberByIds(ids);

    }
}
