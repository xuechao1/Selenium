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
    public class iframeTest {
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

        /**
         * 打开百度界面
         * 点击百度链接
         */
        @Test
        public void iframeTest() throws InterruptedException {
            driver.get("file:///C:/selenium_html/index.html");
            //第一种方法
            //把driver权限转交给iframe
           /* driver.switchTo().frame("aa");
            driver.findElement(By.linkText("baidu")).click();*/
           //第二种方法
            //通过 ID 或者 name 转交控制权
            //通过webElement方式
            WebElement iframe = driver.findElement(By.tagName("iframe"));
            //把driver权限转移给iframe
            driver.switchTo().frame(iframe);
            //通过linkText来定位baidu位置，并点击 baidu
            driver.findElement(By.linkText("baidu")).click();
            //等待2S
            Thread.sleep(2000);
            //driver控制权转交给初始界面
            driver.switchTo().defaultContent();
            //点击 登录界面
            driver.findElement(By.linkText("登陆界面")).click();
            Thread.sleep(2000);
        }


        //JS警告弹窗才需要用到switchTo， 界面的登录弹窗不能使用switchTo，需要用一般的处理方法
        @AfterMethod
        public void closeBrowse() throws InterruptedException {
            Thread.sleep(1000);
            driver.quit();
        }
}
