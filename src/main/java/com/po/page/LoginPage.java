package com.po.page;

import org.openqa.selenium.By;

/**
 * Created by Administrator on 2017/4/30.
 */
public class LoginPage {
    //用PO框架 统一 管理元素的定义 定位
    //PO 页面对象库  分为两层  一个是 本页面 -》Page层
    //另一个是 具体业务实现层（就是调用本页面定位方法的页面）

    //定义 帐号输入文本框
    public static By emailInput = By.name("email");
    //定义 密码输入框
    public static By pwdInput = By.name("password");
    //定义 登录 按钮
    public static By loginButton = By.id("dologin");
    //定义 去注册 按钮
    public static By zhuceButton = By.id("changepage");


}
