package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class MultipleUsercredentials {

    //DDT- Data Driven Testing
    //Testing of multiple user logins using 2D Array

    @DataProvider
    public Object[][] getdata() {
        return new Object[][]
                {
                        {"Abhilash", "Test1"},
                        {"Abhishek", "Test2"},
                        {"Amith", "Test3"},
                        {"Ananth", "Test4"}
                };

    }

    @Test(dataProvider = "getdata")
    public void logincredentials(String username, String password)
    {
        System.out.println(username);
        System.out.println(password);
    }
}