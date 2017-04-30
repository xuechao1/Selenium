package com.xuechao.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/4/22.
 */
public class ChromeOp {

    @Test
    public void test1() throws InterruptedException {
        String downloadFilepath = "D:\\";

        HashMap<String,Object> chromeProfs = new HashMap<String, Object>();
        chromeProfs.put("profile.default_content_setting.popups",0);
        chromeProfs.put("download.default_directory",downloadFilepath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",chromeProfs);

        System.setProperty("webdriver.chrome.driver","D:\\DriverTest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);

        driver.get("http://rj.baidu.com/soft/detail/13478.html?ald");
        driver.findElement(By.className("normal_download")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
