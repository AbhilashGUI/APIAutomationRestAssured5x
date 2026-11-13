package DDT;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UtilExcel1 {

    static Workbook workbook;
    static Sheet sheet;
    public static String filepath="src/test/java/DDT/Test Data1.xlsx";

    public static Object[][] getmobilelogins(String Sheetname)
    {
        FileInputStream fileInputStream=null;

        try {
            fileInputStream=new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            workbook=WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet=workbook.getSheet(Sheetname);

        Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i=0;i< sheet.getLastRowNum();i++)
        {
            for (int j=0;j<sheet.getRow(0).getLastCellNum();j++)
            {
                data[i][j]=sheet.getRow(i+1).getCell(j).toString();
            }
        }
        return data;
    }

    @DataProvider
    public Object[][] getdata()
    {
        return getmobilelogins("Sheet1");
    }
}