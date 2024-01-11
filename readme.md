# 基于SSM二手车交易管理系统1

## 获取方式

关注公众号： **程序员王不二**，回复关键词  ： “**二手车1** ”   

 ![](https://www.codeshop.fun/Typora-Images/202205281253739.png)


# 基于SSM二手车交易管理系统

## 1、项目介绍

基于SSM二手车交易管理系统拥有两个角色，用户和管理员

**用户**：查看车辆详情、出售车辆、个人出售车辆挂历、个人订单管理，购物车管理

管理员：车辆管理、订单管理、用户管理


## 2、项目技术

后端框架：SSM（Spring、SpringMVC、Mybatis）

前端框架：Bootstrap、jsp、css、JavaScript、JQuery

## 3、开发环境

- JAVA版本：JDK1.8，其它版本理论上可以
- IDE类型：IDEA、Eclipse、Myeclipse都可以。推荐IDEA与Eclipse
- tomcat版本：Tomcat 7.x、8.x、9.x、版本均可
- 数据库版本：MySql 5.5-5.7
- maven版本：无限制
- 硬件环境：Windows 或者 Mac OS


## 4、功能介绍

### 4.1 登录

![登录](https://www.codeshop.fun/Typora-Images/202205311732832.jpg)

### 4.2前端 模块

![首页](https://www.codeshop.fun/Typora-Images/202205311732671.jpg)

![车辆详情](https://www.codeshop.fun/Typora-Images/202205311732969.jpg)

用户可以多条件筛选车辆，还可以下单，将车辆加入购物车

### 4.3 用户模块

![用户-车辆管理](https://www.codeshop.fun/Typora-Images/202205311733275.jpg)

![用户-订单管理](https://www.codeshop.fun/Typora-Images/202205311733306.jpg)

![用户-购物车](https://www.codeshop.fun/Typora-Images/202205311733811.jpg)

![用户-发布二手车辆信息](https://www.codeshop.fun/Typora-Images/202205311733234.jpg)

- 车辆管理：用户可以查看自己出售的车辆信息，并能够下架车辆
- 订单管理：用户可以查看订单信息，并能够取消订单
- 车辆发布：用户可以发布二手车辆信息
- 购物车：用户可以查看添加到购物车中的车辆信息，并能够将车辆移除购物车

### 4.4管理员 模块

![管理员-待审车辆管理](https://www.codeshop.fun/Typora-Images/202205311737469.jpg)

![管理员-可出售车辆管理](https://www.codeshop.fun/Typora-Images/202205311738470.jpg)

![管理员-订单管理](https://www.codeshop.fun/Typora-Images/202205311738432.jpg)

![管理员-预定车辆管理](https://www.codeshop.fun/Typora-Images/202205311738241.jpg)

![管理员-用户管理](https://www.codeshop.fun/Typora-Images/202205311738611.jpg)

车辆管理：管理员可以查看和删除待审核的、可出售的、已被预订的、已出售和所有的车辆信息

订单管理：管理员可以查看和删除订单信息

用户管理：管理员可以查看和删除用户信息



