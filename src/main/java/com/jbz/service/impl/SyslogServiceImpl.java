package com.jbz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jbz.domain.Syslog;
import com.jbz.mapper.SyslogMapper;
import com.jbz.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: jbz
 * @date: 2023/1/5
 * @description:
 * @version: 1.0
 */
@Service
public class SyslogServiceImpl implements ISyslogService {

    //依赖注入
    @Autowired
    private SyslogMapper syslogMapper;

    /**
     * @author: jbz
     * @description: 分页条件查询
     * @date: 2023/1/5 8:59
     * @param: pageNum
     * @param: pageSize
     * @param: username
     * @return: com.github.pagehelper.PageInfo<com.jbz.domain.Syslog>
    */
    @Override
    public PageInfo<Syslog> queryAllSyslog(int pageNum, int pageSize, String username) {
        //用mybatis提供的分页插件
        PageHelper.startPage(pageNum, pageSize);
        List<Syslog> syslogList = syslogMapper.queryAllSyslog(username);
        return new PageInfo<>(syslogList,pageSize);
    }

    /**
     * @author: jbz
     * @description: 删除一条日志
     * @date: 2023/1/6 10:58
     * @param: id
     * @return: void
    */
    @Override
    public void deleteSyslogById(int id) {
        syslogMapper.deleteSyslogById(id);
    }

    /**
     * @author: jbz
     * @description: 批量删除日志
     * @date: 2023/1/6 12:33
     * @param: ids
     * @return: void
    */
    @Override
    public void batchDeleteSyslog(int[] ids) {
        syslogMapper.batchDeleteSyslog(ids);
    }

    /**
     * @author: jbz
     * @description: 新增日志
     * @date: 2023/1/7 16:17
     * @param: syslog
     * @return: void
    */
    @Override
    public void insertSyslog(Syslog syslog) {
        syslogMapper.insertSyslog(syslog);
    }

}
