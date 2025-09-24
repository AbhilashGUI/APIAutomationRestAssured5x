package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG09 {

    @Test
    public void testcase1()
    {
       /** SoftAssert sr=new SoftAssert();
        sr.assertEquals("true","false","True should not be false");
        System.out.println("Please execute me");**/


        //Since we are using the softassertions, able to execute though the ar!=er

        //Hardasseration
        Assert.assertEquals("true","false","Failed");
        System.out.println("This will not print");
    }
}
