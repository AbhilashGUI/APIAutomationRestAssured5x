package TestNG;

import org.testng.annotations.Test;

public class PriorityandGroups {


    @Test(groups = {"required"},priority = 0)
    public void getoken()
    {
        System.out.println("Token is generated");
    }

    @Test(groups = {"reuired"},priority = -1)
    public void getbookingid()
    {
        System.out.println("Booking id is readable");
    }

    @Test(dependsOnMethods = {"required.*"})
    public void deletebooking()
    {
        System.out.println("Able to deletebooking");
    }

}