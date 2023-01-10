package com.jbz.mapper;

import com.jbz.domain.Traveller;
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
public interface TravellerMapper {
    /**
     * @author: jbz
     * @description: 查询所有的旅客
     * @date: 2023/1/7 9:33
     * @param: name
     * @return: java.util.List<com.jbz.domain.Traveller>
     */
    List<Traveller> queryAllTraveller(String name);

    /**
     * @author: jbz
     * @description: 新增旅客
     * @date: 2023/1/7 10:10
     * @param: traveller
     * @return: void
     */
    @Insert("insert into traveller values(#{id},#{name},#{sex},#{phoneNum},#{credentialsType},#{credentialsNum},#{travellerType})")
    void addTraveller(Traveller traveller);

    /**
     * @author: jbz
     * @description: 根据id查询旅客
     * @date: 2023/1/7 10:58
     * @param: id
     * @return: com.jbz.domain.Traveller
     */
    @Select("select * from traveller where id=#{id}")
    Traveller queryTravellerById(int id);

    /**
     * @author: jbz
     * @description: 修改旅客信息
     * @date: 2023/1/7 10:59
     * @param: traveller
     * @return: void
     */
    @Update("update traveller set name=#{name},sex=#{sex},phoneNum=#{phoneNum},credentialsType=#{credentialsType},credentialsNum=#{credentialsNum},travellerType=#{travellerType} where id=#{id}")
    void updateTraveller(Traveller traveller);

    /**
     * @author: jbz
     * @description: 删除旅客信息
     * @date: 2023/1/7 11:02
     * @param: id
     * @return: void
     */
    @Delete("delete from traveller where id=#{id}")
    void deleteTraveller(int id);

    /**
     * @author: jbz
     * @description: 批量删除
     * @date: 2023/1/9 10:40
     * @param: ids
     * @return: void
    */
    void batchDeleteTraveller(int[] ids);


}
