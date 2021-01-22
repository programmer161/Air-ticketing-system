package com.bisheflight.bisheflightmain.model;

import java.util.Date;

/*
* 飞机
* 2019/3/16 19:25
* */

public class Plane {
    private Integer id;
    private String planeVersion;//飞机型号
    private String planeType;//飞机类型
    private Integer planeAge;
    private Integer businessClassAmount;//商务舱数量
    private Integer firstClassAmount;//头等舱数量
    private Integer economyClassAmount;//经济舱数量
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaneVersion() {
        return planeVersion;
    }

    public void setPlaneVersion(String planeVersion) {
        this.planeVersion = planeVersion;
    }

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    public Integer getPlaneAge() {
        return planeAge;
    }

    public void setPlaneAge(Integer planeAge) {
        this.planeAge = planeAge;
    }

    public Integer getBusinessClassMount() {
        return businessClassAmount;
    }

    public void setBusinessClassMount(Integer businessClassMount) {
        this.businessClassAmount = businessClassMount;
    }

    public Integer getFirstClassMount() {
        return firstClassAmount;
    }

    public void setFirstClassMount(Integer firstClassMount) {
        this.firstClassAmount = firstClassMount;
    }

    public Integer getEconomyClassMount() {
        return economyClassAmount;
    }

    public void setEconomyClassMount(Integer economyClassMount) {
        this.economyClassAmount = economyClassMount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", planeVersion='" + planeVersion + '\'' +
                ", planeType='" + planeType + '\'' +
                ", planeAge=" + planeAge +
                ", businessClassMount=" + businessClassAmount +
                ", firstClassMount=" + firstClassAmount +
                ", economyClassMount=" + economyClassAmount +
                ", createTime=" + createTime +
                '}';
    }
}
