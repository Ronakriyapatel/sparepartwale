package Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Createnew 
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
    
    public void addNewProduct(String paintName, String productStd, String productCode, String hsnCode, 
            String brand, String category, String subCategory, String subChildCategory, 
            String basePaint1, String proportionOfPaint1, String tinter1, 
            String proportionOfTinter , String basePaint2, String proportionOfPaint2, String PackSize,
            String Prodqty, String color, String paintType, String finishType) throws InterruptedException 
       {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	// Navigate to Product Page
    	WebElement addProductClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Products']")));
    	addProductClick.click();

    	WebElement createNewProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-primary header-btn header-btn-second']")));
    	createNewProduct.click();

    	// Paint Name
    	WebElement paintNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("paintName")));
    	paintNameField.sendKeys(paintName);

    	// Product Standard
    	WebElement productStandard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-selector hide-drop-scroll']")));
    	productStandard.click();
    	WebElement productStandardSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + productStd + "']")));
    	productStandardSelect.click();

    	// Product Code
    	driver.findElement(By.id("productCode")).sendKeys(productCode);

    	// HSN Code
    	driver.findElement(By.id("hsnId")).sendKeys(hsnCode);
    	try
    	{
		Thread.sleep(2000);
		WebElement hsnCodeOption = driver.findElement(By.xpath("//span[normalize-space()='" + hsnCode + "']"));
		hsnCodeOption.click();
    	}
	
    	catch (Exception e) 
    	{
		System.out.println("HSN Code selection issue: " + e.getMessage());
    	}

    	//Brand
    	WebElement brandOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[2]")));
    	brandOption.click();
    	WebElement brandOptionClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + brand + "']")));
    	brandOptionClick.click();    	

    	//Category
    	WebElement CategoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[3]")));
    	CategoryOption.click();
    	WebElement Categoryselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + category + "']")));
    	Categoryselect.click();
         
        //SubCategory Selection       
        WebElement subCategoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[4]")));
        subCategoryOption.click();
        WebElement subCategorySelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + subCategory + "']")));
        subCategorySelect.click();
       	
        //Base Paint Component 1    	
        WebElement basepaint1 = driver.findElement(By.xpath("//input[@id='basePaint1']"));
        basepaint1.sendKeys(basePaint1);  
         	    	 
        WebElement Propaint1 = driver.findElement(By.xpath("//input[@id='proportionPaint1']"));
        Propaint1.sendKeys(proportionOfPaint1);  
              
        WebElement tinter = driver.findElement(By.xpath("//input[@id='tinters1']"));
        tinter.sendKeys(tinter1);          
        
        WebElement proptinter1 = driver.findElement(By.xpath("//input[@id='proportionTinters']"));
        proptinter1.sendKeys(proportionOfTinter);    
        
        //Base Paint Component 2  	           
        WebElement basepaint2 = driver.findElement(By.xpath("//input[@id='basePaint2']"));
        basepaint2.sendKeys(basePaint2);    	 
                 
        WebElement basepaint2select = driver.findElement(By.xpath("//input[@id='proportionPaint2']"));
        basepaint2select.sendKeys(proportionOfPaint2);
        
        //PackSize
        WebElement packsize = driver.findElement(By.xpath("//input[@id='packSize']"));
        packsize.sendKeys(PackSize);
        Thread.sleep(2000);     
        
        //Handle Color
        try 
        {
            WebElement color1 = driver.findElement(By.xpath("//input[@id='color']"));
            color1.sendKeys(color);
            Thread.sleep(2000);              
            // WebElement color1select = driver.findElement(By.xpath("//div[@class='drop-down-item2 selectedDropBox'] //span[normalize-space()='" + color + "']"));
            // color1select.click();                
        } 
        
        catch (Exception e) 
        {
           // System.out.println("Color selection issue for product: " + ProductName);
            e.printStackTrace();
        }

        
        // Handle PaintType
        try 
        {
            WebElement paintType1 = driver.findElement(By.xpath("//input[@id='paintType']"));
            paintType1.sendKeys(paintType);            
            Thread.sleep(2000); 
            
        } 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        // Handle FinishType
        try            
        {
            WebElement finishType1 = driver.findElement(By.xpath("//input[@id='finish']"));
            finishType1.sendKeys(finishType);           
            
        }
        catch (Exception e) 
        {
            
           e.printStackTrace();
        }         
             
  	}
        
    public void CreateMulProductFromExcel(String excelFilePath) throws IOException, InterruptedException 
    {
   
    FileInputStream inputStream = new FileInputStream("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\CreateNewProduct.xlsx");

    try (Workbook workbook = new XSSFWorkbook(inputStream)) 
    {
        	
        Sheet sheet2 = workbook.getSheetAt(0);
        DataFormatter dataFormatter = new DataFormatter();
        
        for (int i = 1; i <= sheet2.getLastRowNum(); i++)
        {
            Row row = sheet2.getRow(i);
            String PaintName = dataFormatter.formatCellValue(row.getCell(0));
            String ProductStd = dataFormatter.formatCellValue(row.getCell(1));
            String ProductCode = dataFormatter.formatCellValue(row.getCell(2));
            String HSNCode = dataFormatter.formatCellValue(row.getCell(3));                
            String Brand = dataFormatter.formatCellValue(row.getCell(4));
            String Category = dataFormatter.formatCellValue(row.getCell(5));
            String SubCategory = dataFormatter.formatCellValue(row.getCell(6));
            String SubChildCategory = dataFormatter.formatCellValue(row.getCell(7));
            String BasePaint1 = dataFormatter.formatCellValue(row.getCell(8));
            String ProportionOfPaint1 = dataFormatter.formatCellValue(row.getCell(9));                
            String Tinter1 = dataFormatter.formatCellValue(row.getCell(10));
            String ProportionOfTinter = dataFormatter.formatCellValue(row.getCell(11));
            String BasePaint2 = dataFormatter.formatCellValue(row.getCell(12));
            String ProportionOfPaint2 = dataFormatter.formatCellValue(row.getCell(13));  
            String Packsize = dataFormatter.formatCellValue(row.getCell(14));  
            String Prodqty = dataFormatter.formatCellValue(row.getCell(15));  
            String Color = dataFormatter.formatCellValue(row.getCell(16));
            String PaintType = dataFormatter.formatCellValue(row.getCell(17));
            String FinishType = dataFormatter.formatCellValue(row.getCell(18));           
            
            addNewProduct(PaintName, ProductStd, ProductCode, HSNCode, Brand, Category, SubCategory, SubChildCategory, 
            		BasePaint1, ProportionOfPaint1, Tinter1, ProportionOfTinter, BasePaint2, ProportionOfPaint2, Packsize, Prodqty, Color, PaintType, FinishType);    	  
        }
    	
    }        
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    
	}
    
    public static void main(String[] args) throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
		Createnew obj=new Createnew();
		obj.chrome();
		obj.CreateMulProductFromExcel("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\CreateNewProduct.xlsx");
	
	}
	
  }
