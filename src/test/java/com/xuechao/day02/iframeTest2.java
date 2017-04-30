package com.xuechao.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    /**
     * Created by Administrator on 2017/4/16.
     */
    public class iframeTest2 {
        WebDriver driver;
        //JS弹窗就是用鼠标获取不到 返回定位值
        //JS警告弹窗才需要用到switchTo，alert， 界面的登录弹窗不能使用switchTo，需要用一般的处理方法
        @BeforeMethod
        public void openBrowse(){
            //打开chrome浏览器
            System.setProperty("webdirver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
            driver = new ChromeDriver();

            /*//打开火狐浏览器  geckodriver.exe
            System.setProperty("webdirver.fixfore.driver","D:\\DriverTest\\geckodriver.exe");
            driver = new FirefoxDriver();*/
        }

        @Test
        public void iframeTest(){
            //iframe  没有name也没有id处理方法
            //把整串的iframe当场一个 元素 传进来
            //通过webelement方式
            driver.get("file:///C:/selenium_html/index.html");
            //通过webElement方式   用tagName来定位Iframe   并 将iframe传递进来
            WebElement iframe = driver.findElement(By.tagName("iframe"));
            //把driver的权限 转交给 iframe
            driver.switchTo().frame(iframe);
            //此时 用iframe就可以打开 baidu
            driver.findElement(By.linkText("baidu")).click();

        }

        //JS警告弹窗才需要用到switchTo， 界面的登录弹窗不能使用switchTo，需要用一般的处理方法
        @AfterMethod
        public void closeBrowse() throws InterruptedException {
            Thread.sleep(1000);
            driver.quit();
        }

    }
