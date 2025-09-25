package DDT;

import org.testng.annotations.Test;

public class DDT02
{

    @Test(dataProvider = "getdata",dataProviderClass = UtilExcel1.class)
    public void userlogin(String Mobilenumber, String OTP)
    {
        System.out.println("Mobilenumber --"+Mobilenumber);
        System.out.println("OTP--"+OTP);
    }
}
