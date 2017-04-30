package com.xuechao.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

    /**
     * 比较a跟b是否一样
     */
    public class tetest {
        @Test
        public void ttt(){
            int a = 1;
            int b = 2;
            Assert.assertNotEquals(a, b);
        }

        /**
         * 校验 是否 为空值
         */
        @Test
        public void tt1(){
    //        int a = 3;
            String b = null;
    //        Assert.assertNull(a);
            Assert.assertNull(b);
        }

}
