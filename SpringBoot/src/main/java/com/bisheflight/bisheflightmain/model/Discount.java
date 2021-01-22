package com.bisheflight.bisheflightmain.model;

import java.util.Date;

/*
* 折扣
* 2019/3/16 18:45
* */
public class Discount {
    private Integer id;
    private String discountType;//折扣类型
    private Float discountRate;//折扣率
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscounttype() {
        return discountType;
    }

    public void setDiscounttype(String discounttype) {
        this.discountType = discounttype;
    }

    public Float getDiscountrate() {
        return discountRate;
    }

    public void setDiscountrate(Float discountrate) {
        this.discountRate = discountrate;
    }

    public Date getCreatetime() {
        return createTime;
    }

    public void setCreatetime(Date createtime) {
        this.createTime = createtime;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discounttype='" + discountType + '\'' +
                ", discountrate=" + discountRate +
                ", createtime=" + createTime +
                '}';
    }
}
