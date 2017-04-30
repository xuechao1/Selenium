package com.xuechao.day01;


import org.testng.annotations.Test;

    /**
     * Created by Administrator on 2017/4/10.
     * static如何调用，静态变量（带有static标识）可以直接调用，非静态变量不能直接变量，需要new一个新的；
     */
    public class ABtest {

        @Test
        public void tt() {
        AB abclass = new AB();
        abclass.bb();
        }

        @Test
        public void ttt(){

            AB.aa();
        }
}
