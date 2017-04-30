package com.xuechao.day02;

import org.apache.commons.io.FileUtils;
import org.eclipse.jetty.util.IO;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

    /**
     * Created by Administrator on 2017/4/16.
     */
    public class ActionsTest {
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
         * 点击百度首页的 新闻链接
         * 进入新闻页面
         */

        @Test
        public void clickNew(){
            //打开百度地址
            driver.get("http://www.baidu.com");
            //定位 新闻 链接
            WebElement newsLink = driver.findElement(By.name("tj_trnews"));
            //点击新闻链接
            newsLink.click();
            //获取新闻页面url
            String Url = driver.getCurrentUrl();
            //校验新闻压面地址是否正确
            Assert.assertEquals(Url,"http://news.baidu.com/");

        }

        /**
         * 打开百度首页
         * 输入关键字selenium
         * 点击百度一下进行搜索
         * 校验title名是否等于selenium_百度搜索
         */

        @Test
        public void sendKeys() throws InterruptedException {
            driver.get("http:www.baidu.com");
            //定位百度输入框的ID
            WebElement idInput = driver.findElement(By.id("kw"));
            //百度输入框上送selenium
            idInput.sendKeys("selenium");
            //定位百度按钮
           /* WebElement baiduButton = driver.findElement(By.id("su"));
            //点击百度按钮
            baiduButton.click();*/
            //另外一种快速打开chrome浏览器的java语句写法（上述语句的二合一）
            driver.findElement(By.id("kw")).click();
            //等待3S
            Thread.sleep(3000);
            //获取head中的title，页面title
            String title = driver.getTitle();
            //校验结果是否等于selenium_百度搜索
            Assert.assertEquals(title, "selenium_百度搜索");
        }

        @Test
        public void clearTest() throws InterruptedException {
            driver.get("http:www.baidu.com");
            //定位百度输入框的ID
            WebElement keyInput = driver.findElement(By.id("kw"));
            //百度输入框上送selenium
            keyInput.sendKeys("selenium");
            Thread.sleep(5000);
            //清空输入文本框
            keyInput.clear();

        }

        /**
         * 打开百度首页
         * 获取百度首页的新闻文本
         *
         * getText()一定获取标签中间的值
         */
        @Test
        public void getTextTest() {
            driver.get("http:www.baidu.com");
            //chrome浏览器反映快的一种方式
            String getText = driver.findElement(By.name("tj_trnews")).getText();
            Assert.assertEquals(getText,"新闻");
            //上下两种方式一样，用哪种都可以
            //chrome浏览器反映慢的一种方式
           /* WebElement text1= driver.findElement(By.name("tj_trnews"));
            String text = text1.getText();
            Assert.assertEquals(text,"新闻");*/

        }

        /**
         * 打开百度页面
         * 获取文本框的 tagName
         * 校验是否为input
         */
        @Test
        public void tagNameTest() throws InterruptedException {
            //打开百度页面
            driver.get("http://www.baidu.com");
            //获取页面的tagName值
            String tagName = driver.findElement(By.id("kw")).getTagName();
            //等待3S
            Thread.sleep(3000);
            //校验获取的tagName值
            Assert.assertEquals(tagName,"input");
        }

        /**
         * 打开百度页面
         * 判断按钮显示的文本值是否为  百度一下
         */
        @Test
        public void getAttributeTest(){
            driver.get("http://www.baidu.com");
            String getAttribute = driver.findElement(By.id("su")).getAttribute("value");
            Assert.assertEquals(getAttribute,"百度一下");
        }

        /**
         * 打开百度首页
         * 判断是否显示百度一下按钮
         */
        @Test
        public void isDisplayTest(){
            driver.get("http://www.baidu.com");
            Boolean b = driver.findElement(By.id("su")).isDisplayed();
            Assert.assertTrue(b);
        }

        /**
         * 打开index.html
         * 判断volvo单选框是否被选中
         *
         */
        @Test
        public void isSelectTest() throws InterruptedException {
            //打开index.html文件
            driver.get("file:///C:/index.html");
            /*//定位volvo
            Boolean b = driver.findElement(By.xpath("//*[@id="radio"]/input[1]")).isSelected();
            //等待3S
            Thread.sleep(3000);
            //校验没有被选中
            Assert.assertFalse(b);*/
            // 注意，选择定位的时候一定要选中哪个 下拉框/点击框
            WebElement element = driver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
            //选中点击
            element.click();
            Thread.sleep(2000);
            //判断是否选中
            Boolean b = element.isSelected();
            Assert.assertTrue(b);
        }

        /**
         * 打开测试页面
         * 判断submit按钮处于未激活状态
         */
        @Test
        public void isEnabledTest(){
            driver.get("file:///C:/index.html");
            Boolean b = driver.findElement(By.name("buttonhtml")).isEnabled();
            Assert.assertFalse(b);
        }

        /**
         * 打开百度界面
         * 截图百度界面  E:\screenshot\test1.jpg
         */
        @Test
        public void screenShotTest(){
            driver.get("http://www.baidu.com");

            File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(file,new File("E:\\screenshot\\test1.jpg"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        @AfterMethod
        public void closeBrowse(){
            driver.quit();
        }
    }
