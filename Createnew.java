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
	
	private static final String Category = null;
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
            String proportionOfTinter, String basePaint2, String proportionOfPaint2, 
            String color, String paintType, String finishType) throws InterruptedException 
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
    	
		// WebElement Category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"direct fixedHeight\"][3]")));
		// Category.sendKeys(category);    	
		// WebElement categorySelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + category + "']")));
		// categorySelect.click();
		   	    	
    	   	
    	// Select Category
        WebElement CategoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[3]")));
        CategoryOption.click();  
        
        WebElement Categoryselect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + Category + "']")));
        Categoryselect.click();
        Thread.sleep(2000);
                
    	try
    	{
    		//SubCategory
        	WebElement subCategoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[4]")));
        	subCategoryOption.click();        	
        	WebElement subCategorySelect = driver.findElement(By.xpath("//div[@class='drop-down-item']/span[normalize-space()= '" + subCategory + "']"));
        	subCategorySelect.sendKeys(subCategory);        	
    	}    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		Thread.sleep(2000);
    	}
   	 	
   	    //Base Paint 1    	
    	//Proportion of Paint 1
    	
    	WebElement BasePaint1 = driver.findElement(By.id("basePaint1"));
    	BasePaint1.sendKeys(basePaint1);   
    	Thread.sleep(3000);
    	
    	WebElement Prop1 = driver.findElement(By.id("proportionPaint1"));
    	Prop1.sendKeys(proportionOfPaint1);    	
   	   
//   	WebElement tinter = driver.findElement(By.xpath("//input[@id='tinters1']"));
//   	tinter.sendKeys(Tinter1);    	 
//   	Thread.sleep(2000);  
    	
//    	//Base Paint 1    	
//    	//Proportion of Paint 1
    	
//    	WebElement BasePaint1 = driver.findElement(By.id("basePaint1"));
//    	BasePaint1.sendKeys(basePaint1);   
//    	Thread.sleep(3000);
   	
//    	WebElement Prop1 = driver.findElement(By.id("proportionPaint1"));
//    	Prop1.sendKeys(proportionOfPaint1);
   	
//    	//Tinter 1
//    	WebElement Tinter1 = driver.findElement(By.id("tinters1"));
//    	Tinter1.sendKeys(tinter1);    	    	
    	    	   	 
//    	WebElement PropTinter=driver.findElement(By.id("proportionTinters"));
//    	PropTinter.sendKeys(proportionOfTinter);    	
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
            String Color = dataFormatter.formatCellValue(row.getCell(14));
            String PaintType = dataFormatter.formatCellValue(row.getCell(15));
            String FinishType = dataFormatter.formatCellValue(row.getCell(16));           
            
            addNewProduct(PaintName, ProductStd, ProductCode, HSNCode, Brand, Category, SubCategory, SubChildCategory, BasePaint1,  
            		 ProportionOfPaint1, Tinter1, ProportionOfTinter, BasePaint2, ProportionOfPaint2, Color, PaintType, FinishType);    	  
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
