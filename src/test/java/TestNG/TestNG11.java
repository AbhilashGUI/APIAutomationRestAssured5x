package TestNG;

import org.testng.annotations.Test;

public class TestNG11 {

    @Test(groups = {"required"},priority = 2)
    public void gettoken()
    {
        System.out.println("Able to fetch token");
    }
    @Test(groups={"required"},priority = 1)
    public void getbookingid()
    {
        System.out.println("Able to fetch bookingid");
    }

    @Test(dependsOnMethods = {"required.*"})
    public void deleterequest()
    {
        System.out.println("created booking id got deleted using the token");
    }
}
