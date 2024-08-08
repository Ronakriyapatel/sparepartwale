package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EmailManagement 
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
	
	public void emailmanage() throws InterruptedException
	{
		//Click on Setting 
		WebElement Settingclick=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
		Settingclick.click();
		Thread.sleep(4000);
				
		//Click on EmailManagement
		WebElement EmailManagementclick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[4]"));
		EmailManagementclick.click();		
		
		//Add new email		
		WebElement EmailManagementadd=driver.findElement(By.xpath("//button[@class='btn-primary header-btn']"));
		EmailManagementadd.click();
		Thread.sleep(2000);
		
		//Title		
		WebElement Title=driver.findElement(By.xpath("//input[@id='title']"));
		Title.sendKeys("titleTitle Testing1");
				
		//Subject		
		WebElement Subject=driver.findElement(By.xpath("//input[@id='subject']"));
		Subject.sendKeys("Testing Purpose2");
		
		//Description		
		WebElement Description=driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
		Description.sendKeys("fgdfg this is a content of the description of email management");
		
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();
		
		
	}
	public static void main(String[] args) throws InterruptedException
	
	{
		EmailManagement obj = new EmailManagement();
		obj.chrome();
		obj.emailmanage();

	}

}
