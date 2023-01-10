package com.jbz.domain;


import java.io.Serializable;
import java.util.List;

/**
 * @author: jbz
 * @date: 2022/12/24
 * @description: 用户实体类
 * @version: 1.0
 */
public class User implements Serializable {
    //用户id
    private Integer id;
    //用户邮箱
    private String email;
    //用户名
    private String username;
    //密码
    private String password;
    //手机号
    private String phoneNum;
    //用户状态 0未开启 1开启
    private Integer status;
    //具有角色
    private List<Role> roles;
    //具有角色名称
    private String roleNames;
    //头像
    private String img;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", status=" + status +
                ", roles=" + roles +
                ", roleNames='" + roleNames + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
