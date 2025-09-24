package TestNG;

import org.testng.annotations.Test;

public class TestNG10 {


    @Test
    public void serverstartedok()
    {
        System.out.println("I will run first");
    }


    @Test(dependsOnMethods = "serverstartedok")
    public void method()
    {
        System.out.println("Method 1 to be executed next");
    }
}
