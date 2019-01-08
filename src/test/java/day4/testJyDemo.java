package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testJyDemo {
    @Test
    public void  assertEqualsMethod(){
        //实际值
        String a="你好";
        //期望值
        String b="你好";
        Assert.assertEquals(a,b,"a不等于b");
    }

    @Test
    public void  assertNotEquals(){
        //实际值
        double i=3;
        //期望值
        double b=3;
        Assert.assertNotEquals(i,b,"i等于b");

    }

    @Test
    public void assertNotNull(){
        //实际值
        String a=null;
        Assert.assertNotNull(a,"为空");
    }

    @Test
    public void assertNull(){
        String b="null";
        Assert.assertNull(b,"不为空");
    }
}

