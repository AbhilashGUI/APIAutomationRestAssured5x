package DDT;

import org.testng.annotations.Test;

public class DDT02 {


    @Test(dataProvider = "getdata",dataProviderClass = UtilExcel1.class)
    public void logincred(String mobilenumber,String otp)
    {
        System.out.println("Mobilenumber > "+mobilenumber);
        System.out.println("Otp > "+otp);
    }
}