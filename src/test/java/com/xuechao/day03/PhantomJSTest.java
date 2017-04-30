package com.xuechao.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/29.
 */
public class PhantomJSTest {

    @Test
    public void pjsTest() throws InterruptedException {
        //设置phantomsjs的项目路径
        System.setProperty("phantomjs.binary.path","E:\\Users\\Administrator\\IdeaProjects\\Selenium_Demo170410\\dirvers\\phantomjs.exe");
        //new 一个新的driver 进行实例化操作
        WebDriver driver = new PhantomJSDriver();
        //打开百度页面
        driver.get("http://www.baidu.com");
        //输入关键字phantomJS
        driver.findElement(By.id("kw")).sendKeys("phantomJS");

        Thread.sleep(3000);
        //获取标题
        String a = driver.getTitle();
        //输出标题
        System.out.println(a);

        driver.quit();
    }

}
