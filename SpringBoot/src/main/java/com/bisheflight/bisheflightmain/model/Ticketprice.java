package com.bisheflight.bisheflightmain.model;

/*
* 票价
* 2019/3/16 19:38
* */

public class Ticketprice {
    private Integer id;
    private String classType;//舱位类型
    private Integer classAmount;//舱位数量
    private Float price;
    private Integer flightId;
    private Integer discountId;
    private Float discountPrice;//优惠价
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Integer getClassMount() {
        return classAmount;
    }

    public void setClassMount(Integer classMount) {
        this.classAmount = classMount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Float getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Float discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Ticketprice{" +
                "id=" + id +
                ", classType='" + classType + '\'' +
                ", classMount=" + classAmount +
                ", price=" + price +
                ", flightId=" + flightId +
                ", discountId=" + discountId +
                ", discountPrice=" + discountPrice +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
