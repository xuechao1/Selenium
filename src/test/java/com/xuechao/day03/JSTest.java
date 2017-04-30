package com.xuechao.day03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/22.
 */
public class JSTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowse(){
        System.setProperty("webdirver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void exJS() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //driver强制转换成JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //JS注入,执行
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");
        Thread.sleep(5000);
    }



    @AfterMethod
    public void closeBrowse() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
