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
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewPaintaddbysheet 
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
    
    public void createnewporduct(String PaintName, String ProductStd, String ProductCode, String HSNId, String Brand, String Category, String SubCategory, String SubChildCategory,	
    							String BasePaint1, String ProportionOfPaint1, String Tinter1, String ProportionOfTinter,
    							String BasePaint2, String ProportionOfPaint2, String PackSize, String ProductQtyLtr, 
    							String Color, String PaintType, String FinishType, String CostPrice, String MarginPer, String SellingPer) throws InterruptedException
    	
    	{
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));   
    	
    	try
    	{
        WebElement Addproductclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Products']")));
        Addproductclick.click();

        WebElement Createnewdproduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-primary header-btn header-btn-second']")));
        Createnewdproduct.click();
        

        // Paint Name
        WebElement Paintname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='paintName']")));
        Paintname.sendKeys(PaintName);
        
        
        //Product Standard
        WebElement productstandard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[1]")));
        productstandard.click();            
        WebElement productstandardselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + ProductStd + "']")));
        productstandardselect.click();
        Thread.sleep(2000);
                    
        //Product code
        WebElement productcode = driver.findElement(By.xpath("//input[@id='productCode']"));
        productcode.sendKeys(ProductCode);        
       
        
        WebElement hsnidInput = driver.findElement(By.xpath("//input[@id='hsnId']"));
        hsnidInput.sendKeys(HSNId);

        // Wait for the HSN dropdown to appear and select the correct value
        try
        {
            Thread.sleep(2000); // wait for dropdown to appear
            WebElement hsnDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='hsnSelectBox']")));
            WebElement hsnidSelect = hsnDropdown.findElement(By.xpath("//span[normalize-space()='" + HSNId + "']"));
            hsnidSelect.click();
        } 
        
        catch (Exception e) 
        {
            System.out.println("HSN Code selection issue: " + HSNId);
            e.printStackTrace();
        }
        
        
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
    	}
        
        catch(Exception e)
        {
       	 e.printStackTrace();
        }
        	
    	 //Base Paint Component 1    	
    	 WebElement basepaint1 = driver.findElement(By.xpath("//input[@id='basePaint1']"));
    	 basepaint1.sendKeys(BasePaint1);    	 
    	 Thread.sleep(2000);   	 
    	    	 
    	 WebElement Propaint1 = driver.findElement(By.xpath("//input[@id='proportionPaint1']"));
    	 Propaint1.sendKeys(ProportionOfPaint1);    
    	 
    	 WebElement tinter = driver.findElement(By.xpath("//input[@id='tinters1']"));
    	 tinter.sendKeys(Tinter1);    	 
    	 Thread.sleep(2000);  
    	
    	 WebElement proptinter1 = driver.findElement(By.xpath("//input[@id='proportionTinters']']"));
    	 proptinter1.sendKeys(ProportionOfTinter);    	
    	 
    	 WebElement basepaint2 = driver.findElement(By.xpath("//input[@id='basePaint2']"));
    	 basepaint2.sendKeys(BasePaint2);    	 
    	 Thread.sleep(2000);      	
    	 
    	 WebElement PropPaint2 = driver.findElement(By.xpath("//input[@id='proportionOfPaint2']"));
    	 PropPaint2.sendKeys(ProportionOfPaint2);     
    	 
//    	 WebElement uom3 = driver.findElement(By.xpath("//input[@id='basePaint1']"));
//    	 uom3.sendKeys(UOM);    	 
//    	 Thread.sleep(2000);  
    	 
    	 //PackSize
         WebElement packsize = driver.findElement(By.xpath("//input[@id='packSize']"));
         packsize.sendKeys(PackSize);
         Thread.sleep(2000);           
         
         // UOM
         WebElement uom = driver.findElement(By.xpath("//div[@class='direct ']"));
         uom.click();
         WebElement uom1 = driver.findElement(By.xpath("//div[@class='col-2']//div[8]"));
         uom1.click();            
         
         //Pack Quantity
         WebElement quantity = driver.findElement(By.xpath("//input[@id='packQuantity']"));
         quantity.sendKeys(ProductQtyLtr);            
         
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
             System.out.println("Paint type selection issue for product:" + PaintName);
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
             System.out.println("Finish type selection issue for product: " + PaintName);
             e.printStackTrace();
         }         

         // SellingPrice
         WebElement costprice = driver.findElement(By.xpath("//input[@id='sellingPrice']"));
         costprice.sendKeys(CostPrice);
         
         //Margin Percentage
         WebElement MarPercentage = driver.findElement(By.xpath("//input[@id='sellingPrice']"));
         MarPercentage.sendKeys(MarginPer);
         
         // Save Button
         WebElement savebutton1 = driver.findElement(By.xpath("//button[@type='submit']"));
         savebutton1.click();        
    }
    
    
    
    public void CreateMulProductFromExcel(String excelFilePath) throws IOException, InterruptedException 
    {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\CreateNewProduct.xlsx");

        try (Workbook workbook = new XSSFWorkbook(inputStream)) 
        {
            Sheet Sheet2 = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();
            for (int i = 1; i < Sheet2.getLastRowNum(); i++)
            {
                Row row = Sheet2.getRow(i);
                String PaintName = dataFormatter.formatCellValue(row.getCell(0));
                String ProductStd = dataFormatter.formatCellValue(row.getCell(1));
                String ProductCode = dataFormatter.formatCellValue(row.getCell(2));
                String HSNId = dataFormatter.formatCellValue(row.getCell(4));                
                String Brand = dataFormatter.formatCellValue(row.getCell(5));
                String Category = dataFormatter.formatCellValue(row.getCell(6));
                String SubCategory = dataFormatter.formatCellValue(row.getCell(7));
                String SubChildCategory = dataFormatter.formatCellValue(row.getCell(8));
                String BasePaint1 = dataFormatter.formatCellValue(row.getCell(9));
                String ProportionOfPaint1 = dataFormatter.formatCellValue(row.getCell(10));                
                String Tinter1 = dataFormatter.formatCellValue(row.getCell(11));
                String ProportionOfTinter = dataFormatter.formatCellValue(row.getCell(12));
                String BasePaint2 = dataFormatter.formatCellValue(row.getCell(13));
                String ProportionOfPaint2 = dataFormatter.formatCellValue(row.getCell(14));                
                String PackSize = dataFormatter.formatCellValue(row.getCell(15));
                String UOM = dataFormatter.formatCellValue(row.getCell(16));
                String ProductQtyLtr = dataFormatter.formatCellValue(row.getCell(17));             
                String Color = dataFormatter.formatCellValue(row.getCell(18));
                String PaintType = dataFormatter.formatCellValue(row.getCell(19));
                String FinishType = dataFormatter.formatCellValue(row.getCell(20));
                String CostPrice = dataFormatter.formatCellValue(row.getCell(21));
                String SellingPrice = dataFormatter.formatCellValue(row.getCell(22));
                createnewporduct(PaintName, ProductStd, ProductCode, HSNId, Brand, Category, SubCategory, SubChildCategory, BasePaint1,	ProportionOfPaint1,	UOM, Tinter1, ProportionOfTinter, BasePaint2, ProportionOfPaint2, PackSize, ProductQtyLtr, Color, PaintType, FinishType, CostPrice, SellingPrice);
              }
        }
    }
    
    
	public static void main(String[] args) throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		CreateNewPaintaddbysheet obj=new CreateNewPaintaddbysheet();
		obj.chrome();
		obj.CreateMulProductFromExcel("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\CreateNewProduct.xlsx");	
		
	}

}
