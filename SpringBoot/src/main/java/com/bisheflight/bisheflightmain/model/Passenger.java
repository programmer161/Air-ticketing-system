package com.bisheflight.bisheflightmain.model;

/*
* 乘客
* 2019/3/16 19:20
* */
public class Passenger {
    private Integer id;
    private String passengerName;
    private String passengerCard;//身份证号
    private String mobilePhone;
    private Integer customerId;//客户编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerCard() {
        return passengerCard;
    }

    public void setPassengerCard(String passengerCard) {
        this.passengerCard = passengerCard;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", passengerName='" + passengerName + '\'' +
                ", passengerCard='" + passengerCard + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
