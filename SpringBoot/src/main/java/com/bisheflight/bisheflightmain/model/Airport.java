package com.bisheflight.bisheflightmain.model;

/*
* 机场
* 2019/3/16 18：05
* */
public class Airport {
    private Integer id;
    private String airportName;//机场名称
    private String airportCity;//机场所在城市
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAirportname() {
        return airportName;
    }

    public void setAirportname(String airportname) {
        this.airportName = airportname;
    }

    public String getAirportcity() {
        return airportCity;
    }

    public void setAirportcity(String airportcity) {
        this.airportCity = airportcity;
    }

    public String getCreatetime() {
        return createTime;
    }

    public void setCreatetime(String createtime) {
        this.createTime = createtime;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", airportname='" + airportName + '\'' +
                ", airportcity='" + airportCity + '\'' +
                ", createtime='" + createTime + '\'' +
                '}';
    }
}
