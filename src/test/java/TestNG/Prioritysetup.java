package TestNG;

import org.testng.annotations.Test;

public class Prioritysetup {

    @Test(priority = 0)
    public void testcase1()
    {
        System.out.println("1");
    }

    @Test
    public void testcase2()
    {
        System.out.println("2");
    }

    @Test(priority = -1)
    public void testcase3()
    {
        System.out.println("3");
    }

    @Test(priority = 1)
    public void testcase4()
    {
        System.out.println("4");
    }
}