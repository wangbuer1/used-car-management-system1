package com.sx.dao;

import com.sx.pojo.User;
import com.sx.pojo.CarInfo;

import java.util.List;


public interface AdminMapper {
    List<User> getAllUser();
    User searchUser(User user);
    List<CarInfo> getAllCarInfo();
    int deleteUser(String uid);
}
