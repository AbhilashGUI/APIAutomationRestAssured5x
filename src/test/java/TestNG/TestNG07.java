package TestNG;

import org.testng.annotations.Test;

public class TestNG07 {

    @Test(priority = 0)
    public void testcase1()
    {
        System.out.println("Test1");
    }

    @Test(priority = 1)
    public void testcase2()
    {
        System.out.println("Test2");
    }

    @Test(priority = -1)
    public void testcase3()
    {
        System.out.println("Test3");
    }
    @Test
    public void testcase4()
    {
        System.out.println("Test4");
    }
}
