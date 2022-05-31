package com.sx.web.controller;

import com.sx.service.SellCarService;
import com.sx.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;



@Controller
@RequestMapping("/home")

public class HomeController
{
    @Resource
    private UserService userService;
    @Resource
    private SellCarService sellCarService;

//
//    @RequestMapping("/usercenter")
//    public ModelAndView toUserCenter(HttpServletRequest request){
//        HttpSession session=request.getSession();
//        String user_id = (String) session.getAttribute("user");
//        User user = userService.selectByPrimaryKey(user_id);
//        ModelAndView model=userService.showUserInfo(user);
//        return model;
//    }

    @RequestMapping("/buycar")
    public String buyCar(HttpServletRequest request){

        return null;
    }
    //主页：我要卖车
    @ResponseBody
    @RequestMapping("/sellcar")
    public String sellCar(HttpServletRequest request,@RequestParam("file")MultipartFile file) throws FileNotFoundException, IOException {
        Random random = new Random();
        int result = random.nextInt(60000) % 26001 + 34000;
            //MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        sellCarService.saveBaseInfo(request,result);
        if (!file.isEmpty()) {
            sellCarService.savePicture(file, request, result);//保存图片
        }
        return "提交成功！";

    }
}
