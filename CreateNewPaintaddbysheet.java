package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    
    
	public static void main(String[] args) throws InterruptedException
	
	{
		// TODO Auto-generated method stub
		CreateNewPaintaddbysheet obj=new CreateNewPaintaddbysheet();
		obj.chrome();
		
	}

}
