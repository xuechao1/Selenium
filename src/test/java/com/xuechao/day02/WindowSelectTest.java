package com.xuechao.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/16.
 */
    public class WindowSelectTest {
        WebDriver driver;
        @BeforeMethod
        public void openChrome(){
            System.setProperty("webdriver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        /**
         * 打开测试界面
         * 点击 open new window
         * 在新的窗口点击 baidu
         */
        public void openWindowTest(){
            driver.get("file:///C:/selenium_html/index.html");
            driver.findElement(By.linkText("Open new window")).click();
//            driver当前页面所在的句柄值
            String handle1 = driver.getWindowHandle();
//            for循环 判断获取到的handles是否等于 handle1
            for(String handles : driver.getWindowHandles()) {
                if (handles.equals(handle1)) {
                    continue;
                }else {
                    driver.switchTo().window(handles);
                }
            }
            driver.findElement(By.linkText("baidu")).click();
        }

        @AfterMethod
        public void closeBrowse(){
            driver.quit();
        }
    }
