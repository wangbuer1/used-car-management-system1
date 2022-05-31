package com.sx.service;


import com.sx.pojo.User;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

public interface UserService {
//    public User login(User user) throws Exception;    //

    public ModelAndView showUserInfo(User user);//by

    public int deleteByPrimaryKey(String id);

    public int insert(User record);

    public int insertSelective( User record);

    public User selectByPrimaryKey(String id);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);

    public List<User> getAllUser();

    public int deleteUser(String uid);
}
