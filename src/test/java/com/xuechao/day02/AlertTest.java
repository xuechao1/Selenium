package com.xuechao.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    /**
     * Created by Administrator on 2017/4/16.
     */
    public class AlertTest {
        WebDriver driver;
        //JS弹窗就是用鼠标获取不到 返回定位值
        //JS警告弹窗才需要用到switchTo，alert， 界面的登录弹窗不能使用switchTo，需要用一般的处理方法
        @BeforeMethod
        public void openBrowse(){
            //打开chrome浏览器
            System.setProperty("webdirver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
            driver = new ChromeDriver();

            /*//打开火狐浏览器  geckodriver.exe
            System.setProperty("webdirver.firefox.driver","D:\\DriverTest\\geckodriver.exe");
            driver = new FirefoxDriver();*/
        }

        /**
         * 打开UI自动化测试界面
         * 点击Alert按钮
         * 在alert警告框点击确定按钮
         */
        @Test
        public void alertTest() throws InterruptedException {
            //JS警告弹窗才需要用到switchTo， 界面的登录弹窗不能使用switchTo，需要用一般的处理方法
            driver.get("file:///C:/index.html");
            //点击alert按钮，出现弹窗界面
            driver.findElement(By.className("alert")).click();
            Thread.sleep(1000);
            //把控制权转交给alert
            Alert alert = driver.switchTo().alert();
            //获取弹窗的文本值
            String text = alert.getText();
            //点击确定按钮，关闭弹窗
            alert.accept();
            Assert.assertEquals(text,"请点击确定");
        }

        /**
         * 打开UI自动化测试界面
         * 点击confirm按钮
         * 在confirm点击取消按钮
         * 再次点击确定按钮
         */
        @Test
        public void confirmTest() throws InterruptedException {
            //JS警告弹窗才需要用到switchTo， 界面的登录弹窗不能使用switchTo，需要用一般的处理方法
            //打开UI自动化测试界面
            driver.get("file:///C:/index.html");
            //点击confirm按钮
            driver.findElement(By.className("confirm")).click();
            //把driver权限转移给alert
            Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
            //点击取消按钮
            alert.dismiss();
            //等待2S
            Thread.sleep(2000);
            //点击确定按钮
            alert.accept();
        }

        /**
         * 打开UI自动化测试界面
         * 点击Prompt按钮
         * 在Prompt弹窗中，输入“这个是”
         * 点击确定/取消 按钮
         * 再次点击确定按钮
         */
        @Test
        public void promptTest() throws InterruptedException {
            //JS警告弹窗才需要用到switchTo， 界面的登录弹窗不能使用switchTo，需要用一般的处理方法
            //此处启动火狐浏览器是因为chrome浏览器不能上送关键字 属于chrome的BUG
            WebDriver driver = new FirefoxDriver();
            //启动UI自动化 测试界面
            driver.get("file:///C:/index.html");
            //点击prompt按钮
            driver.findElement(By.className("prompt")).click();
            //等待2S
            Thread.sleep(2000);
            //把driver的权限转交给alert
            Alert alert =driver.switchTo().alert();
            //上送关键字
            alert.sendKeys("prompt");
            Thread.sleep(2000);
            //点击确定
            alert.accept();
            Thread.sleep(2000);
            alert.accept();
            Thread.sleep(1000);
            //关闭浏览器
            driver.quit();
        }

        //JS警告弹窗才需要用到switchTo， 界面的登录弹窗不能使用switchTo，需要用一般的处理方法
        @AfterMethod
        public void closeBrowse(){
            driver.quit();
        }
    }
