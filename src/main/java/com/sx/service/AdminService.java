package com.sx.service;

import com.sx.pojo.CarInfo;
import com.sx.pojo.History;
import com.sx.pojo.User;
import com.sx.pojo.Vo.PhoneOrderVo;

import java.util.List;


public interface AdminService {
    List<User> getAllUser();
    int deleteUser(String uid);
    int deleteOrder(String orderid);
    int deleteHistory(String historyid);
    List<PhoneOrderVo> getUnfinishedOrder();
    List<History> getHistoryOrder();
    List<PhoneOrderVo> getUncheckedOrder();
    List<CarInfo> getUncheckedCarInfo();
    List<CarInfo> getSalableCarInfo();
    List<CarInfo> getBookedCarInfo();
    List<CarInfo> getSoldCarInfo();
    List<CarInfo> getAllCarInfo();
}
