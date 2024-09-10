package Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserManagement 
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
	
	
	
	public void useradd() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Settings and Email Management
        WebElement SettingClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
        SettingClick.click();
        Thread.sleep(2000);     	
        
        WebElement UserManagementClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='User Management']")));
        UserManagementClick.click();
        Thread.sleep(2000);	       
						
		//Add User
		WebElement UserManagementAdd=driver.findElement(By.xpath("//button[@class='btn-primary header-btn']"));
		UserManagementAdd.click();	
		
		//First Name
		WebElement FirstName=driver.findElement(By.xpath("//input[@id='first_name']"));		
		FirstName.sendKeys("BTrisha12");	
		
		//Last Name
		WebElement LastName=driver.findElement(By.xpath("//input[@id='last_name']"));
		LastName.sendKeys("BPatel12");	
				
		//EmailId
		WebElement EmailId=driver.findElement(By.xpath("//input[@id='email']"));
		EmailId.sendKeys("trisha12@poonamcoatings.com");	
		
		//PhoneNumber
		WebElement PhoneNumber=driver.findElement(By.xpath("//input[@id='phone_no']"));
		PhoneNumber.sendKeys("9785653456");
		
		//Gender
		//WebElement Gender=driver.findElement(By.xpath("//body/div[@id='root']/div[@class='container']/div[@class='app-container']/div[@class='home-container']/div[@class='main-container']/div[@class='main-content']/div[@class='profile_form_box']/form[@class='form-content']/div[@class='form-group form']/div[4]/div[1]/div[1]/div[2]/div[1]"));
		
		WebElement Gender=driver.findElement(By.xpath("//div[@class=\"direct fixedHeight\"]  "));
		Gender.click();	
		WebElement Genderselect=driver.findElement(By.xpath("//span[normalize-space()='Female']"));
		Genderselect.click();	
				
		//DOB
		WebElement DOB=driver.findElement(By.xpath("//input[@type=\"date\"]"));
		DOB.sendKeys("08-01-2001");
		
		//Role
		WebElement Role=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[2]"));
		Role.click();
		WebElement RoleSelect=driver.findElement(By.xpath("//span[normalize-space()='Admin']"));
		RoleSelect.click();	
		
		//Select Department
		WebElement Department=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[3]"));
		Department.click();
		WebElement DepartmentSelect=driver.findElement(By.xpath("//span[normalize-space()='Administration']"));
		DepartmentSelect.click();		
				
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
		
		//Successfully run, code updated on 10.09.24
		
	}
	
	
	public void useredit() throws InterruptedException
	{
		//Click on Setting 
		WebElement Settingclick=driver.findElement(By.xpath("//span[@class=\"scc-name\" and text()=\"Settings\"]"));
		Settingclick.click();
		
		//Click on UserManagement
		WebElement UserManagementclick=driver.findElement(By.xpath("//div[normalize-space()='User Management']"));
		UserManagementclick.click();
		Thread.sleep(2000);
		
		//View User		
		WebElement ViewButtonClick1=driver.findElement(By.xpath("(//span[contains(text(),'visibility')])[1]"));
		ViewButtonClick1.click();
		
		//Click on Edit button
		WebElement EditButtonClick1=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		EditButtonClick1.click();
					
		//First Name
		WebElement FirstNameEdit=driver.findElement(By.xpath("//input[@id='first_name']"));
		FirstNameEdit.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		FirstNameEdit.sendKeys("Ronak1");	
		
		//Last Name
		WebElement LastNameEdit=driver.findElement(By.xpath("//input[@id='last_name']"));
		LastNameEdit.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		LastNameEdit.sendKeys("Patel1");	
				
		//EmailId
		WebElement EmailIdEdit=driver.findElement(By.xpath("//input[@id='email']"));
		EmailIdEdit.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		EmailIdEdit.sendKeys("ronakriya1@poonamcoatings.com");	
		
		//PhoneNumber
		WebElement PhoneNumberEdit=driver.findElement(By.xpath("//input[@id='phone_no']"));
		PhoneNumberEdit.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		PhoneNumberEdit.sendKeys("9787856456");
		
		//Gender
		WebElement GenderEdit=driver.findElement(By.xpath("//div[@class=\"direct fixedHeight\"]"));
		GenderEdit.click();		
		WebElement GenderselectEdit=driver.findElement(By.xpath("//span[normalize-space()='Male']"));
		GenderselectEdit.click();	
				
		//DOB
		WebElement DOBEdit=driver.findElement(By.xpath("//input[@id='dob']"));
		DOBEdit.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		DOBEdit.sendKeys("02-03-2001");
		
		//Role
		WebElement RoleEdit=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[2]"));
		RoleEdit.click();		
		WebElement RoleSelectEdit=driver.findElement(By.xpath("//span[normalize-space()='Admin']"));
		RoleSelectEdit.click();	
		
		//Department	
		//Select Department
		WebElement EditDepartment=driver.findElement(By.xpath("(//div[@class='direct fixedHeight'])[3]"));
		EditDepartment.click();
		WebElement Editdepartmentselect=driver.findElement(By.xpath("//div[normalize-space()='Marketing']"));
		Editdepartmentselect.click();	
			
//		//Privileges
//		WebElement PrivilegesEdit=driver.findElement(By.xpath("//button[normalize-space()='Edit Privileges']"));
//		PrivilegesEdit.click();		
//		WebElement PrivilegesReadEdit=driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]"));	
//		PrivilegesReadEdit.click();		
//		WebElement PrivilegeswirteEdit=driver.findElement(By.xpath("//tbody/tr[1]/td[3]/input[1]"));	
//		PrivilegeswirteEdit.click();				
		
//		//Submit privileges
	

		try
		{
			
			 WebElement prevsubmit=driver.findElement(By.cssSelector(".privileges-submit > button"));
			 prevsubmit.click();
			 	
		}
			
		catch(Exception e)
		{
				e.printStackTrace();			
				
		}
		
		
		//Main User add Submit
		WebElement submitmul=driver.findElement(By.cssSelector(".btn-primary:nth-child(2)"));
		submitmul.click();
		
	}
	
	
	public void userdelete() throws InterruptedException
	{
		
		//Click on Setting 
		WebElement Settingclick=driver.findElement(By.xpath("//span[@class=\"scc-name\" and text()=\"Settings\"]"));		
		Settingclick.click();
		
		//Click on UserManagement
		WebElement UserManagementclick=driver.findElement(By.xpath("//div[normalize-space()='User Management']"));
		UserManagementclick.click();
		Thread.sleep(2000);
				
		
		int row=9;
		for(int i=0;i<=row;i++)
		{		
		//delete User							
		WebElement deleteuser=driver.findElement(By.xpath("//tbody/tr[2]/td[7]/div[1]/button[3]/span[1]"));	
		deleteuser.click();	
		
		WebElement deleteclick=driver.findElement(By.xpath("//button[@class='del-conform']"));
		deleteclick.click();
		
		//Successfully run, Code updated on 10.09.24
	}}
	
	
	public static void main(String[] args) throws InterruptedException
	{		
		UserManagement obj=new UserManagement();
		obj.chrome();
		//obj.useradd();
		//obj.useredit();	
		obj.userdelete();
		//run successfully
	}

}
