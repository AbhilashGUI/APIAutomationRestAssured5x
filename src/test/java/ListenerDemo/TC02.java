package ListenerDemo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Customlistener2.class)
public class TC02 {

    @Test(priority = 2)
    public void testcase1()
    {
        System.out.println("This will run third");
        Assert.assertTrue(true);
    }

    @Test
    public void testcase2()
    {
        System.out.println("This will run second");
        Assert.assertFalse(false);
    }

    @Test(priority = -1)
    public void testcase3()
    {
        System.out.println("This will run first");
        Assert.assertFalse(false);
    }


}
