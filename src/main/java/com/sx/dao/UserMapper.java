package com.sx.dao;

import java.util.List;
import com.sx.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);

    User selectByUsernameForAdmin(String username);

    User selectByUemail(String uemail);

    List<User> getAllUser();

    int deleteUser(String uid);
}