package com.jbz.mapper;

import com.jbz.domain.Permission;
import com.jbz.domain.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author: jbz
 * @date: 2022/12/24
 * @description:
 * @version: 1.0
 */
@Repository
public interface UserMapper {

    /**
     * @author: jbz
     * @description: 条件查询
     * @date: 2023/1/5 18:16
     * @param: username
     * @return: List
    */
    List<User> queryAllUser(String username);

    /**
     * @author: jbz
     * @description: 根据username查询用户user
     * @date: 2022/12/24 21:54
     * @param: username
     * @return: com.jbz.domain.User
    */
    @Select("select * from user where username=#{username}")
    User queryUserByUsername(String username);

    /**
     * @author: jbz
     * @description: 新增一个用户
     * @date: 2023/1/5 21:24
     * @param: user
     * @return: void
    */
    Integer insertUser(User user);

    /**
     * @author: jbz
     * @description: 根据id查询用户
     * @date: 2023/1/6 8:18
     * @param: id
     * @return: com.jbz.domain.User
    */
    User queryUserById(int id);

    /**
     * @author: jbz
     * @description: 更新用户
     * @date: 2023/1/6 9:18
     * @param: user
     * @return: void
    */
    void updateUser(User user);

    /**
     * @author: jbz
     * @description: 删除用户
     * @date: 2023/1/6 10:03
     * @param: id
     * @return: void
    */
    void deleteUserById(int id);

    /**
     * @author: jbz
     * @description: 批量删除用户
     * @date: 2023/1/6 10:41
     * @param: ids
     * @return: void
    */
    void batchDeleteUser(int[] ids);

    /**
     * @author: jbz
     * @description: 更新个人头像
     * @date: 2023/1/6 18:43
     * @param: user
     * @return: void
     */
    @Update("update user set img=#{img} where id=#{id}")
    void updateUserImg(User user);

    /**
     * @author: jbz
     * @description: 查询个人信息
     * @date: 2023/1/6 19:28
     * @param: id
     * @return: com.jbz.domain.User
     */
    @Select("select * from user where id=#{id}")
    User queryPersonalUserById(int id);

}
