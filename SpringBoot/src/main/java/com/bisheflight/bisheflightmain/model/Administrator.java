package com.bisheflight.bisheflightmain.model;

import java.util.Date;

/**
 * 管理员
 * 2019/3/16 18:00
 */
public class Administrator {
    private Integer id;
    private String username;
    private String password;
    private Date lastLoginTime;//最后登录时间
    private Date createTime;//创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getLastlogintime() {
        return lastLoginTime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastLoginTime = lastlogintime;
    }

    public Date getCreattime() {
        return createTime;
    }

    public void setCreattime(Date creattime) {
        this.createTime = creattime;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", lastlogintime=" + lastLoginTime +
                ", creattime=" + createTime +
                '}';
    }
}
