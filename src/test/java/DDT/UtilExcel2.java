package DDT;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel2 {

    static Workbook book;
    static Sheet sheet;
    public static String File_name="src/test/java/DDT/Test Data2.xlsx";

    public static Object[][] gmailaccountcred(String sheetname)
    {
        FileInputStream file=null;

        try {
            file=new FileInputStream(File_name);   //Open the excel
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            book= WorkbookFactory.create(file);   //Create the objects in workbook
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet=book.getSheet(sheetname);   //get the requested sheet
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i< sheet.getLastRowNum();i++)
        {
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
            {
               data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }

       return data;
    }

   @DataProvider
    public Object[][] getdata()
   {
       return gmailaccountcred("sheet1");
   }
}
