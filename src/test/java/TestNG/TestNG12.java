package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG12 {

    //DDT- Data Driven Testing
    //Testing of multiple user login

    @DataProvider
    public Object[][] getdata() {
        return new Object[][]{
          new Object[]{"Abhilash","Test1"},
          new Object[]{"Sharma","Test2"},
          new Object[]{"Vicky","Test3"},
          new Object[]{"Vemula","Test4"},
          new Object[]{"Varun","Test5"}

        };
    }

    @Test(dataProvider= "getdata")
    public void logintest(String username, String password)
    {
        System.out.println(username);
        System.out.println(password);
    }
}
