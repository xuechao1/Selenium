package com.xuechao.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

    /**
     * 打开chrome浏览器哦
     * 打开百度首页
     * 等待5S
     * 关闭浏览器
     */
    public class BrowseTest {
        WebDriver driver;
        @BeforeMethod
        public void openBrowse(){
            System.setProperty("webdriver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        @Test
        public void test1() throws InterruptedException {
             //打开百度页面
           // driver.get("http://www.baidu.com");
            driver.navigate().to("https://www.baidu.com");
            //等待3s关闭
            Thread.sleep(2000);
         }

        /**
         * 打开chrome浏览器
         * 打开百度首页
         * 等待3S
         * 后退一下
         * 等待3S
         * 前进一下
         * 等待3S
         * 关闭浏览器
         */
        @Test
        public void backTest1() throws InterruptedException {
        //打开百度首页
            driver.get("http://www.baidu.com");
            //等待3S
            Thread.sleep(3000);
            //后退一下
            driver.navigate().back();
            Thread.sleep(3000);
            driver.navigate().to("http://www.google.com");
            //前进一下
            driver.navigate().forward();
            Thread.sleep(3000);
            //刷新一下
            driver.navigate().refresh();
            Thread.sleep(3000);
        }

        /**
         * 设置浏览器大小
         * 打开chrome浏览器哦
         * 设置窗口300*300
         * 等待3S
         * 最大化
         * 等待3S
         * 全屏
         * 关闭浏览器
         */
        @Test
        public void windowChromeTest() throws InterruptedException {
            //实例化窗口
            Dimension dimension = new Dimension(300,300);
            //设置窗口大小
            driver.manage().window().setSize(dimension);
            //等待3S
            Thread.sleep(3000);
            //最大化
            driver.manage().window().maximize();
            //全屏
            //driver.manage().window().fullscreen();
            //等待3S
            Thread.sleep(3000);
        }

        /**
         * 设置浏览器大小
         * 打开chrome浏览器哦
         * 打开百度首页
         * 获取当前URL
         * 等待3S
         * 校验当前页面URL是不是百度地址
         * 关闭浏览器
         */
        @Test
        public void UrlTest1() throws InterruptedException {

            driver.get("http://www.baidu.com");
            //等待3S
            Thread.sleep(3000);
            //获取Url地址
            String url = driver.getCurrentUrl();
            //输入Url地址
            System.out.println("这是获取的Url地址"+url);
            //校验获取Url地址是否正确
            Assert.assertEquals(url,"https://www.baidu.com/");
        }

        @AfterMethod
        public void closeBrowse(){
            driver.quit();
        }

    }

