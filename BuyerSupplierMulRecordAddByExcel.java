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


public class BuyerSupplierMulRecordAddByExcel 
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
	 
	 public void AddBuyersandSuplliers(String Fullname, String Phone, String Email, String Nameofcompany, String CompanyrefId, String Officialemailadd, String Companycontactno, String	Gst, String	Companytype, String Creditlimit, String Paidduration, String Addresslocation1, String Addresslocation2, String Pincode, String Salesperson)
			 throws InterruptedException 			 
	 {
		 			
		 	WebElement addBuyersandSuppliers = driver.findElement(By.xpath("//span[normalize-space()='Buyers & Suppliers']"));
	        addBuyersandSuppliers.click();
	        Thread.sleep(8000);

	        // Add new company popup
	        WebElement singleCompanyAdd = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > span:nth-child(1)"));
	        singleCompanyAdd.click(); 
	        
	        // Add new company click
	        WebElement singleCompanyAddclick = driver.findElement(By.xpath("//span[normalize-space()='Add Single Company']"));
	        singleCompanyAddclick.click();     
	     	        
	        // ***********Personal Info***********
	        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
	        name.sendKeys(Fullname);
	        Thread.sleep(1000);

	        WebElement phone = driver.findElement(By.xpath("//input[@id='mobile_no']"));
	        phone.sendKeys(Phone);
	        Thread.sleep(1000);

	        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
	        email.sendKeys(Email);
	        Thread.sleep(1000);

	        // ********Company Details***********
	        WebElement nameOfCompany = driver.findElement(By.xpath("//input[@id='company_name']"));
	        nameOfCompany.sendKeys(Nameofcompany);
	        Thread.sleep(1000);

	        WebElement comRefId = driver.findElement(By.xpath("//input[@id='company_ref_id']"));
	        comRefId.sendKeys(CompanyrefId);
	        Thread.sleep(1000);

	        WebElement officialEmail = driver.findElement(By.xpath("//input[@id='company_email']"));
	        officialEmail.sendKeys(Officialemailadd);
	        Thread.sleep(1000);

	        WebElement companyContact = driver.findElement(By.xpath("//input[@id='company_num']"));
	        companyContact.sendKeys(Companycontactno);
	        Thread.sleep(1000);

	        WebElement gst = driver.findElement(By.xpath("//input[@id='gst_number']"));
	        gst.sendKeys(Gst);

	        WebElement companyTypeDd = driver.findElement(By.xpath("//div[@class='drop-down-main drop-down-main-large']//div[contains(@class,'direct')]"));
	        companyTypeDd.click();
	        WebElement companyTypeSelect = driver.findElement(By.xpath("//span[normalize-space()='Supplier']"));
	        companyTypeSelect.click();
	        Thread.sleep(1000);
	        
	        
	        WebElement creditLimit = driver.findElement(By.xpath("//input[@id='creditLimit']"));
	        creditLimit.sendKeys(Creditlimit);
	        
	        WebElement paydurationinday = driver.findElement(By.xpath("//input[@id='payDate']"));
	        paydurationinday.sendKeys(Paidduration);

	        WebElement address1 = driver.findElement(By.xpath("//input[@id='address-line-one']"));
	        address1.sendKeys(Addresslocation1);
	        Thread.sleep(1000);

	        WebElement address2 = driver.findElement(By.xpath("//input[@id='address_line_two']"));
	        address2.sendKeys(Addresslocation2);
	        Thread.sleep(1000);

	        WebElement pincode = driver.findElement(By.xpath("//input[@id='pinCode']"));
	        pincode.sendKeys(Pincode);
	        Thread.sleep(1000);
	        
//	        WebElement salespersonname = driver.findElement(By.xpath("//input[@id='handlerName']"));
//	        salespersonname.sendKeys(Salesperson);
//	        Thread.sleep(1000);

	        WebElement mark = driver.findElement(By.xpath("//div[@class='input-field checkbox-permission-input-field']//span[@class='filter-check-background']"));
	        mark.click();
	        Thread.sleep(1000);
	        
	        WebElement saveButton = driver.findElement(By.xpath("//button[@type='submit']"));
	        saveButton.click();
	        Thread.sleep(1000);
	        
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        try 
	        {
	            WebElement alreadyExistMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Already exist')]")));
	            if (alreadyExistMessage.isDisplayed()) 
	            {
	                System.out.println("Company added successfully.");
	            }
	        } 
	        catch (Exception e)
	        
	        {
	            System.out.println("Company already exists");
	            
	        }
	    	        
	    }

	 public void addMulbuyerandsupplierProductFromExcel(String excelFilePath) throws IOException, InterruptedException 
	    {
	        FileInputStream inputStream = new FileInputStream("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\BuyersAndSupplier.xlsx");

	        try (Workbook workbook = new XSSFWorkbook(inputStream))
	        {
	            Sheet sheet1 = workbook.getSheetAt(0);
	            DataFormatter dataFormatter = new DataFormatter();	            	                        
	            for (int i = 1; i < sheet1.getLastRowNum(); i++)
	            {
	                Row row = sheet1.getRow(i);
	                String Fullname = dataFormatter.formatCellValue(row.getCell(0));
	                String Phone = dataFormatter.formatCellValue(row.getCell(1));	              
	                String Email = dataFormatter.formatCellValue(row.getCell(2));
	                String Nameofcompany = dataFormatter.formatCellValue(row.getCell(3));
	                String CompanyrefId = dataFormatter.formatCellValue(row.getCell(4));
	                String Officialemailadd = dataFormatter.formatCellValue(row.getCell(5));
	                String Companycontactno = dataFormatter.formatCellValue(row.getCell(6));
	                String Gst = dataFormatter.formatCellValue(row.getCell(7));
	                String Companytype = dataFormatter.formatCellValue(row.getCell(8));
	                String Creditlimit = dataFormatter.formatCellValue(row.getCell(9));
	                String Paidduration = dataFormatter.formatCellValue(row.getCell(10));
	                String Addresslocation1 = dataFormatter.formatCellValue(row.getCell(11));
	                String Addresslocation2 = dataFormatter.formatCellValue(row.getCell(12));
	                String Pincode = dataFormatter.formatCellValue(row.getCell(13));
	                String Salesperson = dataFormatter.formatCellValue(row.getCell(14));               
	                
	                try
	                {
	                	AddBuyersandSuplliers(Fullname, Phone, Email, Nameofcompany, CompanyrefId, Officialemailadd, Companycontactno, Gst, Companytype, Creditlimit, Paidduration, Addresslocation1, Addresslocation2, Pincode, Salesperson);
	                    Thread.sleep(1000); // Ensure enough time between adding products
	                }
	                
	                catch (Exception e)
	                {
	                	
	                	e.printStackTrace();
	                }        	
	                	
	                	
//	                   if (e.getMessage().contains("duplicate record")) 
//	                    {
//	                        System.out.println("Duplicate product found: " + ProductName + ". Skipping this product.");
//	                    } 
//	                                       
//	                    else 
//	                    {
//	                        System.out.println("Failed to add product: " + ProductName + ". Error: " + e.getMessage());
//	                    }
	                }
	            }
	        driver.manage().deleteAllCookies();
			driver.navigate().refresh(); 
	        }
	    
		
	public static void main(String[] args) throws InterruptedException, IOException 	
	{
		// TODO Auto-generated method stub		
		BuyerSupplierMulRecordAddByExcel obj = new BuyerSupplierMulRecordAddByExcel();
        obj.chrome();        
        obj.addMulbuyerandsupplierProductFromExcel("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\BuyersAndSupplier.xlsx");
        
	}

}

//Perfectly run
