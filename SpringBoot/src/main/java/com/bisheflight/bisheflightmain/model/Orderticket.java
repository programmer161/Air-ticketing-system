package com.bisheflight.bisheflightmain.model;

/*
* 订单
* 2019/3/16 19：11
* */

import java.util.Date;

public class Orderticket {

    @Override
    public String toString() {
        return "Orderticket{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", startCity='" + startCity + '\'' +
                ", endCity='" + endCity + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", startTime=" + startTime +
                ", person='" + person + '\'' +
                ", phone='" + phone + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", idcard='" + idcard + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", flightClass='" + flightClass + '\'' +
                ", flightNo='" + flightNo + '\'' +
                '}';
    }

    private Integer id;
    private String orderNo;//订单号
    private String startCity;
    private String endCity;
    private Date arrivalTime;
    private Date startTime;
    private String person;//联系人
    private String phone;//电话
    private String orderStatus;//预订状态
    private String idcard;
    private Date createTime;
    private float price;
    private String flightClass;
    private String flightNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getidcard() {
        return idcard;
    }

    public void setidcard(String idcard) {
        this.idcard = idcard;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }
}
