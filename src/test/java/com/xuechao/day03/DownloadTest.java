package com.xuechao.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Administrator on 2017/4/22.
 */
public class DownloadTest {

    @Test
    public void testFirefoxDown() throws InterruptedException, AWTException {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        //设置火狐的默认文件夹，0表示桌面，1表示我的下载；2表示自定义文件夹
        firefoxProfile.setPreference("browser.download.folderlist","2");
        //设置自定义文件夹
        firefoxProfile.setPreference("browser.download.dir","D://soft");
        //设置无需确认下载的文件格式
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/octect-stream,application/exe");
        //打开一个预先配置的火狐

        WebDriver driver = new FirefoxDriver(firefoxProfile);
        driver.get("http://rj.baidu.com/soft/detail/13478.html?ald");
//        driver.findElement(By.xpath(".//*[@id=''softAbs]/a[2]")).click();
        driver.findElement(By.className("normal_download")).click();

      /*  Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);*/

        Thread.sleep(3000);
        driver.quit();
    }
}
