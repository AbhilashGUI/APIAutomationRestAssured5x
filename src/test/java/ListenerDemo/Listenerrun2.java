package ListenerDemo;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Customlistener2.class)
public class Listenerrun2 {

    @Test(groups = "Smoke")
    public void testcase1()
    {
        System.out.println("Execute me");
        Assert.assertFalse(true);
    }

    @Test(groups = "Smoke")
    public void testcase2()
    {
        System.out.println("Execute me too");
        Assert.assertFalse(false);
    }
}