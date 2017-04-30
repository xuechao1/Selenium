package com.xuechao.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

    /**
     * Created by Administrator on 2017/4/15.
     */
    public class FindElementsTest {
        WebDriver driver;
        @BeforeMethod
        //打开浏览器
        public void openChrome(){
            System.setProperty("webdriver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        /**
         * 打开百度页面
         * 通过ID定位搜索文本框
         */
        @Test
        public void byIDTest(){
            //打开百度页面
            driver.get("http://www.baidu.com");
            //定位查找属性为kw的文本框
            WebElement keyWorld = driver.findElement(By.id("kw"));
            //driver.findElement(By.id("kw"))
        }

        /**
         * 打开百度页面
         * 通过name定位搜索文本框
         */
        @Test
        public void byNameTest(){
            //打开百度页面
            driver.get("http://www.baidu.com");
            //定位查找属性为kw的文本框
            WebElement keyWorld = driver.findElement(By.name("wd"));
    //        driver.findElement(By.name("kw"));
        }

        /**
         * 打开百度页面
         * 通过class属性定位搜索文本框
         */
        @Test
        public void byClassNameTest(){
            //打开百度页面
            driver.get("http://www.baidu.com");
            //定位查找属性为kw的文本框
            WebElement keyWorld = driver.findElement(By.className("bg s_btn_wr"));
    //       driver.findElement(By.className("bg s_btn"));
        }

        /**
         * 打开百度页面
         * 通过linkText属性定位搜索文本框
         */
        @Test
        public void byLinkTextTest() {
            //打开百度页面
            driver.get("http://www.baidu.com");
            //定位查找属性为kw的文本框
            WebElement keyWorld = driver.findElement(By.linkText("学术"));
        }

        /**
         * 打开百度页面
         * 通过partialLinkText属性定位搜索文本框(部分属性)
         */
        @Test
        public void byPartialLinkTextTest() {
            //打开百度页面
            driver.get("http://www.baidu.com");
            //定位查找属性为kw的文本框
            WebElement keyWorld = driver.findElement(By.partialLinkText("学"));
        }

        /**
         * 打开百度页面
         * 通过tagName属性定位搜索文本框
         */
        @Test
        public void byTagNameTest() {
            //打开百度页面
            driver.get("http://www.baidu.com");
            //定位查找属性为intput的文本框
            List<WebElement> list = driver.findElements(By.tagName("intput"));
            System.out.println(list.size());
        }

        /**
         * 打开百度页面
         * 通过xpath属性定位  百度一下按钮
         */
        @Test
        public void byXpathTest() {
            //打开百度页面
            driver.get("http://www.baidu.com");
            //通过xpath属性定位  百度一下按钮
            WebElement xpath1 = driver.findElement(By.xpath(".//*[@id='su']"));
        }

        /**
         * 打开百度页面
         * 通过CSS属性定位  百度一下 图片
         */
        @Test
        public void byCSSTest() {
            //打开百度页面
            driver.get("http://www.baidu.com");
            //通过xpath属性定位  百度一下按钮
            WebElement xpath1 = driver.findElement(By.cssSelector("#lg>img"));
        }

        /**
         * 打开百度页面
         * 通过xpath属性定位  百度页面的所有顶部元素
         */
        @Test
        public void byXpath() {
            //打开百度页面
            driver.get("http://www.baidu.com");
            //通过xpath属性定位  顶部的所有选项
            //如果是用xpath找到了多个元素，但是用了fingElement那么只能默认返回第一个xpath定位出来的
            List<WebElement> xpath2 = driver.findElements(By.xpath(".//*[@id='u1']/a"));
            //获取元素的文本xpath2.get(0).getText();  从第一个开始 就是0，因为有返回值，所以赋值
            for (int i = 0; i <xpath2.size() ; i++) {
                //获取百度页面顶部所有的类似 新闻 这种字样
                String text = xpath2.get(i).getText();
                System.out.println(text);
            }
        }

        @AfterMethod
        public void closeChrome(){
            driver.quit();
        }

    }


