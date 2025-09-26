package Parallel;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mainclass2 {

    @BeforeMethod
    public void beforemethod()
    {
        long id=Thread.currentThread().getId();
        System.out.println("BM thread "+ id +getClass().getSimpleName());
    }

    @Test
    public void testcase1()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Thread "+ id + getClass().getSimpleName());
    }

    @Test
    public void testcase2()
    {
        long id=Thread.currentThread().getId();
        System.out.println("Thread "+id+getClass().getSimpleName());
    }

    @AfterMethod
    public void aftermethod()
    {
        long id=Thread.currentThread().getId();
        System.out.println("AM thread "+ id +getClass().getSimpleName());
    }
}
