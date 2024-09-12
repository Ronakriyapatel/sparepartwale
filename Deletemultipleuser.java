package Testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class Deletemultipleuser 
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

        
    public void deletemuluser() throws InterruptedException 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        // Navigate to Settings and Email Management
//        WebElement SettingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
//        SettingClick.click();
//        Thread.sleep(2000);
//
//        WebElement UserManagementClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'User Management')]")));
//        UserManagementClick.click();
//        Thread.sleep(2000);
        
        
        //Click on Setting 
      	WebElement Settingclick=driver.findElement(By.xpath("//span[@class=\"scc-name\" and text()=\"Settings\"]"));		
      	Settingclick.click();
      		
      	//Click on UserManagement
      	WebElement UserManagementclick=driver.findElement(By.xpath("//div[normalize-space()='User Management']"));
      	UserManagementclick.click();
      	Thread.sleep(2000);

        // Find total number of rows in the table
        int rowCount = 3;       
       
        for (int i = 1; i <= rowCount; i++) 
        {
            try 
            {
                // Find the delete button for each row
                WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[" + i + "]/td[7]/div[1]/button[3]/span[1]")));
                deleteButton.click();
                Thread.sleep(2000);

                // Confirm delete
                WebElement confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='del-conform']")));
                confirmDeleteButton.click();
                Thread.sleep(3000);			 	//Adjust this wait time as necessary

                // Print confirmation message if needed
                System.out.println("Deleted record " + i);
            } 
         
            catch (Exception e) 
            {
                // Log if any exception occurs during deletion
                System.out.println("Error deleting record " + i + ": " + e.getMessage());
            }      
        }

        //Output message when all records are deleted
        System.out.println("All records deleted.");      
    }
    
    public static void main(String[] args) throws InterruptedException
    {
        Deletemultipleuser obj = new Deletemultipleuser();
        obj.chrome(); // Initialize the Chrome driver and log in
        obj.deletemuluser();
        obj.driver.quit(); // Quit the WebDriver session after completing tasks
    }
}
