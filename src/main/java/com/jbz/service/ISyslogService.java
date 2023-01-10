package com.jbz.service;

import com.github.pagehelper.PageInfo;
import com.jbz.domain.Syslog;

/**
 * @author: jbz
 * @date: 2022/12/22
 * @description:
 * @version: 1.0
 */
public interface ISyslogService {

    /**
     * @author: jbz
     * @description: 查询所有的日志
     * @date: 2023/1/5 8:37
     * @param: pageNum
     * @param: pageSize
     * @param: username
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Syslog>
    */
    PageInfo<Syslog> queryAllSyslog(int pageNum, int pageSize, String username);

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
     * @date: 2023/1/6 12:33
     * @param: ids
     * @return: void
    */
    void batchDeleteSyslog(int[] ids);

    /**
     * @author: jbz
     * @description: 新增日志
     * @date: 2023/1/7 16:17
     * @param: syslog
     * @return: void
    */
    void insertSyslog(Syslog syslog);

}
