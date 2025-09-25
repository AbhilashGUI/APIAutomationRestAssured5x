package DDT;

import org.testng.annotations.Test;

public class DDT03 {


    @Test(dataProvider = "getdata",dataProviderClass = UtilExcel2.class)
    public void gmailsignin(String emailaddress,String password)
    {
        System.out.println("Emailaddress-"+emailaddress);
        System.out.println("Password-"+password);
    }
}
