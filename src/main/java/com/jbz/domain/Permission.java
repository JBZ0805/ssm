package com.jbz.domain;

import java.io.Serializable;

/**
 * @author: jbz
 * @date: 2023/1/9
 * @description: 权限表JavaBean
 * @version: 1.0
 */
public class Permission implements Serializable {
    //id
    private Integer id;
    //权限名
    private String permissionName;
    //请求路径
    private String url;

    public Permission() {
    }

    public Permission(Integer id, String permissionName, String url) {
        this.id = id;
        this.permissionName = permissionName;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
