package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProfileManagement 
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
		Password.sendKeys("Super@123");
		
		WebElement Login=driver.findElement(By.xpath("//button[@type='submit']"));
		Login.click();	
		Thread.sleep(8000);	
		
		//Perfect Run
	}	
	
	public void ProfileManage() throws InterruptedException
	{
		//Click on Setting 
		WebElement Settingclick=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
		Settingclick.click();
		
		//Click on Profile
		WebElement Profileclick=driver.findElement(By.xpath("//div[normalize-space()='Profile']"));
		Profileclick.click();
		
		//Editbuttonclick		
		WebElement EditButtonClick=driver.findElement(By.xpath("//div[@class='home-container']//div[1]//div[1]//div[1]//button[1]"));
		EditButtonClick.click();	
			
		
		// ***********Personal Info***********
        WebElement FirstName = driver.findElement(By.xpath("//input[@id='fname']"));        
        FirstName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        FirstName.sendKeys("Super");
        Thread.sleep(1000);       
        
        
        WebElement LastName = driver.findElement(By.xpath("//input[@id='lname']"));
        LastName.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.DELETE));
        
        LastName.sendKeys("Admin");
        Thread.sleep(1000);

        WebElement PhoneNumber = driver.findElement(By.xpath("//input[@id='phone']"));
        PhoneNumber.sendKeys(Keys.CONTROL,"A", Keys.DELETE);
        PhoneNumber.sendKeys("9714243284");
        Thread.sleep(1000);

        // WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        // email.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.DELETE));//        
        // email.sendKeys("admin@poonamcoatings.com");
        // Thread.sleep(1000);
        
        WebElement Gender = driver.findElement(By.xpath("//div[@class='direct fixedHeight']"));
        Gender.click();           
        WebElement SelectGender=driver.findElement(By.xpath(" //span[normalize-space()='Female']"));
        SelectGender.click();        
      
        Thread.sleep(1000);        
        
        WebElement DOB = driver.findElement(By.xpath("//input[@id='dob']"));
        DOB.sendKeys(Keys.CONTROL,"A",Keys.DELETE);
        DOB.sendKeys("02-05-1991");
    
        //Savebuttonclick        
        WebElement SaveButtonClick = driver.findElement(By.xpath("//button[@type='submit']"));
        SaveButtonClick.click();   
        
        //Change Password        
        //Edit button
        WebElement EditbuttonClick = driver.findElement(By.xpath("//div[@class='main-content']//div[2]//div[1]//div[1]//button[1]//span[1]"));
        EditbuttonClick.click();   
        
        WebElement CurrentPassword = driver.findElement(By.xpath("//input[@id='current_password']"));
        CurrentPassword.sendKeys("Super@123");   
        
        WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
        Password.sendKeys("Super@1234");  
        
        WebElement Retype = driver.findElement(By.xpath("//input[@id='retype_password']"));
        Retype.sendKeys("Super@1234");
        
        WebElement Saveclick = driver.findElement(By.xpath("//button[@type='submit']"));
        Saveclick.click();        
        //perfect run
	}
	
	
	public static void main(String[] args) throws InterruptedException
	{
		ProfileManagement obj = new ProfileManagement();
		obj.chrome();
		obj.ProfileManage();
	}

}
