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
 * Created by Administrator on 2017/4/17.
 */
public class SelectTest2 {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    /**
     * 打开测试界面
     * 下拉框选择vivo
     * 第二次选择huawei
     * 第三次 选择 iphone
     */
    @Test
    public void openChrome() throws InterruptedException {
        //打开浏览器
        driver.get("file:///C:/selenium_html/index.html");
        //定位下拉框
        WebElement selectLL = driver.findElement(By.id("moreSelect"));
        //实例化select
        Select select = new Select(selectLL);
        //通过索引来 取值
        select.selectByIndex(2);
        Thread.sleep(1000);
        //通过value来取值
        select.selectByValue("huawei");
        Thread.sleep(1000);
        //通过标签之间的link来取值
        select.selectByVisibleText("iphone");
    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

}
