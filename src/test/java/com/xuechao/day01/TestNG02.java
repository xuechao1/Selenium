package com.xuechao.day01;


import org.testng.annotations.Test;

    /**
     * Created by Administrator on 2017/4/11.
     */
    public class TestNG02 {
        /**
         * 校验登录是否成功
         */
        @Test
        public void assertEqualsTest(){
            String a = "adcd";
            String b = "abcdsgf";
            System.out.println("登陆 ");
            org.testng.Assert.assertEquals(a,b,"校验登录成功");
            org.testng.Assert.assertEquals(a,b,"用户名是否ok");
            //assert之后除了assert类型的 校验，别的一概不再写，想写就重新再写一个case
    //       org.testng.Assert.assertEquals(a,b);

            /*System.out.println("操作打开页面删除");
            org.testng.Assert.assertEquals(a,b,"删除成功");*/
        }

        /**
         * 校验登录
         */
        @Test
        public void assertEqualsTest1(){
            String a = "adcd";
            String b = "adcd";
            System.out.println("登陆 ");
            System.out.println("操作打开页面删除");
            org.testng.Assert.assertEquals(a,b,"删除成功");
        }
}
