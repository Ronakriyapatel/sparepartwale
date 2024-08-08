package Testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.*;
//import org.openqa.selenium.JavascriptExecutor;
//import java.time.Duration;
//import org.openqa.selenium.interactions.Actions;

public class StockManagement
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
    
    
    public void inventoryclick() throws InterruptedException
	{	
		
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));        
			// Click on Setting
	    	try
	    	{
	        WebElement Inventoryclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Inventory']")));
	        Inventoryclick.click();
	        Thread.sleep(1000);     		
	    	}
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    	
	    	//stock management
	    	try
	    	{
	        WebElement Stockmanagementclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]/div[2]")));	      
	        Stockmanagementclick.click();
	    	}
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }	    	
	    	
	    	//Stock transfer
	    	WebElement ViewStockmanagement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-primary self-center']")));
	    	ViewStockmanagement.click();   	
	    	
	    	 driver.findElement(By.cssSelector("td:nth-child(1) .direct")).click();
	    	 Thread.sleep(8000);
	    	 
	    	 driver.findElement(By.cssSelector(".drop-down-item:nth-child(1) > span")).click();
	    	 Thread.sleep(8000);	
	    	 
	    	 
	    }

    public void inventorySearch() throws InterruptedException 
    {
          	  WebElement Searchclick=driver.findElement(By.cssSelector(".search-box > .material-symbols-outlined"));
    		  Searchclick.click();    		  
    		  WebElement Searchdata=driver.findElement(By.cssSelector(".table-search-input"));
    		  Searchdata.sendKeys("Lava Shine");
    		  Searchdata.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));	
    		  Thread.sleep(3000);    		 
    }
    
    public void pagination() throws InterruptedException
    {

        try       
        {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pagination-container")));
            List<WebElement> paginationButtons = driver.findElements(By.cssSelector(".pagination-container .pagBTN"));
            for (WebElement button : paginationButtons) 
            {
                button.click();
                Thread.sleep(6000); // You might need to adjust this sleep time
                //Add your logic to handle the content on the new page here           
            }

        }  

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

	        
    public static void main(String[] args) throws InterruptedException
    {
        StockManagement obj = new StockManagement();
        obj.chrome();
        obj.inventoryclick();
       // obj.inventorySearch();
        //obj.pagination();
        
    }
}
