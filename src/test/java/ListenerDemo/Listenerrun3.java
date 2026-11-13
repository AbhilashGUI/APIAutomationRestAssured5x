package ListenerDemo;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener3.class)
public class Listenerrun3 {

    @Test(groups = "SmokeTesting")
    public void testcase1()
    {
        System.out.println("Initial testing phase");
        Assert.assertTrue(true);
    }

    @Test(groups = "SanityTesting")
    public void testcase2()
    {
        System.out.println("Secondary testing phase");
        Assert.assertFalse(false);
    }
    @Test(groups = "RegressionTesting")
    public void testcase3()
    {
        System.out.println("Final testing phase");
        Assert.assertFalse(true);
    }






}
