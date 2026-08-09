package TestNG;

import org.testng.annotations.Test;

public class GroupsSetup {

    @Test(groups = {"Smoke","Sanity"})
    public void Smokerun()
    {
        System.out.println("Associate trainee");
        System.out.println("Associate");
        System.out.println("Test engineer");
    }

    @Test(groups = {"Sanity","Regression"})
    public void Sanityrun()
    {
        System.out.println("Senior Test engineer");
        System.out.println("Super Senior Test engineer");
    }

    @Test(groups = {"Regression","Automationscripts"})
    public void Regressionrun()
    {
        System.out.println("Test lead");
        System.out.println("Test Manager");
    }
}