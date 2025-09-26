package ListenerDemo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Customlistener.class)
public class TC01 {

    @Test(groups = "sanity")
    public void test1() {
        System.out.println("Testcase1");
        Assert.assertTrue(true);
    }

    @Test(groups = "sanity")
    public void test2()
    {
        System.out.println("Testcase2");
        Assert.assertFalse(false);
    }
}