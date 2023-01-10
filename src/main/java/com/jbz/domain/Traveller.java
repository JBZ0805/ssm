package com.jbz.domain;

import java.io.Serializable;

/**
 * @author: jbz
 * @date: 2023/1/6
 * @description: 旅客表JavaBean
 * @version: 1.0
 */
public class Traveller implements Serializable {
    //id
    private Integer id;
    //姓名
    private String name;
    //性别
    private String sex;
    //手机号
    private String phoneNum;
    //证件类型 0身份证 1护照 2军官证
    private Integer credentialsType;
    //证件号码
    private String credentialsNum;
    //旅客类型(人群) 0 成人 1 儿童
    private Integer travellerType;

    public Traveller() {
    }

    public Traveller(Integer id, String name, String sex, String phoneNum, Integer credentialsType, String credentialsNum, Integer travellerType) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.credentialsType = credentialsType;
        this.credentialsNum = credentialsNum;
        this.travellerType = travellerType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", credentialsType=" + credentialsType +
                ", credentialsNum='" + credentialsNum + '\'' +
                ", travellerType=" + travellerType +
                '}';
    }
}
