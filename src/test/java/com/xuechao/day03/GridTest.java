package com.xuechao.day03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/4/29.
 */
public class GridTest {

    @Test
    public void  testChrome() throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.108:8888/wd/hub"),dc);

        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }

    @DataProvider(name = "data4")
    //DataProvider 注解 有返回值 且  必须为 Object[][]
    public Object[][] test1(){
        return new Object[][]{
                {"firefox"},
                {"chrome"}};
/*                分别用火狐和谷歌浏览器在不同的服务器上跑
                {"firefox","http://192.168.0.108:8888/wd/hub"},
                {"chrome","http://192.168.0.108:6666/wd/hub"}};*/
    }

    @Test(dataProvider = "data4")
    public void testGrid2(String browser) throws InterruptedException, MalformedURLException {
//        public void testGrid2(String browser,String url) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc = null;
        if (browser.equals("firefox")){
            dc = DesiredCapabilities.firefox();
        }else if (browser.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            System.out.println("error");
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.108:8888/wd/hub"),dc);
/*        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),dc);*/

        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();

    }


}
