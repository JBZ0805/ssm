package com.jbz.mapper;

import com.jbz.domain.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
public interface RoleMapper {

    /**
     * @author: jbz
     * @description: 查询所有角色
     * @date: 2022/12/24 17:14
     * @param: roleDesc
     * @return: java.util.List<com.jbz.domain.Role>
    */
    List<Role> queryAllRole(String roleDesc);
    /**
     * @author: jbz
     * @description: 添加角色
     * @date: 2022/12/24 17:55
     * @param: role
     * @return: void
    */
    void addRole(Role role);

    /**
     * @author: jbz
     * @description: 根据id查询role
     * @date: 2022/12/24 18:14
     * @param: id
     * @return: com.jbz.domain.Role
    */
    Role queryRoleById(Integer id);

    /**
     * @author: jbz
     * @description: 根据id修改role
     * @date: 2022/12/24 16:15
     * @param: role
     * @return: void
    */
    @Update("update role set roleName=#{roleName},roleDesc=#{roleDesc} where id=#{id}")
    void updateRoleById(Role role);
    /**
     * @author: jbz
     * @description: 根据id删除Role
     * @date: 2022/12/24 16:17
     * @param: id
     * @return: void
    */
    @Delete("delete from role where id=#{id}")
    void deleteRoleById(Integer id);

    /**
     * @author: jbz
     * @description: 批量删除role
     * @date: 2022/12/24 16:37
     * @param: ids
     * @return: void
    */
    void batchDeleteRoleByIds(int[] ids);
}
