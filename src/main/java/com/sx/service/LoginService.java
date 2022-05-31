package com.sx.service;



import com.sx.pojo.Admin;
import com.sx.pojo.User;
import com.sx.util.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.text.ParseException;

public interface LoginService
{
    public User checkLogin(String username, String password) throws FileNotFoundException;
    public Admin checkAdminLogin(String username, String password);
    public void processRegister(HttpServletRequest request) throws ServiceException, ParseException;

    public void processActivate(HttpServletRequest request) throws ServiceException, ParseException;

}
