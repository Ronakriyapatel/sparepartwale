package Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagementAdd 
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
		
		public void useradd1(String firstname[], String lastname[], String emailid[], String phone[], String gender[], String dob[], String role[], String department[]) throws InterruptedException
		{		
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement SettingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
	        SettingClick.click();
	        Thread.sleep(2000);	        
	        //int rowCount=5;   
	        
	              	        	
	        WebElement UserManagementClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'User Management')]")));
	        UserManagementClick.click();
	        Thread.sleep(2000);
	        
	        // Navigate to Settings and Email Management
			int rowCount = 4;  
			
			for(int i=0;i<=rowCount;i++)	        
		    { 
			
			//Add User
			WebElement UserManagementAdd=driver.findElement(By.xpath("//button[@class='btn-primary header-btn']"));
			UserManagementAdd.click();	
			
			//First Name
			WebElement FirstName=driver.findElement(By.xpath("//input[@id='first_name']"));	
			FirstName.clear();
			FirstName.sendKeys(firstname[i]);	
			
			//Last Name
			WebElement LastName=driver.findElement(By.xpath("//input[@id='last_name']"));
			LastName.clear();
			LastName.sendKeys(lastname[i]);	
					
			//EmailId
			WebElement EmailId=driver.findElement(By.xpath("//input[@id='email']"));
			EmailId.clear();
			EmailId.sendKeys(emailid[i]);	
			
			//PhoneNumber
			WebElement PhoneNumber=driver.findElement(By.xpath("//input[@id='phone_no']"));
			EmailId.clear();
			PhoneNumber.sendKeys(phone[i]);
			
			//Gender
			WebElement Gender=driver.findElement(By.xpath("//div[@class=\"direct fixedHeight\"]"));
			Gender.click();				
			WebElement Genderselect=driver.findElement(By.xpath("//span[normalize-space()='" + gender[i] + "']"));
			Gender.click();
			Genderselect.click();
	
			//DOB
			WebElement DOB=driver.findElement(By.xpath("//input[@type=\"date\"]"));
			DOB.sendKeys(dob[i]);
			
			//Role
			WebElement Role=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[2]"));
			Role.click();			
			WebElement RoleSelect=driver.findElement(By.xpath("//span[normalize-space()='" + role[i] + "']"));
			RoleSelect.click();	
			Thread.sleep(2000);
			
			//Department Selection
            WebElement departmentDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='direct fixedHeight'])[3]")));
            departmentDropdown.click();
            WebElement departmentSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='drop-down-item']/span[normalize-space()='" + department[i] + "']")));
            departmentSelect.click();
            Thread.sleep(2000);  
							
			//Privileges
			WebElement Privileges=driver.findElement(By.xpath("//button[normalize-space()='Add Privileges']"));
			Privileges.click();
			
			//User management
			WebElement PrivilegesRead=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));		
			WebElement PrivilegesWrite=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]"));		
			WebElement PrivilegesDelete=driver.findElement(By.xpath("//tbody/tr[1]/td[4]/input[1]"));
					
			PrivilegesRead.click();
			PrivilegesWrite.click();
			PrivilegesDelete.click();
			
			//Submit privileges
			WebElement Submitpriv=driver.findElement(By.xpath("//div[@class='privileges-submit']//button[contains(text(),'Submit')]"));
			Submitpriv.click();	
				
			//Main User add Submit
			WebElement MainSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
			MainSubmit.click();		
			//Thread.sleep(2000);
		}
	        
		}

		public static void main(String[] args) throws InterruptedException
		{		
			UserManagementAdd obj = new UserManagementAdd();
			obj.chrome();	
			
			String[] firstname = {"Ajeayde", "Vijadeey", "Kedridsehna"};
			String[] lastname = {"Patedeel", "Jodesehi", "Raevdeal"};
		    String[] emailid = {"Ajedayod@poonamcoatings.com", "Veiodjeao@poonamcoatings.com", "Krieshnadeo@poonamcoatings.com"}; 
		    String[] phone = {"8191125682", "9510513282", "8059228782"}; 
		    String[] gender = {"Female", "Male", "Female"}; 
		    String[] dob = {"01-02-2001", "01-01-1993", "01-03-2002"}; 
		    String[] role = {"Admin", "Admin", "Admin"};
		    String[] department = {"Sales", "Administrator", "Sales"};		    
		    obj.useradd1(firstname, lastname, emailid, phone, gender, dob, role, department);	
		    
		 }

}
