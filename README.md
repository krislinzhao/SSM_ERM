# SSM_ERM
此项目是ssm框架的企业权限管理.



# 1.功能介绍

## 1.1环境搭建

本项目是maven工程搭建,数据库是使用的mysql

## 1.2商品查询

基于SSM整合基础上完成商品查询，主面页面main.jsp及商品显示页面product-list.jsp页面的创建。

## 1.3 商品添加
进一步巩固SSM整合，并完成商品添加功能，要注意事务操作以及product-add.jsp页面生成。
## 1.4 订单查询
订单的查询操作，它主要完成简单的多表查询操作，查询订单时，需要查询出与订单关联的其它表中信息，了解订单及其它表关联关系

## 1.5 订单分页查询
订单分页查询，使用的是mybatis分页插件PageHelper，要掌握PageHelper的基本使用。
## 1.6 订单详情查询
订单详情是用于查询某一个订单的信息，掌握对复杂的多表查询操作。
## 1.7 Spring Security 概述
Spring Security是 Spring 项目组中用来提供安全认证服务的框架，它的使用很复杂，掌握spring Security的基本操作，掌握spring Security框架的配置及基本的认证与授权操作。

## 1.8 用户管理

用户管理是基于spring Security的用户登录、退出操作。以及用户查询、添加、详情有等操作.

## 1.9 角色管理

角色管理主要完成角色查询、角色添加

## 1.10 资源权限管理

资源权限管理主要完成查询、添加操作，它的操作与角色管理类似，角色管理以及资源权限管理都是对权限管理的
补充。

## 1.11 权限关联与控制

主要是用户角色关联、角色权限关联，这两个操作是为了后续可以完成授权操作的基础.

## 1.12 AOP日志处理

AOP日志处理，使用spring AOP切面来完成系统级别的日志收集。

# 2数据库介绍

## 2.1产品表
| 序号 |   字段名称    |   字段类型   |        字段描述        |
| :--: | :-----------: | :----------: | :--------------------: |
|  1   |      id       |   int(11)    |          主键          |
|  2   |  productNum   | varchar(50)  | 产品编号，唯一，不为空 |
|  3   |  productName  | varchar(50)  |  产品名称（路线名称）  |
|  4   |   cityName    | varchar(50)  |        出发城市        |
|  5   | DepartureTime |  timestamp   |        出发时间        |
|  7   | productPrice  | decimal(10)  |        产品价格        |
|  7   |  productDesc  | varchar(500) |        产品描述        |
|  8   | productStatus |    int(1)    |  状态(0 关闭 1 开启)   |



## 2.2订单表

| 序号 |  字段名称   |   字段类型   |            字段描述             |
| :--: | :---------: | :----------: | :-----------------------------: |
|  1   |     id      |   int(11)    |              主键               |
|  2   |  orderNum   | varchar(50)  |      订单编号 不为空 唯一       |
|  3   |  orderTime  |   datetime   |            下单时间             |
|  4   | peopleCount |   int(10)    |            出行人数             |
|  5   |  orderDesc  | varchar(255) |       订单描述(其它信息)        |
|  6   |   payType   |    int(1)    | 支付方式(0 支付宝 1 微信 2其它) |
|  7   | orderStatus |    int(1)    |   订单状态(0 未支付 1 已支付)   |
|  8   |  productId  |   int(11)    |           产品id 外键           |
|  9   |  memberid   |   int(11)    |      会员(联系人）id 外键       |



## 2.3 会员表

| 序号 | 字段名称 |  字段类型   | 字段描述 |
| :--: | :------: | :---------: | :------: |
|  1   |    id    |   int(11)   |   主键   |
|  2   |   name   | varchar(20) |   姓名   |
|  3   | nickName | varchar(20) |   昵称   |
|  4   | phoneNum | varchar(20) | 电话号码 |
|  5   |  email   | varchar(20) |   邮箱   |



## 2.4 旅客表

| 序号 |    字段名称     |  字段类型   |            字段描述            |
| :--: | :-------------: | :---------: | :----------------------------: |
|  1   |       id        |   int(11)   |              主键              |
|  2   |      name       | varcahr(20) |              姓名              |
|  3   |       sex       | varcahr(20) |              性别              |
|  4   |    phoneNum     | varchar(20) |            电话号码            |
|  5   | credentialsType |   int(1)    | 证件类型 0身份证 1护照 2军官证 |
|  6   | credentialsNum  | varchar(50) |            证件号码            |
|  7   |  travellerType  |   int(1)    |  旅客类型(人群) 0 成人 1 儿童  |



## 2.5 用户表

| 序号 | 字段名称 |   字段类型   |      字段描述       |
| :--: | :------: | :----------: | :-----------------: |
|  1   |    id    |   int(11)    |        主键         |
|  2   |  email   | varchar(20)  |        邮箱         |
|  3   | username | varchar(20)  |       用户名        |
|  4   | password | varchar(255) |     密码(加密)      |
|  5   | phoneNum | varchar(20)  |        电话         |
|  6   |  status  |    int(1)    | 状态0 未开启 1 开启 |



## 2.6角色表

| 序号 | 字段名称 |   字段类型   | 字段描述 |
| :--: | :------: | :----------: | :------: |
|  1   |    id    |   int(11)    |   主键   |
|  2   | roleName | varchar(20)  |  角色名  |
|  3   | roleDesc | varchar(255) | 角色描述 |



## 2.7资源权限表

| 序号 |    字段名称    |   字段类型   | 字段描述 |
| :--: | :------------: | :----------: | :------: |
|  1   |       id       |   int(11)    |   主键   |
|  2   | permissionName | varcahr(20)  |  权限名  |
|  3   |      url       | varchar(255) | 权限路径 |



## 2.8日志表

| 序号 |   字段名称    |  字段类型   |   字段描述   |
| :--: | :-----------: | :---------: | :----------: |
|  1   |      id       |   int(11)   |     主键     |
|  2   |   visitTime   |  datetime   |   访问时间   |
|  3   |   username    | varchar(20) | 操作者用户名 |
|  4   |      ip       | varchar(50) |    访问ip    |
|  5   |      url      | varcahr(50) | 访问资源url  |
|  6   | executionTime |  datetime   |   执行时长   |
|  7   |    method     | varchar(20) |   访问方法   |

