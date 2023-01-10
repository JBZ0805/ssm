package com.jbz.mapper;

import com.jbz.domain.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
@Repository
public interface MemberMapper {
    /**
     * @author: jbz
     * @description: 查询所有的成员
     * @date: 2023/1/8 14:47
     * @param: name
     * @return: java.util.List<com.jbz.domain.Member>
     */
    List<Member> queryAllMember(String name);

    /**
     * @author: jbz
     * @description: 新增成员
     * @date: 2023/1/8 15:02
     * @param: member
     * @return: void
     */
    @Insert("insert into member values (#{id},#{name},#{nickName},#{phoneNum},#{email})")
    void insertMember(Member member);

    /**
     * @author: jbz
     * @description: 根据id查询成员
     * @date: 2023/1/8 15:12
     * @param: id
     * @return: com.jbz.domain.Member
     */
    @Select("select * from member where id=#{id}")
    Member queryMemberById(int id);

    /**
     * @author: jbz
     * @description: 更新成员
     * @date: 2023/1/8 15:12
     * @param: member
     * @return: void
     */
    @Update("update member set name=#{name},nickName=#{nickName},phoneNum=#{phoneNum},email=#{email} where id=#{id}")
    void updateMember(Member member);

    /**
     * @author: jbz
     * @description: 根据id删除成员
     * @date: 2023/1/9 10:12
     * @param: id
     * @return: void
    */
    @Delete("delete from member where id=#{id}")
    void deleteMemberById(int id);

    /**
     * @author: jbz
     * @description: 批量删除成员
     * @date: 2023/1/9 10:14
     * @param: ids
     * @return: void
    */
    void batchDeleteMemberByIds(int[] ids);


}
