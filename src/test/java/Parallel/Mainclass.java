package Parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mainclass {


    @BeforeMethod
    public void beforemethod()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Thread id of before test method: "+ id + getClass().getSimpleName());
    }

    @Test
    public void testcase1()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Thread id for case 1 :"+ id + getClass().getSimpleName());
    }

    @Test
    public void testcase2()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Thread id for case 2 :"+ id + getClass().getSimpleName());
    }


    @Test
    public void testcase3()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Thread id for case 3 :"+ id + getClass().getSimpleName());
    }

    @AfterMethod
    public void aftermethod()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Thread id of after test method "+ id +getClass().getSimpleName());
    }
}
//Note: In the testng xml file , we are running the 3cases  at the class level using T1 and T2