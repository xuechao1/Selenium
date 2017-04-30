package com.xuechao.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/4/17.
 */
public class ActionsTest2 {
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
     * 打开百度页面
     * 在 百度一下 按钮上 右键
     */
    @Test
    public void rightClickTest(){
        //打开 百度 页面
        driver.get("http://www.baidu.com");
        //定位 百度一下 按钮
        WebElement baiduButton = driver.findElement(By.id("su"));
        // 实例化 actions 并传参driver
        Actions actions = new Actions(driver);
        //百度一下 按钮 右键 并传参
        actions.contextClick(baiduButton).perform();
    }

    /**
     * 打开百度页面
     * 双击  百度一下
     */
    @Test
    public void doubleClick() throws InterruptedException {
        //打开 百度页面
        driver.get("http://www.baidu.com");
        //定位 百度一下 按钮
        WebElement baiduButton = driver.findElement(By.id("su"));
        //等待2S
        Thread.sleep(2000);
        //实例化  actions 并传参（driver）
        Actions actions = new Actions(driver);
        //双击 百度一下  按钮
        actions.doubleClick(baiduButton).perform();

    }
    /**
     * 打开测试界面
     *  鼠标移动到action 按钮
     *  那么显示 helloworld
     *
     */
    @Test
    public void moveAction() throws InterruptedException {
        //打开 测试页面
        driver.get("file:///C:/selenium_html/index.html");
        //定位 到 action 位置
        WebElement element = driver.findElement(By.xpath(".//*[@id='action']/input"));
        //实例化 actions
        Actions actions = new Actions(driver);
        //移动到 action
        actions.moveToElement(element).perform();
        //获取 当移动到action时自动出现的文本 Hello World
        String hello = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        Thread.sleep(3000);
        //校验 获取文本结果
        Assert.assertEquals(hello,"Hello World!");
    }

    /**
     * 打开测试界面
     * 选中一个 东西
     * 从一个地方 移动 到 另一个 地方
     */
    @Test
    public void moveAtoBTest() throws InterruptedException {
        //打开 移动图标测试界面
        driver.get("file:///C:/selenium_html/dragAndDrop.html");
        // 定位 可移动图标
        WebElement element = driver.findElement(By.id("drag"));
            // 实例化actions
        Actions actions = new Actions(driver);
        // 将该 移动图标 拖动到  （485，485）
        // 必须在移动，右键，双击，拖动 后面 加上perform()执行语句，不然无法运行
        actions.dragAndDropBy(element,500,500).perform();
        // 等待2S
        Thread.sleep(2000);
    }

    /**
     * 打开测试界面
     * 定位需要移动的 元素
     * 移动到 别的地方
     */
    @Test
    public void dropToTest() throws InterruptedException {
        //打开测试界面
        driver.get("file:///C:/selenium_html/dragAndDrop.html");
        //定位 需要移动的 元素element1
        WebElement element1 = driver.findElement(By.id("drag"));
        //定位需要 移动到的 地方 为element2
        WebElement element2 = driver.findElement(By.xpath("/html/body/h1"));
        //实例化actions
        Actions actions = new Actions(driver);
        //点击不松element1               移动到element2区域     释放element1       执行命令
        actions.clickAndHold(element1).moveToElement(element2).release(element1).perform();
        Thread.sleep(2000);
    }

    /**
     * 打开测试界面
     * 定位多选框
     * 选择第一个 跟第三个
     */
    @Test
    public void duoXuanTest() throws InterruptedException {
        //打开测试界面
        driver.get("file:///C:/selenium_html/index.html");
        //定位 多选框位置
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //拿到多选框下的所有可以选择的元素
        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        //实例化Actions
        Actions actions = new Actions(driver);
        //      因为第一个是默认选择的 故 此处 不写点击 代码 ，不然最终结果变成灰色 不能选中了
        //      按下ctrl键            点击第三个           释放ctrl键           执行命令
        actions.keyDown(Keys.CONTROL).click(list.get(2)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
    }

    /**
     * 打开百度页面
     * 保存页面
     * ctrl + s 保存
     * enter 确定
     */
    @Test
    public void saveHtml() throws AWTException, InterruptedException {
        //打开 测试界面
        driver.get("http://www.baidu.com");
        //实例化 robot 类
        Robot robot = new Robot();
        // 按住 ctrl 键
        robot.keyPress(KeyEvent.VK_CONTROL);
        // 按住s 键
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(2000);
        // 按住 enter键 确定
        robot.keyPress(KeyEvent.VK_ENTER);
        //释放 ctrl键
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    /**
     * 打开测试界面
     * 上传一张图片
     */
    @Test
    public void sendKeys() throws InterruptedException {
        //打开测试界面
        driver.get("file:///C:/selenium_html/index.html");
        //先定位    在上传文件
        driver.findElement(By.id("load"))
                .sendKeys("E:\\360download\\XX-Net-3.2.9\\SwitchyOmega\\AutoProxy.xpi");
        Thread.sleep(2000);
    }

}
