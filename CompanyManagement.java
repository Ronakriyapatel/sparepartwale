package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompanyManagement 
{
	WebDriver driver;
	
	public void chrome() throws InterruptedException
	{
		
		System.setProperty("Webdriver.chromedriver","C:\\Users\\Aaditya\\Selenium3\\chromedriver.exe");		
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
		
		//Click on Setting 
		WebElement Settingclick=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
		Settingclick.click();
			
		//Click on Company
		WebElement Companyclick=driver.findElement(By.xpath("//div[normalize-space()='Company']"));
		Companyclick.click();			
		//Perfect Run
	}	
	
	
	public void companymanage() throws InterruptedException
	{
		
		//Edit Company
		WebElement EditCompanyclick=driver.findElement(By.xpath("//span[@class='material-symbols-outlined small']"));
		EditCompanyclick.click();	
		
		//Company form		
		//NameOfCompany
		WebElement NameOfCompany=driver.findElement(By.xpath("//input[@id='company_name']"));
		NameOfCompany.sendKeys(Keys.CONTROL,"A", Keys.DELETE);		
		//NameOfCompany.sendKeys("Poonam Coatings Pvt Ltd");	
		NameOfCompany.sendKeys("ABC");			
		
		//Industry
		WebElement Industry=driver.findElement(By.xpath("//input[@id='industry']"));
		Industry.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//NameOfCompany.sendKeys("Paint");
		Industry.sendKeys("PaintA");	
		
		//FoundingYear
		WebElement FoundingYear=driver.findElement(By.xpath("//input[@id='founding_year']"));
		FoundingYear.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//FoundingYear.sendKeys("2003");
		FoundingYear.sendKeys("2004");
		
		//GSTNumber
		WebElement GSTNumber=driver.findElement(By.xpath("//input[@id='gst_number']"));
		GSTNumber.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//GSTNumber.sendKeys("24AALFG1578L1Z1");
		GSTNumber.sendKeys("24AALFG1578L1Z1");
		
		//Addressline1
		WebElement AddrsLine1=driver.findElement(By.xpath("//input[@id='address-line-one']"));
		AddrsLine1.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//AddrsLine1.sendKeys("Vishwapuri");
		AddrsLine1.sendKeys("Shreedhar");
		
		//Addressline2
		WebElement AddrsLine2=driver.findElement(By.xpath("//input[@id='address_line_two']"));
		AddrsLine2.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//AddrsLine2.sendKeys("Netram");
		AddrsLine2.sendKeys("Sola");		
		
		//Pincode
		WebElement Pincode=driver.findElement(By.xpath("//input[@id='pinCode']"));
		Pincode.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//Pincode.sendKeys("382481");	
		Pincode.sendKeys("380002");	
		
		//Official Email
		WebElement OfficialEmailAdd=driver.findElement(By.xpath("//input[@id='email']"));
		OfficialEmailAdd.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//OfficialEmailAdd.sendKeys("admin@poonamcoatings.com");
		OfficialEmailAdd.sendKeys("srogfgfhg@poonamcoatings.com");	
		
		//Contact Number
		WebElement ContactNumber=driver.findElement(By.xpath("//input[@id='contact_num']"));
		ContactNumber.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//ContactNumber.sendKeys("8181858586");
		ContactNumber.sendKeys("8181858546");
		
		//About Us
		WebElement AboutUs=driver.findElement(By.xpath("//textarea[@id='about_us']"));
		AboutUs.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
		//AboutUs.sendKeys("Welcome to the paint Industry of poonam Coatings, We sell Jotun and sherwinwilliam paint");
		AboutUs.sendKeys("This is a IT company which provide the services of marketing");
		
		//Submit
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();		
		//Perfect Run
		
	}
	
	public void warehouseAdd() throws InterruptedException
	{		
		try
		{				
		WebElement Add=driver.findElement(By.xpath("//span[@class=\"material-symbols-outlined small\" and text()=\"add\"]"));
		Add.click();		
		
		WebElement AddressLine1=driver.findElement(By.xpath("//div[@class='form-group form']//input[@id='address-line-one']"));
		AddressLine1.sendKeys("Sola Bhagvat");

		WebElement AddressLine2=driver.findElement(By.xpath("//div[@class='form-group form']//input[@id='address_line_two']"));
		AddressLine2.sendKeys("Near Patrol Pump");		

		WebElement Pincode=driver.findElement(By.xpath("//div[@class='form-group form']//input[@id='pinCode']"));
		Pincode.sendKeys("382481");		
				
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();		
		}		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public void warehouseEdit() throws InterruptedException
	{			
		
		try
		{		
		WebElement Editaddress = driver.findElement(By.cssSelector(".btn-primary"));
		Editaddress.click();		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//WebElement Editaddress = driver.findElement(By.id("address-line-one"));
		//Editaddress.click();
		//Editaddress.sendKeys("55 suraj nagarda");			
	}
		
		
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		CompanyManagement obj=new CompanyManagement();
		obj.chrome();
		//obj.companymanage();
		//obj.warehouseAdd();
		obj.warehouseEdit();
		
	}

}
