package com.jbz.controller;

import com.jbz.domain.User;
import com.jbz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;


/**
 * @author: jbz
 * @date: 2022/12/24
 * @description: 个人接口
 * 将个人接口与用户接口分离，便于权限的控制
 * @version: 1.0
 */
@Controller
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    private IUserService userService;

    /**
     * @author: jbz
     * @description: 个人登录
     * @date: 2022/12/24 21:37
     * @param: username
     * @param: password
     * @return: java.lang.String
     */
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        //调用service的login方法
        User user = userService.login(username, password);
        if (user != null) {
            //登陆成功 将user存在session中
            session.setAttribute("user", user);
            //重定向至index
            return "redirect:/pages/index.jsp";
        }
        return "redirect:/pages/login-fail.jsp";
    }
    /**
     * @author: jbz
     * @description: 查询个人信息
     * @date: 2023/1/6 8:16
     * @param: id
     * @param: model
     * @return: java.lang.String
     */
    @RequestMapping("/queryPersonalUserById")
    public String queryPersonalUserById(int id, Model model) {
        //调用Service中查询个人用户的方法
        User user = userService.queryPersonalUserById(id);
        //设置数据 保存容器中
        model.addAttribute("user",user);
        return "personal-edit";
    }

    /**
     * @author: jbz
     * @description: 编辑个人信息
     * @date: 2023/1/6 9:11
     * @param: user
     * @return: java.lang.String
     */
    @RequestMapping("/save")
    public String updateUser(User newUser,HttpSession session) {
        //从session中获取原个人信息
        User oldUser = (User) session.getAttribute("user");
        userService.updatePersonalUser(newUser);
        //判断密码有没有被修改
        if(!oldUser.getPassword().equals(newUser.getPassword())){
            //说明密码被修改 当前用户注销
            session.invalidate();
            return "session-overdue";
        }
        newUser.setImg(oldUser.getImg());
        session.setAttribute("user",newUser);
        return "index";
    }
    /**
     * @author: jbz
     * @description: 个人注销
     * @date: 2023/1/6 18:14
     * @param: session
     * @return: java.lang.String
     */
    @RequestMapping("/exit")
    public String exitUser(HttpSession session) {
        session.invalidate();
        return "index";
    }

    /**
     * @author: jbz
     * @description: 上传头像
     * @date: 2023/1/6 20:24
     * @param: uploadImg
     * @return: java.lang.String
     */
    @RequestMapping("/uploadImg")
    public String uploadImg(MultipartFile uploadImg, HttpSession session) {
        // 获取文件名称
        String uploadFileName = uploadImg.getOriginalFilename();
        try {
            //保存上传的头像
            uploadImg.transferTo(new File("D:\\workspace\\ssm\\src\\main\\webapp\\img\\" + uploadFileName));
            User user = (User) session.getAttribute("user");
            //修改当前用户的头像
            user.setImg(uploadFileName);
            //调用userService将文件名存入数据库
            userService.updateUserImg(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
}
