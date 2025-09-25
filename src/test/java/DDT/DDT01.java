package DDT;

import org.testng.annotations.Test;

public class DDT01 {
    // Test Data to be read from the Excel File - Data Provider
    // Apache POI, - 60-70% - little difficult to understand first time.
    // Fillo Library - 30% - Super Easy!


    // Test case- login where we will inject the username and password

    // Excel -> There is no support directly in Java to Read the Excel file
    // Apache POI library is used
    // Excel - 2007 - xls, 2007 -> xlsx , CSV - comma seperated values


    // Example:username, password , ER , AR, name, age, phone, CSV
    // JSON file it will be different
    // JSON Object -> Gson, Jackson you can use

    @Test(dataProvider = "getData",dataProviderClass = UtilExcel.class)
    public void testlogindata(String username, String password)
    {
        System.out.println("Username-- "+ username);
        System.out.println("Password-- "+ password);
    }

}
