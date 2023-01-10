package com.jbz.interceptor;

import com.jbz.constant.MessageConstant;
import com.jbz.domain.User;
import com.jbz.utils.PermissionHandleUtils;
import com.jbz.utils.RecordingLogUtils;
import com.jbz.utils.SetDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: jbz
 * @date: 2023/1/9
 * @description: 用户权限拦截器(对用户的请求进行权限的监控与拦截)
 * @version: 1.0
 */
public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    private PermissionHandleUtils permissionHandle;
    @Autowired
    private RecordingLogUtils recordingLog;
    @Autowired
    private SetDataUtils setDataUtil;
    //在目标方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录
        HttpSession session = request.getSession();
        //从session中获取用户
        User user = (User) session.getAttribute("user");
        //如果用户为null或者用户名为空
        if (user == null || "".equals(user.getUsername())) {
            //还停留在登录页
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
            return false;
        } else {
            Boolean flag = permissionHandle.judgePermissions(request, user);
            if(flag){
                //放行
                return true;
            }else {
                setDataUtil.setPermissionCount(request.getSession());
                //添加日志
                recordingLog.insertSysLog(user.getUsername(), MessageConstant.EXECUTE_METHOD_FAIL,request.getRequestURI(),0,"方法已拦截");
                //跳转至错误页面
                response.sendRedirect(request.getContextPath() + "/pages/403.jsp");
                return false;
            }
        }
    }
}
