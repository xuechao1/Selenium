package com.xuechao.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

    /**
     * Created by Administrator on 2017/4/14.
     */
    public class CloseBrowserTest {

        @Test
        public void closeBrowser() throws InterruptedException {
            //设置chromedriver路径
            System.setProperty("webdriver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
            //实例化chromedriver
            WebDriver webDriver = new ChromeDriver();
            //等待5s
            Thread.sleep(5000);
            //完全关闭浏览器
            webDriver.quit();
            //关闭当前浏览器
    //      webDriver.close();
        }

    }
