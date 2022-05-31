package com.sx.pojo.Vo;


import com.sx.pojo.Order;

public class PhoneOrderVo {
    private String phone;
    private Order order;

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "PhoneOrderVo{" +
                "phone='" + phone + '\'' +
                ", order=" + order +
                '}';
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
