package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProduct 
{

WebDriver driver;
WebDriverWait wait;		
	
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
		
	
	public void AddProductclick() throws InterruptedException
	{
		WebElement Addproductclick=driver.findElement(By.xpath("//span[normalize-space()='Products']"));
		Addproductclick.click();	
		
		WebElement Addproductclickbutton=driver.findElement(By.xpath("//button[normalize-space()='Add Product']"));
		Addproductclickbutton.click();
		
		//Product Details
		WebElement ProductName=driver.findElement(By.xpath("//input[@id='productName']"));
		ProductName.sendKeys("Test Inventory2");
		
		WebElement Description=driver.findElement(By.xpath("//textarea[@id='description']"));
		Description.sendKeys("This is the test Inventory2");
		
		WebElement ProductCode=driver.findElement(By.xpath("//input[@id='productCode']"));
		ProductCode.sendKeys("79797927");	
		
		WebElement BatchNumber=driver.findElement(By.xpath("//input[@id='batchNumber']"));
		BatchNumber.sendKeys("GHT627");	
		
		try
		{
		WebElement Brand=driver.findElement(By.xpath("//div[contains(@class,'direct fixedHeight')]"));
		Brand.click();
		Thread.sleep(2000);
		
		WebElement Brand1=driver.findElement(By.xpath("//span[normalize-space()='Sherwin Williams']"));
		Brand1.click();	
		Thread.sleep(3000);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		WebElement Category=driver.findElement(By.xpath("//div[contains(@class,'drop-down-selector hide-drop-scroll')]//div[contains(@class,'direct fixedHeight')]"));
		Category.click();
		WebElement Category1=driver.findElement(By.xpath("//span[normalize-space()='Top Coat']"));
		Category1.click();		
		
		WebElement SubCategory=driver.findElement(By.xpath("//body/div[@id='root']/div[contains(@class,'container popUp-container')]/div[contains(@class,'app-container')]/div[contains(@class,'home-container')]/div[contains(@class,'mainExelPop show_component-common-animation')]/div[contains(@class,'modelExel')]/div[contains(@class,'modelEx_content singleAdd')]/form[contains(@class,'scrollForm')]/div[contains(@class,'form-content')]/div[contains(@class,'form-group form')]/div[5]/div[1]/div[1]/div[2]/div[1]"));
		SubCategory.click();		
		WebElement SubCategory1=driver.findElement(By.xpath("//span[normalize-space()='Acraylic Top Coat']"));
		SubCategory1.click();
		Thread.sleep(2000);
		
				
		try
		{
		WebElement Color = driver.findElement(By.xpath("//input[@id='color']"));
        Color.sendKeys("Red Violet");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
		Thread.sleep(6000);	
        WebElement Color1 = driver.findElement(By.xpath("//div[@class=\"drop-down-item2\"]//span[text()=\"Red violet\"]"));
        Color1.click();
        //Thread.sleep(5000);
        Thread.onSpinWait();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
              			
		WebElement Packsize=driver.findElement(By.xpath("//input[@id='packSize']"));
		Packsize.sendKeys("5");	
		Thread.sleep(2000);

		WebElement UOM=driver.findElement(By.xpath("//div[@class='direct ']"));		
		UOM.click();		
		WebElement UOM1=driver.findElement(By.xpath("//div[@class='col-2']//div[8]"));
		UOM1.click();
		
		try
		{
		WebElement PaintType = driver.findElement(By.xpath("//input[@id='paintType']"));
		PaintType.sendKeys("Oil Based");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
		Thread.sleep(6000);	
        WebElement PaintType1 = driver.findElement(By.xpath("//span[normalize-space()='Oil Based']"));
        PaintType1.click();
        //Thread.sleep(5000);
        Thread.onSpinWait();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
				
		try
		{
		WebElement FinishType = driver.findElement(By.xpath("//input[@id='finish']"));		
		FinishType.sendKeys("Matt");  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		try
		{
		Thread.sleep(6000);	
        WebElement FinishType1 = driver.findElement(By.xpath("//span[normalize-space()='Matt']"));
        FinishType1.click();
        Thread.onSpinWait();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
//		WebElement FinishType=driver.findElement(By.xpath("//input[@id='finish']"));
//		FinishType.sendKeys("Mat Finish");		

		WebElement HSNCode=driver.findElement(By.xpath("//input[@id='hsnCode']"));
		HSNCode.sendKeys("32099090");
		
		try
		{
		Thread.sleep(6000);	
        WebElement HSNCode1 = driver.findElement(By.xpath("//span[normalize-space()='32099090']"));
        HSNCode1.click();
        
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		WebElement UnitPrice=driver.findElement(By.xpath("//input[@id='unitPrice']"));
		UnitPrice.sendKeys("20");		
		//WebElement CostPrice=driver.findElement(By.xpath("//input[@id='costPrice']"));
		//CostPrice.sendKeys("300");	
		WebElement SellingPrice=driver.findElement(By.xpath("//input[@id='sellingPrice']"));
		SellingPrice.sendKeys("300");					
		WebElement Savebutton=driver.findElement(By.xpath("//button[@type='submit']"));
		Savebutton.click();	
	}
	
		
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		AddProduct obj=new AddProduct();
		obj.chrome();
		obj.AddProductclick();
	}

}
