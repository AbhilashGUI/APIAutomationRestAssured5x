package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG01 {


    @Test
    public void testcase1()
    {
        Assert.assertEquals(true,false);
    }

    @Test
    public void testcase2()
    {
        Assert.assertEquals(true, true);
    }
}
