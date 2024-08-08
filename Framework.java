package Testing;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.io.FileOutputStream;
import java.io.IOException;
//import org.apache.commons.collections4.ListValuedMap;


public class Framework
{
	WebDriver driver;	
	
	 public static void main(String[] args) throws IOException 
     {

        String excelFilePath = ".\\sheet\\1.xlsx";        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("NewSheet");
      
        Object[][] data = {{"Title", "Subject", "Description"},
                           {"Data1", "Data2", "Data3"},
                           {"Data4", "Data5", "Data6"},
                           {"Data7", "Data8", "Data9"}};
                           
        for (int i = 0; i < data.length; i++)
        {
        		//create row
        		XSSFRow row = sheet.createRow(i);           
            	for (int j = 0; j < data[i].length; j++) 
            	{            	
            		//create cell
            		XSSFCell cell = row.createCell(j);              
            		//fetch value of cell
            		cell.setCellValue(String.valueOf(data[i][j]));            
            	}
        }        
        

        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) 
        {
            workbook.write(outputStream);
        }

        workbook.close();
        System.out.println("Excel file written successfully.");
    }


}
