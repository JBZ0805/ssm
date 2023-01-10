package com.jbz.mapper;

import com.jbz.domain.Syslog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
@Repository
public interface SyslogMapper {
    /**
     * @author: jbz
     * @description: 查询所有的日志
     * @date: 2023/1/5 8:54
     * @param: username
     * @return: java.util.List<com.jbz.domain.Syslog>
     */
    List<Syslog> queryAllSyslog(String username);

    /**
     * @author: jbz
     * @description: 删除日志
     * @date: 2023/1/6 10:57
     * @param: id
     * @return: void
     */
    void deleteSyslogById(int id);

    /**
     * @author: jbz
     * @description: 批量删除日志
     * @date: 2023/1/6 12:34
     * @param: ids
     * @return: void
     */
    void batchDeleteSyslog(int[] ids);

    /**
     * @author: jbz
     * @description: 新增日志
     * @date: 2023/1/7 16:18
     * @param: syslog
     * @return: void
     */
    @Insert("insert into syslog values (#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method},#{status})")
    void insertSyslog(Syslog syslog);

}
