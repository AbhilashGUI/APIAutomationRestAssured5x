package ListenerDemo;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Customlistener.class)
public class Listenerrun {

    @Test(groups = "Sanity")
    public void testcase1()
    {
       System.out.println("Test case 1");
       Assert.assertTrue(true);
    }

    @Test(groups = "Sanity")
    public void testcase2()
    {
        System.out.println("Test case 2");
        Assert.assertFalse(false);
    }


}