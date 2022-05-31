package com.sx.service;

import com.sx.dao.*;
import com.sx.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Random;

/**
 * Created by Administrator on 2017/7/20.
 */

@Service("sellCarService")
public class SellCarServiceIml implements SellCarService
{
    @Resource
    CarInfoMapper carInfoDao;
    @Resource
    PicMapper picMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void savePicture(MultipartFile file, HttpServletRequest request,int result) throws IOException, FileNotFoundException {

        String classPath = ResourceUtils.getURL("classpath:").getPath();
        classPath = classPath.substring(1);
        System.out.println("类路径="+classPath);
        String ImagePath = classPath.replace("WEB-INF/classes/", "resources/img/car_pic");

        System.out.println("上传图片路径="+ImagePath);
//       String ImagePath ="D:\\ssm_car\\target\\com.voyage\\resources\\img\\car_pic";
        File targetfile = new File(ImagePath,result+file.getOriginalFilename());

        InputStream ins = file.getInputStream();
        FileOutputStream fos = new FileOutputStream(targetfile);

        byte b[] = new byte[1024];
        int temp = 0;

        while((temp = ins.read(b)) != -1){
            fos.write(b, 0, temp);
        }

        Random random = new Random();
        int result1 = random.nextInt(60000) % 26001 + 34000;
        Pic pic=new Pic();
        pic.setCarId(String.valueOf(result));
        pic.setPicUrl("img/car_pic/"+targetfile.getName());
        pic.setPicId(String.valueOf(result1));
        picMapper.insert(pic);

        fos.close();
        ins.close();
    }

    @Override
    public void saveBaseInfo(HttpServletRequest request, int result) {
        CarInfo carInfo=new CarInfo();
        carInfo.setCarId(String.valueOf(result));
        carInfo.setBrand(request.getParameter("brand"));
        carInfo.setCarName(request.getParameter("car_name"));
        carInfo.setCarAge(Double.parseDouble(request.getParameter("car_age")));
        carInfo.setCarMileage(Double.parseDouble(request.getParameter("car_mileage")));
        carInfo.setEngine(request.getParameter("engine"));
        carInfo.setConfName(request.getParameter("conf_name"));
        carInfo.setLevel(request.getParameter("level"));
        carInfo.setGearbox(request.getParameter("gearbox"));
        carInfo.setBodyStructure(request.getParameter("body_structure"));
        carInfo.setSize(request.getParameter("size"));
        carInfo.setMaximumspeed(request.getParameter("maximumspeed"));
        carInfo.setCargoVolume(request.getParameter("cargo_volume"));
        carInfo.setCarDamage(request.getParameter("car_damage"));
        carInfo.setIseager(request.getParameter("iseager"));
        carInfo.setPrice(Double.parseDouble(request.getParameter("price")));
        carInfo.setLicenseAddress(request.getParameter("license_address"));
        carInfo.setAddress(request.getParameter("address"));
        carInfo.setIslocked("待审核");
        String user_id = (String)request.getSession().getAttribute("user");
        User user = userMapper.selectByPrimaryKey(user_id);
        carInfo.setUid(user_id);
        carInfoDao.insert(carInfo);
    }


}
