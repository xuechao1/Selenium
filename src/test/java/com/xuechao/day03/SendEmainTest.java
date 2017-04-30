package com.xuechao.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/29.
 */
public class SendEmainTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowse(){
        System.setProperty("webdirver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.163.com/");
    }

    @Test
    public void sendEmail(){
        //权限转移到frame
        driver.switchTo().frame("x-URS-iframe");
        //输入 用户名 密码
        driver.findElement(By.name("email")).sendKeys("meyoungtester");
        driver.findElement(By.name("password")).sendKeys("meyoung123");
        // 点击登录
        driver.findElement(By.id("dologin")).click();
        //定位 写信

        driver.findElement(By.xpath(".//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        //定位  收件人
        driver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("meyoung");
        //定位 标题
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("hello");
        //定位 附件路径
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("E:\\IMG_20150728_185644.jpg");
        //driver权限转交frame
        WebElement frame1 = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(frame1);
        // 定位输入框 输入文本
        driver.findElement(By.xpath("/html/body")).sendKeys("good afternoon");
        //driver权限返回主界面
        driver.switchTo().defaultContent();
        //定位发送按钮
        driver.findElement(By.xpath(".//*[text()='发送']")).click();
        //校验 是否发送成功
        Boolean bl = driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
//        Assert.assertEquals(bl,"发送成功");
        Assert.assertTrue(bl);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
