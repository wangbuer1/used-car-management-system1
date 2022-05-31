package com.sx.web.controller;


import com.sx.dao.HistoryMapper;
import com.sx.pojo.Admin;
import com.sx.pojo.History;
import com.sx.pojo.User;
import com.sx.service.LoginService;
import com.sx.util.MD5Util;
import com.sx.web.controller.TestController.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

//    @Autowired
//    UserMapper userMapper;
//    @Autowired
//    HttpSession session;

    /**
     * 显示登录界面,完成登录验证
     *
     * @return
     */
    @Autowired
    HistoryMapper historyMapper;
    @Resource
    private LoginService loginService;
    //登录界面
    @RequestMapping("/login")
    public String login() {
        return "login-multi";
    }
    //登录成功 进入主页
    @RequestMapping("/home")
    public String home(HttpServletRequest request) {

        return "home1.1";
    }
    //登录验证
    @RequestMapping("/checklogin")
    @ResponseBody
    public String checkLogin(HttpSession session,HttpServletRequest request) throws IOException {
        User user = loginService.checkLogin(request.getParameter("username"), MD5Util.encode2hex(request.getParameter("password")));
//        String user = user1.getUid();
        if (user != null) {
//            HttpSession session=request.getSession();
            session.setAttribute("user",user.getUid());
            System.out.println("UCK:"+user);
            return "success";
        } else { return "fail";}
    }

    //管理员登录
    @RequestMapping("/adminlogin")
    @ResponseBody
    public String checkAdminLogin(HttpServletRequest request) throws IOException{
        Admin admin=loginService.checkAdminLogin(request.getParameter("username"),request.getParameter("password"));

        if (admin != null) {
//            HttpSession session=request.getSession();
            session.setAttribute("admin",admin);
            System.out.println("———————****admin123登录了****—————————");
            System.out.println(admin.toString());
            return "success";
        } else { return "fail";}
    }
    //管理员进入历史订单
    @RequestMapping("/history")
    public ModelAndView historyManage(){
        ModelAndView modelAndView = new ModelAndView();
        List<History> historyList = historyMapper.selectHistoryAll();
        modelAndView.addObject("itemsList",historyList);
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }
}
