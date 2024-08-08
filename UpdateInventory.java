package Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.interactions.Actions;

public class UpdateInventory 
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
		
		public void inventoryclick() throws InterruptedException
		{	
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));        
			// Click on Setting
		    	try
		    	{
		        WebElement Inventoryclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[1]/span[2]")));
		        Inventoryclick.click();
		        Thread.sleep(3000);     		
		    	}
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
		    	
		    	try
		    	{
		    	WebElement InventoryInnerclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]/div[1]")));
		    	InventoryInnerclick.click();
		    	InventoryInnerclick.sendKeys("test2");
		    	}
		    	
		    	catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    	
		    	
			}	
		
		
		 public void clickAnyRecord() throws InterruptedException 
		 {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        try 		        
		        {
		            // Wait for the inventory table to be visible
		            WebElement inventoryTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='table-responsive']/table")));
                    WebElement record = inventoryTable.findElement(By.xpath("//tbody/tr[4]/td[4]"));
                    
                    
		            record.click();
		        } 
		        
		        catch (Exception e) 
		        {
		            e.printStackTrace();
		        }
		    }
		
		 //Not perfect
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub		
		UpdateInventory obj=new UpdateInventory();
		obj.chrome();
		obj.inventoryclick();
		obj.clickAnyRecord();
		//obj.UpdateInventoryrec();		
	}

}
