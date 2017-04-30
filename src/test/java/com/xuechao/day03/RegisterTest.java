package com.xuechao.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/29.
 */
public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowse(){
        System.setProperty("webdirver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://mail.163.com/");
    }
    //163邮箱注册案例
    @Test
    public void registest(){
        //定位 去注册 按钮 发现 在iframe中
        //将driver权限交给 iframe
        driver.switchTo().frame("x-URS-iframe");
        //定位 去注册 并点击
        driver.findElement(By.id("changepage")).click();
        //打开新窗口 并将driver权限转交给新窗口
        //设置窗口页面的句柄值
        String handle1 =  driver.getWindowHandle();
        //此处用冒号：判断是否相等
        for ( String handles : driver.getWindowHandles()){
            //handles 是否等于handle1用equals作为等号
            if (handles.equals(handle1)){
                continue;
            }
            //将driver权限转交给新的窗口
            driver.switchTo().window(handles);
        }
        //把时间戳强制从long转换成string
        String time = String.valueOf(System.currentTimeMillis());
        String time1 = String.valueOf(System.currentTimeMillis()/100);
        //定位邮箱地址，并输入关键字
        driver.findElement(By.id("nameIpt")).sendKeys("main"+time);
        //定位密码，并输入关键字
        driver.findElement(By.id("mainPwdIpt")).sendKeys("1351859a");
        //定位确认密码，并输入关键字
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("1351859a");
        //定位手机号，并输入关键字
        driver.findElement(By.id("mainMobileIpt")).sendKeys(time1);
        //定位图片验证码，并输入关键字
        driver.findElement(By.id("vcodeIpt")).sendKeys("123456");
        //定位短信验证码，并输入关键字
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("456789");
        //定位立即注册按钮，并点击
        driver.findElement(By.id("mainRegA")).click();

        //显示等待(智能等待)
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='m_mainAcode']/span")));

        String text = driver.findElement(By.xpath(".//*[@id='m_mainAcode']/span")).getText();
        Assert.assertEquals(text,"  手机验证码不正确，请重新填写");
    }

    @Test
    public void timecase(){
        //输出获取的时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
