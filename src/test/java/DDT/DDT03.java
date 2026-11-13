package DDT;

import org.testng.annotations.Test;

public class DDT03 {


    @Test(dataProvider = "getdata",dataProviderClass = UtilExcel2.class)
    public void gmailsignin(String Username,String Password)
    {
        System.out.println("Username >"+Username);
        System.out.println("Password >"+Password);
    }
}