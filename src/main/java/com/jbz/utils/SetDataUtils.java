package com.jbz.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;


/**
 * @author: jbz
 * @date: 2023/1/9
 * @description:
 * @version: 1.0
 */
@Component
public class SetDataUtils {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @author: jbz
     * @description: 设置访问量
     * @date: 2023/1/10 8:45
     * @param: session
     * @return: void
    */
    public void setVisitCount(HttpSession session){
        Long visitNum = redisTemplate.boundValueOps("visitNum").increment(1);
        session.setAttribute("visitNum",visitNum);
    }

    /**
     * @author: jbz
     * @description: 设置异常量
     * @date: 2023/1/10 11:46
     * @param: session
     * @return: void
    */
    public void setExceptionCount(HttpSession session) {
        Long exceptionNum = redisTemplate.boundValueOps("exceptionNum").increment(1);
        session.setAttribute("exceptionNum",exceptionNum);
    }
    /**
     * @author: jbz
     * @description: 设置新增订单
     * @date: 2023/1/10 11:46
     * @param: session
     * @return: void
     */
    public void setOrderCount(HttpSession session) {
        Long orderNum = redisTemplate.boundValueOps("orderNum").increment(1);
        session.setAttribute("orderNum",orderNum);
    }
    /**
     * @author: jbz
     * @description: 设置拦截权限总数
     * @date: 2023/1/10 11:46
     * @param: session
     * @return: void
     */
    public void setPermissionCount(HttpSession session) {
        Long permissionNum = redisTemplate.boundValueOps("permissionNum").increment(1);
        session.setAttribute("permissionNum",permissionNum);
    }



}
