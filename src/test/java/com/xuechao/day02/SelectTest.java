package com.xuechao.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    /**
     * Created by Administrator on 2017/4/16.
     */
    public class SelectTest {
        WebDriver driver;
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
         * 打开我们的测试页面
         * 下拉框选择vivo
         * 第二次选择 huawei
         * 第三次选择iphone
         */
        @Test
        public void selectOption() throws InterruptedException {
            //打开 浏览器
            driver.get("file:///C:/selenium_html/index.html");
            //定位 下拉框
            WebElement moreSelect = driver.findElement(By.id("moreSelect"));
            //实例化 select 类
            Select select = new Select(moreSelect);
            //通过 索引  选择 下拉框
            select.selectByIndex(2);
            Thread.sleep(2000);
            //通过 属性 value 值来选择下拉框
            select.selectByValue("huawei");
            Thread.sleep(2000);
            //通过 文本值 来选择  下拉框
            select.selectByVisibleText("iphone");
            Thread.sleep(1000);
        }

        @AfterMethod
         public void closeBrowse(){
            driver.quit();
        }

    }
