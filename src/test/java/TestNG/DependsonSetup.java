package TestNG;

import org.testng.annotations.Test;

public class DependsonSetup {


    @Test
    public void serverstarted()
    {
        System.out.println("I'll run first");
    }

    @Test(dependsOnMethods = "serverstarted")
    public void runprogram()
    {
        System.out.println("Followed by me");
    }

    @Test(dependsOnMethods = "runprogram")
    public void output()
    {
        System.out.println("View the console for result");
    }
}