package Parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExecution {


    @BeforeMethod
    public void Beforemethod()
    {
        long id1=Thread.currentThread().getId();
        System.out.println("Before method thread = "+id1 + " "+getClass().getSimpleName());
    }

    @Test
    public void testcase1()
    {
        long id2=Thread.currentThread().getId();
        System.out.println("Test case 1 thread = "+id2+ " "+getClass().getSimpleName());
    }

    @Test
    public void testcase2()
    {
        long id3=Thread.currentThread().getId();
        System.out.println("Test case 2 thread = "+id3+ " "+getClass().getSimpleName());
    }
    @AfterMethod
    public void Aftermethod()
    {
        long id4=Thread.currentThread().getId();
        System.out.println("After method thread = "+id4+ " "+getClass().getSimpleName());
    }
}