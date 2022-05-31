package com.sx.web.controller.Admin;

import com.sx.dao.HistoryMapper;
import com.sx.dao.OrderMapper;
import com.sx.pojo.*;
import com.sx.pojo.Vo.PhoneOrderVo;
import com.sx.service.AdminService;

import java.util.List;

import com.sx.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/adminController")
public class AdminController {
    /*@Autowired
    private AdminMapper adminMapper;*/
    @Autowired
    private AdminService adminService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CarInfoService carInfoService;
    @Autowired
    HistoryMapper historyMapper;

    @RequestMapping("/all_user")
    public ModelAndView get_all_user(HttpServletRequest request, ModelAndView modelAndView){
        List<User> users=adminService.getAllUser();
        System.out.println(users.toString());
        modelAndView.addObject("itemsList",users);
        modelAndView.setViewName("admin/all_user");
        return modelAndView;
    }
    @RequestMapping("/delete_user")
    public ModelAndView delete_user(String id,ModelAndView modelAndView){
        int result=adminService.deleteUser(id);
        String msg="fail";
        if(result>0){
            msg="success";
        }
        List<User> users=adminService.getAllUser();
        modelAndView.addObject("itemsList",users);
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("admin/all_user");
        return modelAndView;
    }

    @RequestMapping("/unfinished_order")
    public ModelAndView get_unfinished_order(ModelAndView modelAndView){
        List<PhoneOrderVo> orderList=adminService.getUnfinishedOrder();
        System.out.println(orderList);
        modelAndView.addObject("itemsList",orderList);
        modelAndView.setViewName("admin/unfinished_order");
        return modelAndView;
    }
    @RequestMapping("/delete_order")
    public ModelAndView delete_order(String orderid,ModelAndView modelAndView){
        int result=adminService.deleteOrder(orderid);
        String msg="";
        if(result>0){
            msg="delete order success";
        }
        else {
            msg="delete order fail";
        }
        List<PhoneOrderVo> orderList=adminService.getUnfinishedOrder();
        System.out.println(orderList);
        modelAndView.addObject("itemsList",orderList);
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("admin/unfinished_order");
        return modelAndView;
    }

    @RequestMapping("/check_order")
    public ModelAndView check_order(ModelAndView modelAndView){
        List<PhoneOrderVo> orderList=adminService.getUncheckedOrder();
        System.out.println(orderList);
        modelAndView.addObject("itemsList",orderList);
        modelAndView.setViewName("admin/finished_order");
        return modelAndView;
    }
    @RequestMapping("/history_order")
    public ModelAndView get_history_order(ModelAndView modelAndView){
        List<History> orderList=adminService.getHistoryOrder();
        System.out.println(orderList);
        modelAndView.addObject("itemsList",orderList);
        modelAndView.setViewName("admin/history");
        return modelAndView;
    }
    @RequestMapping("/delete_history")
    public ModelAndView delete_history(ModelAndView modelAndView,String historyId){
        int result=adminService.deleteHistory(historyId);
        String msg="";
        if(result>0){
            msg="delete order success";
        }
        else {
            msg="delete order fail";
        }
        List<History> orderList=adminService.getHistoryOrder();
        System.out.println(orderList);
        modelAndView.addObject("itemsList",orderList);
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("admin/history");
        return modelAndView;
    }
    @RequestMapping("/unchecked_car")
    public ModelAndView get_unchecked_car(ModelAndView modelAndView){
        List<CarInfo> carInfoList=adminService.getUncheckedCarInfo();
        System.out.println(carInfoList);
        modelAndView.addObject("itemsList",carInfoList);
        modelAndView.setViewName("admin/unchecked_car");
        return modelAndView;
    }
    @RequestMapping("/salable_car")
    public ModelAndView get_salable_car(ModelAndView modelAndView){
        List<CarInfo> carInfoList=adminService.getSalableCarInfo();
        System.out.println(carInfoList);
        modelAndView.addObject("itemsList",carInfoList);
        modelAndView.setViewName("admin/salable_car");
        return modelAndView;
    }
    @RequestMapping("/booked_car")
    public ModelAndView get_booked_car(ModelAndView modelAndView){
        List<CarInfo> carInfoList=adminService.getBookedCarInfo();
        System.out.println(carInfoList);
        modelAndView.addObject("itemsList",carInfoList);
        modelAndView.setViewName("admin/booked_car");
        return modelAndView;
    }
    @RequestMapping("/sold_car")
    public ModelAndView get_sold_car(ModelAndView modelAndView){
        List<CarInfo> carInfoList=adminService.getSoldCarInfo();
        System.out.println(carInfoList);
        modelAndView.addObject("itemsList",carInfoList);
        modelAndView.setViewName("admin/sold_car");
        return modelAndView;
    }
    @RequestMapping("/all_car")
    public ModelAndView get_all_car(ModelAndView modelAndView){
        List<CarInfo> carInfoList=adminService.getAllCarInfo();
        System.out.println(carInfoList);
        modelAndView.addObject("itemsList",carInfoList);
        modelAndView.setViewName("admin/all_car");
        return modelAndView;
    }
    @RequestMapping("/check_car")
    public ModelAndView check_car(String car_id,String islocked,ModelAndView modelAndView){
        CarInfo carInfo = carInfoService.selectByPrimaryKey(car_id);
        carInfo.setIslocked(islocked);
        carInfoService.updateByPrimaryKey(carInfo);

        List<CarInfo> carInfoList=adminService.getUncheckedCarInfo();
        System.out.println(carInfoList);
        modelAndView.addObject("itemsList",carInfoList);
        modelAndView.setViewName("admin/unchecked_car");
        return modelAndView;
    }
    @RequestMapping("/order2history")
    public ModelAndView order2history(String history_id,String buyer_id,String car_id,String seller_id,ModelAndView modelAndView){
        //更新汽车状态为已出售
        Order orderTemp = orderMapper.selectByPrimaryKey(history_id);
        CarInfo carInfo = carInfoService.selectByPrimaryKey(car_id);
        carInfo.setIslocked("已出售");
        carInfoService.updateByPrimaryKey(carInfo);
        //删除操作
        orderMapper.deleteByPrimaryKey(history_id);
        //History表添加记录
        History record = new History();
        record.setHistoryId(history_id);
        record.setBuyerId(buyer_id);
        record.setCarId(car_id);
        record.setSellerId(seller_id);
        historyMapper.insert(record);

        String msg="success";

        modelAndView.addObject("msg",msg);
        List<PhoneOrderVo> orderList=adminService.getUncheckedOrder();
        modelAndView.addObject("itemsList",orderList);
        modelAndView.setViewName("admin/finished_order");
        return modelAndView;
    }
}
