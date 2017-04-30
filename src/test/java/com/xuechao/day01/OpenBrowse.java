package com.xuechao.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

    /**
     * Created by Administrator on 2017/4/13.
     */
    public class OpenBrowse {

        @Test
        public void openfirefox(){
    //        实例化
            WebDriver webDriver = new FirefoxDriver();//默认安装在c盘programe file(*86)下就可以直接启动
        }

        @Test
        public void HF2(){
            System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            WebDriver webDriver = new FirefoxDriver();
        }

        @Test
        public void hrome(){

            WebDriver chromeDriver = new ChromeDriver();
        }

        @Test
        public void chrome(){
            //设置chromedriver路径
            System.setProperty("webdriver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
            WebDriver webDriver = new ChromeDriver();
        }
        @Test
        public void IE(){

            WebDriver IEdriver = new InternetExplorerDriver();
        }


        @Test
        public void IE1() {
            System.setProperty("webdriver.IE.driver", "D:\\DriverTest\\IEDriverServer.exe");
            WebDriver webDriver = new InternetExplorerDriver();
        }
    }
