package WebTests;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ReadExcelData {

    @DataProvider(name = "testdata")
    @Test
    public String [][] readData() throws IOException {
        File file = new File(System.getProperty("user.dir") + "/Excel.xlsx");
        FileInputStream fileInputStream = new FileInputStream(file);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("TestData");
        //String data = xssfSheet.getRow(0).getCell(0).getStringCellValue();
        //System.out.println(data);
        int noOfRows = xssfSheet.getPhysicalNumberOfRows();
        int noOfCells = xssfSheet.getRow(0).getLastCellNum();
        String [] [] data = new String[noOfRows -1][noOfCells];
        for(int i=0; i<noOfRows-1; i++){
            //XSSFRow row = xssfSheet.getRow(i);
            for(int j=0; j<noOfCells; j++){
                //XSSFCell cell = row.getCell(j);
                DataFormatter dataFormatter = new DataFormatter();
                data [i][j]=dataFormatter.formatCellValue(xssfSheet.getRow(i+1).getCell(j));

            }
        }
        xssfWorkbook.close();
        fileInputStream.close();
        return data;
    }
}
