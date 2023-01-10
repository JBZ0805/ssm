package com.jbz.service;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Member;


/**
 * @author: jbz
 * @date: 2023/1/8
 * @description:
 * @version: 1.0
 */
public interface IMemberService {

    /**
     * @author: jbz
     * @description: 分页查询+条件查询
     * @date: 2023/1/8 14:45
     * @param: pageNum
     * @param: pageSize
     * @param: name
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Member>
    */
    PageInfo<Member> queryAllMember(int pageNum, int pageSize, String name);

    /**
     * @author: jbz
     * @description: 新增成员
     * @date: 2023/1/8 15:00
     * @param: member
     * @return: void
    */
    void insertMember(Member member);

    /**
     * @author: jbz
     * @description: 根据id查询成员
     * @date: 2023/1/8 15:12
     * @param: id
     * @return: com.jbz.domain.Member
    */
    Member queryMemberById(int id);

    /**
     * @author: jbz
     * @description: 更新成员
     * @date: 2023/1/8 15:12
     * @param: member
     * @return: void
    */
    void updateMember(Member member);

    /**
     * @author: jbz
     * @description: 删除成员（也要删除对应的订单与订单中间表）
     * @date: 2023/1/9 10:16
     * @param: id
     * @return: void
    */
    void deleteMemberById(int id);

    /**
     * @author: jbz
     * @description: 批量删除成员（也要删除对应的订单与订单中间表）
     * @date: 2023/1/9 10:17
     * @param: ids
     * @return: void
    */
    void batchDeleteMemberByIds(int[] ids);


}
