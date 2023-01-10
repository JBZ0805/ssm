package com.jbz.aop;

import com.jbz.constant.MessageConstant;
import com.jbz.domain.User;
import com.jbz.utils.RecordingLogUtils;
import com.jbz.utils.SetDataUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author: jbz
 * @date: 2023/1/7
 * @description: 记录日志的切面类(对用户的请求进行日志监控与记录)
 * @version: 1.0
 */
@Component
@Aspect
public class LogAspect {
    //依赖注入
    @Autowired
    private RecordingLogUtils recordingLogUtils;
    @Autowired
    private SetDataUtils setDataUtils;

    //定义方法执行开始时间
    private long startTime;
    //定义请求路径url
    private StringBuilder url;
    //获取请求方法名
    private String methodStr;
    //定义ServletRequestAttributes对象
    private static ServletRequestAttributes requestAttributes;


    //通用切入点表达式
    @Pointcut("execution (* com.jbz.controller.*.*(..))")
    private void pt1() {

    }

    //环绕通知
    @Around("pt1()")
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) {
        requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        //调用初始化方法
        init(proceedingJoinPoint);
        //设置返回值
        Object obj = null;
        //获取方法执行所需的参数
        Object[] objs = proceedingJoinPoint.getArgs();
        //获取当前用户的username
        String userName = getUserName(objs[0].toString());
        try {
            //执行切入点的方法
            obj = proceedingJoinPoint.proceed(objs);
        } catch (Throwable e) {
            setDataUtils.setExceptionCount(requestAttributes.getRequest().getSession());
            recordingLogUtils.insertSysLog(userName, MessageConstant.EXECUTE_METHOD_EXCEPTION, url.toString(), 0, methodStr);
            e.printStackTrace();
        } finally {
            //定义方法执行结束时间
            long endTime = System.currentTimeMillis();
            recordingLogUtils.insertSysLog(userName, MessageConstant.EXECUTE_METHOD_SUCCESS, url.toString(), (int) (endTime - startTime), methodStr);
        }
        return obj;
    }

    /**
     * @author: jbz
     * @description: 获得当前用户名
     * @date: 2023/1/7 19:00
     * @param: username
     * @return: String
     */
    public String getUserName(String username) {
        //获取Session对象
        HttpSession session = requestAttributes.getRequest().getSession();
        //获取当前用户
        User user = (User) session.getAttribute("user");
        //判断当前用户是否为null，为null说明未登录
        if (user == null) {
            //在未登录情况下，用户进行操作会调用拦截器进行登录，此时将参数username返回
            return username;
        } else {
            //不为null,说明当前用户处于登录状态，就将用户的username返回
            return user.getUsername();
        }
    }

    /**
     * @author: jbz
     * @description: 初始化参数
     * @date: 2023/1/7 19:39
     * @param: proceedingJoinPoint
     * @return: void
     */
    public void init(ProceedingJoinPoint proceedingJoinPoint) {
        //获取HttpSession对象
        HttpSession session = requestAttributes.getRequest().getSession();
        setDataUtils.setVisitCount(session);
        //给方法开始时间进行赋值
        startTime = System.currentTimeMillis();
        url = new StringBuilder();
        //获取执行方法的类
        Object target = proceedingJoinPoint.getTarget();
        RequestMapping[] classRequest = target.getClass().getAnnotationsByType(RequestMapping.class);
        //获取请求方法的一级路径
        url.append(classRequest[0].value()[0]);
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //获取请求方法
        Method method = signature.getMethod();
        //获取请求方法名
        methodStr = "[类名]" + target.getClass().getName() + "[方法名]" + method.getName();
        //获取请求方法的二级路径
        RequestMapping[] methodRequest = method.getAnnotationsByType(RequestMapping.class);
        url.append(methodRequest[0].value()[0]);
        if(url.toString().equals("orders/add")){
            setDataUtils.setOrderCount(session);
        }
    }


}
