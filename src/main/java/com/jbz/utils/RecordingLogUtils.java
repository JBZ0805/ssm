package com.jbz.utils;

import com.jbz.domain.Syslog;
import com.jbz.service.ISyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author: jbz
 * @date: 2023/1/9
 * @description: SysLog赋值工具类
 * @version: 1.0
 */
@Component
public class RecordingLogUtils {
    //依赖注入
    @Autowired
    private Syslog syslog;
    @Autowired
    private ISyslogService syslogService;

    /**
     * @author: jbz
     * @description: 给日志进行赋值并插入到数据库中
     * @date: 2023/1/9 18:36
     * @param: user
     * @param: status
     * @param: url
     * @param: executionTime
     * @param: methodTime
     * @return: void
    */
    public void insertSysLog(String username, String status,String url,int executionTime,String methodTime) {
        try {
            syslog.setVisitTime(new Date());
            syslog.setUsername(username);
            syslog.setIp(InetAddress.getLocalHost().getHostAddress());
            syslog.setUrl(url);
            syslog.setExecutionTime(executionTime);
            syslog.setMethod(methodTime);
            syslog.setStatus(status);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }finally {
            //将数据插入到数据库中
            syslogService.insertSyslog(syslog);
        }
    }
}
