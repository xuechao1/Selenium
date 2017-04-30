package com.xuechao.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/17.
 */
public class WaitTest {
    WebDriver driver;
    @BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
        driver = new ChromeDriver();
        //全局等待 10S
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowse(){
        driver.quit();
    }

    /**
     * 打开测试界面
     * 点击 wait 按钮
     * 获取文本 并 判断是否为“wait for display”
     */
    @Test
    public void openTest(){
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //获取 “wait for display”文本
        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div[1]")).getText();
        //校验 获取的文本
        Assert.assertEquals(text,"wait for display");
    }

    @Test
    public void openTest2(){
        driver.get("file:///C:/selenium_html/index.html");
        driver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div[1]")));

        String text = driver.findElement(By.xpath("//*[@id=\"display\"]/div[1]")).getText();
        Assert.assertEquals(text,"wait for display");

    }

}
