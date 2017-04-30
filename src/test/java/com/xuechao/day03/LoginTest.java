package com.xuechao.day03;

import com.po.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/29.
 */
public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowse(){
        System.setProperty("webdirver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
        driver = new ChromeDriver();
        //显示等待(智能等待)
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='m_mainAcode']/span")));

        driver.get("http://mail.163.com/");
    }

    @DataProvider(name = "userlist")
    //DataProvider 注解 有返回值 且  必须为 Object[][]
    public Object[][] test1(){
        return new Object[][]{
                {"user1","1234655"},
                {"user2","dfjsdflksdj"}};
    }

    @Test(dataProvider = "userlist")
    public void loginPoList(String username,String pwd){
        //driver权限交给frame
        driver.switchTo().frame("x-URS-iframe");
        //定位 帐号输入框
        driver.findElement(LoginPage.emailInput).sendKeys(username);
        //定位 密码输入框
        driver.findElement(LoginPage.pwdInput).sendKeys(pwd);
        //定位 登录 按钮
        driver.findElement(LoginPage.loginButton).click();

        //显示等待(智能等待)
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        String text = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");
    }

    @Test
    public void loginSuc(){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("meyoungtester");
        driver.findElement(By.name("password")).sendKeys("meyoung123");
        driver.findElement(By.id("dologin")).click();

        //显示等待(智能等待)
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));

        String text = driver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");
    }

    @Test
    public void loginError(){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys("meyoungtester");
        driver.findElement(By.name("password")).sendKeys("meyoung12312");
        driver.findElement(By.id("dologin")).click();

        //显示等待(智能等待)
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='nerror']/div[2]")));

        String text = driver.findElement(By.xpath(".//*[@id='nerror']/div[2]")).getText();
        //此时是屏蔽了验证码的功能
        Assert.assertEquals(text,"帐号或密码错误");
    }
  /*  //这个是简化登录错误和登录失败的两个简单的（比较Low）的封装
    public static void login(WebDriver driver,String email,String pwd){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.id("dologin")).click();
    }
*/

    @AfterMethod
    public void close(){
        driver.quit();
    }

}
