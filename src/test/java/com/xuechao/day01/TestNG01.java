package com.xuechao.day01;


import org.testng.annotations.*;

    /**
     * Created by Administrator on 2017/4/10.
     */
    public class TestNG01 {
        @BeforeTest
        public void beforeTest1(){
            System.out.println("这是BeforeTest注解");
        }

        @BeforeMethod
        public void beforeMethod01(){
            System.out.println("这是一个BeforeMethod注解");
        }

        @Test
        public void testCase1(){
            System.out.println("这是一个testcase1");
        }

        @Test
        public void testCase2(){
            System.out.println("这是一个testCase2");
        }

        @Test
        public void testCaseA(){
            System.out.println("这是一个testCaseA");
        }

        @Test
        public void testCaseB(){
            System.out.println("这是一个testCaseB");
        }

        @AfterMethod
        public void afterMethod01(){
            System.out.println("这是一个AfterMethod注解");
        }

        @AfterTest
        public void after(){
            System.out.println("这是一个afterTest注解");
        }

    }
