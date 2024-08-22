package Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.TimeoutException;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.netty.handler.timeout.TimeoutException;

public class AddMultipleProductBySheet 
{

    WebDriver driver;

    public void chrome() throws InterruptedException
   	{
   		System.setProperty("WebDriver.chromedriver","C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");
   		driver=new ChromeDriver();
   		driver.get("https://dev.poonamcoatings.com");
   		driver.manage().window().maximize();		

   		//login
   		WebElement Username=driver.findElement(By.xpath("//input[@id='email']"));
   		Username.sendKeys("admin@poonamcoatings.com");		
   		
   		WebElement Password=driver.findElement(By.xpath("//input[@id='password']"));
   		Password.sendKeys("Super@1234");
   		
   		WebElement Login=driver.findElement(By.xpath("//button[@type='submit']"));
   		Login.click();	
   		Thread.sleep(8000);			
   	}

    public void AddProductInventory(String ProductName, String ProductType, String ProductStandard,  String ProductCode, String HSNCode, String Description, String Brand, String Category, String SubCategory, String SubChildCategory,
            String PackSize, String UOM, String Quantity , String Color,  String PaintType, String FinishType,
            String UnitPrice, String SellingPrice) throws InterruptedException
    {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try
        {
            WebElement Addproductclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Products']")));
            Addproductclick.click();

            WebElement Addproductclickbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add Product']")));
            Addproductclickbutton.click();

            // Product Name
            WebElement productname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='productName']")));
            productname.sendKeys(ProductName);
            
            // Product Type
            WebElement producttype= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[1]")));
            producttype.click();            
            WebElement Producttypeselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + ProductType + "']")));
            Producttypeselect.click();
            Thread.sleep(2000);
                
            //Product Standard
            WebElement productstandard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[2]")));
            productstandard.click();            
            WebElement productstandardselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + ProductStandard + "']")));
            productstandardselect.click();
            Thread.sleep(2000);
                        
            //Product code
            WebElement productcode = driver.findElement(By.xpath("//input[@id='productCode']"));
            productcode.sendKeys(ProductCode);
                        
            //HSNCode
            WebElement hsnCode = driver.findElement(By.xpath("//input[@id='hsnCode']"));
            hsnCode.sendKeys(HSNCode);
            
            try            
            {
                Thread.sleep(2000);
                WebElement hsnCode1 = driver.findElement(By.xpath("//span[normalize-space()='" + HSNCode + "']"));
                hsnCode1.click();
            } 
            
            catch (Exception e)            
            {
                //System.out.println("HSN Code selection issue for product: " + ProductName);
                e.printStackTrace();
            }
            
            //Product Description
            WebElement description = driver.findElement(By.xpath("//textarea[@id='description']"));
            description.sendKeys(Description);

            // Product - Select Brand
            WebElement brandOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[3]")));
            brandOption.click();
            WebElement brandOptionclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + Brand + "']")));
            brandOptionclick.click();
            Thread.sleep(2000);

            // Select Category
            WebElement CategoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[4]")));
            CategoryOption.click();
            WebElement Category1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + Category + "']")));
            Category1.click();
            Thread.sleep(2000);

            // Select SubCategory
            WebElement subCategory = driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[5]"));
            subCategory.click();
            WebElement subCategory1 = driver.findElement(By.xpath("//span[normalize-space()='" + SubCategory + "']"));
            subCategory1.click();
            Thread.sleep(2000);          

            // PackSize
            WebElement packsize = driver.findElement(By.xpath("//input[@id='packSize']"));
            packsize.sendKeys(PackSize);
            Thread.sleep(2000);           
            
			// UOM
			// WebElement uom = driver.findElement(By.xpath("//div[@class='direct ']"));
			// uom.click();
			// WebElement uom1 = driver.findElement(By.xpath("//div[@class='col-2']//div[8]"));
			// uom1.click();            
			            
            //Pack Quantity
            WebElement quantity = driver.findElement(By.xpath("//input[@id='packQuantity']"));
            quantity.sendKeys(Quantity);            
            
            //Handle Color
            try 
            {
                WebElement color = driver.findElement(By.xpath("//input[@id='color']"));
                color.click();
                Thread.sleep(2000);            
                
                WebElement color1 = driver.findElement(By.xpath("//div[@class='drop-down-item2 selectedDropBox'] //span[normalize-space()='" + Color + "']"));
                color1.click();                  
               
            } 
            
            catch (Exception e) 
            {
               // System.out.println("Color selection issue for product: " + ProductName);
                e.printStackTrace();
            }

           
            // Handle PaintType
            try 
            {
                WebElement paintType = driver.findElement(By.xpath("//input[@id='paintType']"));
                paintType.sendKeys(PaintType);
                Thread.sleep(2000); // Wait for paint type options to load
                WebElement paintType1 = driver.findElement(By.xpath("//span[normalize-space()='" + PaintType + "']"));
                paintType1.click();
            } 
            
            catch (Exception e) 
            {
                System.out.println("Paint type selection issue for product: " + ProductName);
                e.printStackTrace();
            }

            // Handle FinishType
            try            
            {
                WebElement finishType = driver.findElement(By.xpath("//input[@id='finish']"));
                finishType.sendKeys(FinishType);
                Thread.sleep(2000); // Wait for finish type options to load
               
                WebElement finishType1 = driver.findElement(By.xpath("//span[normalize-space()='" + FinishType + "']"));
                finishType1.click();
            }
            catch (Exception e) 
            {
                System.out.println("Finish type selection issue for product: " + ProductName);
                e.printStackTrace();
            }
            

            // UnitPrice
            WebElement unitPrice = driver.findElement(By.xpath("//input[@id='unitPrice']"));
            unitPrice.sendKeys(UnitPrice);

//            // SellingPrice
//            WebElement sellingPrice = driver.findElement(By.xpath("//input[@id='sellingPrice']"));
//            sellingPrice.sendKeys(SellingPrice);
            
            // Save Button
            WebElement savebutton1 = driver.findElement(By.xpath("//button[@type='submit']"));
            savebutton1.click();
            
          //  Thread.sleep(2000); // Ensure enough time for the save operation
    		}
         
    catch(Exception e)
         {
        	 e.printStackTrace();
         }
        
    }
    
          
    public void addMulProductFromExcel(String excelFilePath) throws IOException, InterruptedException 
    {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\Product Sheet.xlsx");

        try (Workbook workbook = new XSSFWorkbook(inputStream)) 
        {
            Sheet sheet2 = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            for (int i = 1; i <= sheet2.getLastRowNum(); i++)
            {
                Row row = sheet2.getRow(i);
                String ProductName = dataFormatter.formatCellValue(row.getCell(0));
                String ProductType = dataFormatter.formatCellValue(row.getCell(1));
                String ProductStandard = dataFormatter.formatCellValue(row.getCell(2));
                String ProductCode = dataFormatter.formatCellValue(row.getCell(3));
                String HSNCode = dataFormatter.formatCellValue(row.getCell(4));
                String Description = dataFormatter.formatCellValue(row.getCell(5));
                String Brand = dataFormatter.formatCellValue(row.getCell(6));
                String Category = dataFormatter.formatCellValue(row.getCell(7));
                String SubCategory = dataFormatter.formatCellValue(row.getCell(8));
                String SubChildCategory = dataFormatter.formatCellValue(row.getCell(9));
                String PackSize = dataFormatter.formatCellValue(row.getCell(10));
                String UOM = dataFormatter.formatCellValue(row.getCell(11));
                String Quantity = dataFormatter.formatCellValue(row.getCell(12));             
                String Color = dataFormatter.formatCellValue(row.getCell(13));
                String PaintType = dataFormatter.formatCellValue(row.getCell(14));
                String FinishType = dataFormatter.formatCellValue(row.getCell(15));
                String UnitPrice = dataFormatter.formatCellValue(row.getCell(16));
                String SellingPrice = dataFormatter.formatCellValue(row.getCell(17));
                AddProductInventory(ProductName, ProductType, ProductStandard, ProductCode, HSNCode, Description, Brand, Category, SubCategory, SubChildCategory, PackSize, UOM, Quantity, Color, PaintType, FinishType, UnitPrice, SellingPrice);
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException 
    {
        AddMultipleProductBySheet addProducts = new AddMultipleProductBySheet();
        addProducts.chrome();
        addProducts.addMulProductFromExcel("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\Product Sheet.xlsx");
    }
}
