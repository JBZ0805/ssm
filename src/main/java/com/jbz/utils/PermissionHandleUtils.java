package com.jbz.utils;

import com.jbz.domain.User;
import com.jbz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jbz
 * @date: 2023/1/9
 * @description:
 * @version: 1.0
 */
@Component
public class PermissionHandleUtils {
    //依赖注入
    @Autowired
    private IUserService userService;

    public Boolean judgePermissions(HttpServletRequest request,User user) {
        //获取用户的具有权限请求路径
        String[] permissionUrl = userService.queryUserPermissionsById(user.getId());
        //获得当前请求路径
        String requestURL = request.getRequestURI();
        //进行判断
        if (permissionUrl != null && permissionUrl.length != 0) {
            List<String> list = Arrays.asList(permissionUrl);
            if (list.contains("/*")) {
                return true;
            } else if (list.contains(requestURL)) {
                return true;
            } else if (requestURL.equals("/favicon.ico")) {
                return true;
            } else return list.contains("/personal/*") && requestURL.contains("/personal/");
        } else {
            return false;
        }
    }
}
