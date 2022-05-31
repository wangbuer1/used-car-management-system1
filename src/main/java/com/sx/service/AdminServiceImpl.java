package com.sx.service;
import com.sx.dao.*;
import com.sx.pojo.CarInfo;
import com.sx.pojo.History;
import com.sx.pojo.Order;
import com.sx.pojo.User;
import com.sx.pojo.Vo.PhoneOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public OrderMapper orderMapper;
    @Autowired
    public CarInfoMapper carInfoMapper;
    @Autowired
    public HistoryMapper historyMapper;


    @Override
    public List<User> getAllUser() { return userMapper.getAllUser(); }

    @Override
    public int deleteUser(String uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public int deleteOrder(String orderid){
        return orderMapper.deleteByPrimaryKey(orderid);
    }
    @Override
    public int deleteHistory(String historyid){
        return historyMapper.deleteByPrimaryKey(historyid);
    }
    @Override
    public List<PhoneOrderVo> getUnfinishedOrder(){
         List<Order> allOrders=orderMapper.getAllOrder();
         List<PhoneOrderVo> ordersList=new ArrayList<PhoneOrderVo>();
        for (Order order:allOrders) {
            /*if("未确认".equals(order.getOrderStatus())){
                String phone="";
                PhoneOrderVo temp = new PhoneOrderVo();
                User seller;
                seller = userMapper.selectByPrimaryKey(order.getSellerId());
                //用户数据不全 可能为空 引起空指针异常
                if(seller != null) phone = seller.getUphone();
                temp.setPhone(phone);
                temp.setOrder(order);
                ordersList.add(temp);
            }*/
            if(!"未确认".equals(order.getOrderStatus())){
                continue;
            }
            String phone="";
            PhoneOrderVo temp = new PhoneOrderVo();
            User seller;
            seller = userMapper.selectByPrimaryKey(order.getSellerId());
            //用户数据不全 可能为空 引起空指针异常
            if(seller != null) phone = seller.getUphone();
            temp.setPhone(phone);
            temp.setOrder(order);
            ordersList.add(temp);
        }
        return ordersList;
    }

    public  List<PhoneOrderVo> getUncheckedOrder(){
        List<Order> allOrders=orderMapper.getAllOrder();
        List<PhoneOrderVo> ordersList=new ArrayList<PhoneOrderVo>();
        for (Order order:allOrders) {
            /*if("未确认".equals(order.getOrderStatus())){
                String phone="";
                PhoneOrderVo temp = new PhoneOrderVo();
                User seller;
                seller = userMapper.selectByPrimaryKey(order.getSellerId());
                //用户数据不全 可能为空 引起空指针异常
                if(seller != null) phone = seller.getUphone();
                temp.setPhone(phone);
                temp.setOrder(order);
                ordersList.add(temp);
            }*/
            if(!"已确认".equals(order.getOrderStatus())){
                continue;
            }
            String phone="";
            PhoneOrderVo temp = new PhoneOrderVo();
            User seller;
            seller = userMapper.selectByPrimaryKey(order.getSellerId());
            //用户数据不全 可能为空 引起空指针异常
            if(seller != null) phone = seller.getUphone();
            temp.setPhone(phone);
            temp.setOrder(order);
            ordersList.add(temp);
        }
        return ordersList;
    }

    public List<History> getHistoryOrder(){
        List<History> historyList=historyMapper.selectHistoryAll();
        return historyList;
    }
    public List<CarInfo> getUncheckedCarInfo(){
        List<CarInfo> carInfoList=carInfoMapper.selectCarInfoAll();
        List<CarInfo> uncheckedCarInfoList=new ArrayList<CarInfo>();
        for (CarInfo carInfo : carInfoList) {
            if("待审核".equals(carInfo.getIslocked())){
                uncheckedCarInfoList.add(carInfo);
            }
        }
        return uncheckedCarInfoList;
    }
    public List<CarInfo> getSalableCarInfo(){
        List<CarInfo> carInfoList=carInfoMapper.selectCarInfoAll();
        List<CarInfo> uncheckedCarInfoList=new ArrayList<CarInfo>();
        for (CarInfo carInfo : carInfoList) {
            if("可出售".equals(carInfo.getIslocked())){
                uncheckedCarInfoList.add(carInfo);
            }
        }
        return uncheckedCarInfoList;
    }
    public List<CarInfo> getBookedCarInfo(){
        List<CarInfo> carInfoList=carInfoMapper.selectCarInfoAll();
        List<CarInfo> uncheckedCarInfoList=new ArrayList<CarInfo>();
        for (CarInfo carInfo : carInfoList) {
            if("已被预订".equals(carInfo.getIslocked())){
                uncheckedCarInfoList.add(carInfo);
            }
        }
        return uncheckedCarInfoList;
    }
    public List<CarInfo> getSoldCarInfo(){
        List<CarInfo> carInfoList=carInfoMapper.selectCarInfoAll();
        List<CarInfo> uncheckedCarInfoList=new ArrayList<CarInfo>();
        for (CarInfo carInfo : carInfoList) {
            if("已出售".equals(carInfo.getIslocked())){
                uncheckedCarInfoList.add(carInfo);
            }
        }
        return uncheckedCarInfoList;
    }
    public List<CarInfo> getAllCarInfo(){
        return carInfoMapper.selectCarInfoAll();
    }
}
