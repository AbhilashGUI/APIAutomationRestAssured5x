package DDT;

import org.testng.annotations.Test;

public class DDT03 {

    @Test(dataProvider="getdata",dataProviderClass = UtilExcel2.class)
    public void gmailsignin(String username,String password)
    {
        System.out.println("Username--"+username);
        System.out.println("Password--"+password);
    }
}