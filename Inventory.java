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

public class Inventory 

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
	    	Thread.sleep(2000);
	    	}
	    	
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}	   	
	  			
	}	
	
	public void updateinventory() throws InterruptedException
	{
		
		try
    	{
    	WebElement InventoryInnerclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[6]/div[1]")));
    	InventoryInnerclick.click();
    	Thread.sleep(2000);
    	}
    	
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		
		//View Inventory
		WebElement InventoryView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='110']")));
    	InventoryView.click();  	
    	Thread.sleep(2000);    	
	
		WebElement Viewbutton = driver.findElement(By.xpath("//span[@class='material-symbols-outlined medium']"));
		Viewbutton.click();
		WebElement MinQuantity=driver.findElement(By.xpath("//input[@id='minimumQuantity']"));
		MinQuantity.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));		
		MinQuantity.sendKeys("10");
		
		WebElement AddProduct=driver.findElement(By.xpath("//input[@id='add']"));
		AddProduct.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		AddProduct.sendKeys("20");	
				
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();		
		
		//remove quantity		
		WebElement RemQuantity=driver.findElement(By.xpath("//input[@id='minimumQuantity']"));
		RemQuantity.sendKeys("05");
		
		WebElement RemProduct=driver.findElement(By.xpath("//input[@id='add']"));
		RemProduct.sendKeys("10");
	
	}

    public void inventorySearch() throws InterruptedException 
    {
          		
    		  WebElement Searchclick=driver.findElement(By.cssSelector(".search-box > .material-symbols-outlined"));
    		  Searchclick.click();    		  
    		  WebElement Searchdata=driver.findElement(By.cssSelector(".table-search-input"));
    		  Searchdata.sendKeys("Lava Shine"); 
    		  Thread.sleep(8000);    		  
    		  Searchdata.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			  Thread.sleep(1000);			      
			  //driver.navigate().refresh();     		  
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
                // Add your logic to handle the content on the new page here
            }

        }  

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) throws InterruptedException	
	{
		//TODO Auto-generated method stub
		Inventory obj=new Inventory();
		obj.chrome();		
		obj.inventoryclick();		
		//obj.inventorySearch();	
		Thread.sleep(1000);
		//obj.pagination();		
		obj.updateinventory();	
	}

}
