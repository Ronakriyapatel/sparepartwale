package Testing;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;


public class BulkEmailAdd
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
	}
	
	public void addemail() throws InterruptedException
	{
		//settings
		WebElement Setting=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
		Setting.click();
		
		//Click on EmailManagement
		WebElement EmailManagementclick=driver.findElement(By.xpath("//div[normalize-space()='Email Management']"));
		EmailManagementclick.click();
		
		//Add new email		
		WebElement EmailManagementadd=driver.findElement(By.xpath("//button[@class='btn-primary header-btn']"));
		EmailManagementadd.click();
		//Thread.sleep(2000);
					
		//Title		
		WebElement Title=driver.findElement(By.xpath("//input[@id='title']"));
		Title.sendKeys("RRR1");
						
		//Subject		
		WebElement Subject=driver.findElement(By.xpath("//input[@id='subject']"));
		Subject.sendKeys("Sub R2");
				
		//Description		
		WebElement Description=driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));		
		Description.sendKeys("fgdfg this is a content of the description of email management");
		
		//Submit
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();		
	}
	
public static void main(String[] args) throws InterruptedException, IOException
	{
		BulkEmailAdd obj = new BulkEmailAdd();
		obj.chrome();
		obj.addemail();				
	}

}



//100417845941
