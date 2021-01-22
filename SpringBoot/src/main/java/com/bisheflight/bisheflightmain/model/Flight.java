package com.bisheflight.bisheflightmain.model;

import java.util.Date;

/*
* 航班信息
* 2019/3/16 18：55
* */
public class Flight {
    private Integer id;
    private String flightNo;//航班号
    private Date startTime;//出发时间
    private String startAirport;//出发机场
    private Date arrivalTime;//抵达时间
    private String endAirport;//抵达机场
    private Integer businessClassAmount;//商务舱数量
    private Integer firstClassAmount;//头等舱数量
    private String status;//状态
    private Date createTime;
    private Integer economyClassAmount;//经济舱数量
    private Date startRealTime;//实际出发时间
    private Date arrivalRealTime;//实际到达时间
    private float firstClassPrice;
    private float businessClassPrice;
    private float economyClassPrice;

    public Integer getBusinessClassAmount() {
        return businessClassAmount;
    }

    public void setBusinessClassAmount(Integer businessClassAmount) {
        this.businessClassAmount = businessClassAmount;
    }

    public Integer getFirstClassAmount() {
        return firstClassAmount;
    }

    public void setFirstClassAmount(Integer firstClassAmount) {
        this.firstClassAmount = firstClassAmount;
    }

    public Integer getEconomyClassAmount() {
        return economyClassAmount;
    }

    public void setEconomyClassAmount(Integer economyClassAmount) {
        this.economyClassAmount = economyClassAmount;
    }



    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }



    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }



    public Date getStartRealTime() {
        return startRealTime;
    }

    public void setStartRealTime(Date startRealTime) {
        this.startRealTime = startRealTime;
    }

    public Date getArrivalRealTime() {
        return arrivalRealTime;
    }

    public void setArrivalRealTime(Date arrivalRealTime) {
        this.arrivalRealTime = arrivalRealTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public float getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(float firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public float getBusinessClassPrice() {
        return businessClassPrice;
    }

    public void setBusinessClassPrice(float businessClassPrice) {
        this.businessClassPrice = businessClassPrice;
    }

    public float getEconomyClassPrice() {
        return economyClassPrice;
    }

    public void setEconomyClassPrice(float economyClassPrice) {
        this.economyClassPrice = economyClassPrice;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNo='" + flightNo + '\'' +
                ", startTime=" + startTime +
                ", startAirportId=" + startAirport +
                ", arrivalTime=" + arrivalTime +
                ", endAirportId=" + endAirport +
                ", startRealTime=" + startRealTime +
                ", arrivalRealTime=" + arrivalRealTime +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
