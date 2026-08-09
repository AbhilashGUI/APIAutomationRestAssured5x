package  TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {


    @BeforeSuite
    public void Suite()
    {
        System.out.println("Before suite");

    }

    @BeforeTest
    public void Test()
    {
        System.out.println("Before test");
    }

    @BeforeClass
    public void Class()
    {
        System.out.println("Before class");
    }


    @BeforeMethod
    public void Method()
    {
        System.out.println("Before method");
    }

    @Test
    public void testcase1()
    {
        System.out.println("Execute me");
    }

    @Test
    public void testcase2()
    {
        System.out.println("Execute me too");
    }

    @AfterSuite
    public void Suite2()
    {
        System.out.println("After suite");
    }

    @AfterTest
    public void Test2()
    {
        System.out.println("After test");
    }

    @AfterClass
    public void Class2()
    {
        System.out.println("After class");
    }

    @AfterMethod
    public void Method2()
    {
        System.out.println("After method");
    }

}