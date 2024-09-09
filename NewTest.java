package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NewTest
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
		
        // Assertion to verify login was successful
        String expectedUrl = "https://dev.poonamcoatings.com/"; // Expected URL after login
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed: URL does not match expected.");
    }

    public void emailmanage() throws InterruptedException 
    {
        // Click on Settings 
        WebElement Settingclick = driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
        Settingclick.click();
        Thread.sleep(4000);
        
        // Click on Email Management
        WebElement EmailManagementclick = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[12]/div[4]"));
        EmailManagementclick.click();
               
        // Add new email       
        WebElement EmailManagementadd = driver.findElement(By.xpath("//button[@class='btn-primary header-btn']"));
        EmailManagementadd.click();
        Thread.sleep(2000);
        
        // Title        
        WebElement Title = driver.findElement(By.xpath("//input[@id='title']"));
        Title.sendKeys(Keys.CONTROL, "A", Keys.DELETE);
        Title.sendKeys("Title Testing221");
        
        // Subject        
        WebElement Subject = driver.findElement(By.xpath("//input[@id='subject']"));
        Subject.sendKeys(Keys.CONTROL, "A", Keys.DELETE);
        Subject.sendKeys("Testing Purpose222");
        
        // Description        
        WebElement Description = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
        Description.sendKeys(Keys.CONTROL, "A", Keys.DELETE);
        Description.sendKeys("fgdf22g this is a content of the description of email management");
        
        WebElement Submit = driver.findElement(By.xpath("//button[@type='submit']"));
        Submit.click();        
        Thread.sleep(3000);  // Wait for the message to appear
        
        // Assertion to verify email was added successfully
        String expectedSuccessMsg = "Email template added successfully.";           
        WebElement actualSuccessMsgElement = driver.findElement(By.xpath("//div[contains(text(),'Email template added successfully.')]"));
        String actualSuccessMsg = actualSuccessMsgElement.getText();
        
        Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg, "Email Management: Success message does not match.");
    }

    public static void main(String[] args) throws InterruptedException
    {
        NewTest obj = new NewTest();
        obj.chrome();
        obj.emailmanage();
    }
}
