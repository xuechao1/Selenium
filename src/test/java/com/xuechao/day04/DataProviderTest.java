package com.xuechao.day04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/4/23.
 */
public class DataProviderTest {
    //数据驱动（常用）
    @DataProvider(name = "loginUser")
    //Object类型是java.long
    public Object[][] data1() {
        return new Object[][] {
                {"user1","pwd1"},
                {"user2","pwd2"},
                {"sdfhdsj","sdkfls"}};
    }

    @Test(dataProvider = "loginUser")
    public void loginTest(String user,String pwd){
        System.out.println("user: "+user);
        System.out.println("pwd: "+pwd);
    }

}
