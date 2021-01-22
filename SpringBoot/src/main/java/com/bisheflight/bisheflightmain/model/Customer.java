package com.bisheflight.bisheflightmain.model;

import java.util.Date;

/*
* 客户
* 2019/3/16 18：20
* */
public class Customer {
    private Integer id;
    private String email;
    private String mobilePhone;
    private String nickName;//昵称
    private String realName;//姓名
    private String password;
    private String birthday;
    private String sex;
    private Date createTime;

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

    public String getMobilephone() {
        return mobilePhone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilePhone = mobilephone;
    }

    public String getNickname() {
        return nickName;
    }

    public void setNickname(String nickname) {
        this.nickName = nickname;
    }

    public String getRealname() {
        return realName;
    }

    public void setRealname(String realname) {
        this.realName = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getCreatetime() {
        return createTime;
    }

    public void setCreatetime(Date createtime) {
        this.createTime = createtime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", mobilephone='" + mobilePhone + '\'' +
                ", nickname='" + nickName + '\'' +
                ", realname='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", createtime=" + createTime +
                '}';
    }
}
