package TestNG;

import org.testng.annotations.Test;

public class TestNG08 {

    @Test(groups = {"Smoke","QA1","QA2"})
    public void Smokerun()
    {
        System.out.println("Smoke");
        System.out.println("QA1");
        System.out.println("QA2");
    }

    @Test(groups={"Sanity","SR.QA1","SR.QA2"})
    public void Sanityrun()
    {
        System.out.println("Sanity");
        System.out.println("Sr.QA1");
        System.out.println("Sr.QA2");
    }

    @Test(groups = {"Regression","Lead1","Lead2"})
    public void regressionrun()
    {
        System.out.println("Regression");
        System.out.println("Lead1");
        System.out.println("Lead2");
    }
}
