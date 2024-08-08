package Testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmailFromExcel
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
	
       

    public void Addemail1(String ETitles, String ESubject, String EDesc) throws InterruptedException 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Click on Setting
        WebElement Settingclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
        Settingclick.click();
        Thread.sleep(4000);

        // Click on Email Management
        WebElement EmailManagementclick = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Email Management')]")));
        EmailManagementclick.click();

        // Add new email
        WebElement EmailManagementadd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-primary header-btn']")));
        EmailManagementadd.click();
        Thread.sleep(2000);

        // Title
        WebElement Title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));
        // Title.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));	
        Title.sendKeys(ETitles);

        // Subject
        WebElement Subject = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subject']")));
        // Subject.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));	
        Subject.sendKeys(ESubject);

        // Description
        WebElement Description = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ql-editor ql-blank']")));
        // Description.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));	
        Description.sendKeys(EDesc);

        WebElement Submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        Submit.click();
    }

    public void addEmailsFromExcel(String excelFilePath) throws IOException, InterruptedException 
    {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\Bulk Email Add.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet Sheet1 = workbook.getSheetAt(0);

        
        for (int i = 1; i <= Sheet1.getLastRowNum(); i++)
        {
            Row row = Sheet1.getRow(i);

            if (row == null) 
            {
                continue; // skip empty rows
            }

            String Titles = getCellValueAsString(row.getCell(0));
            String Subject = getCellValueAsString(row.getCell(1));
            String Desc = getCellValueAsString(row.getCell(2));
            Addemail1(Titles, Subject, Desc);
            Thread.sleep(2000);           
        }
        
        
        System.out.println("Record added successfully");
        workbook.close();
        inputStream.close();
    }

    private String getCellValueAsString(Cell cell) 
    {
        if (cell == null)
        {
            return " "; // return empty string if cell is null
        }
        switch (cell.getCellType()) 
        {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return ""; // return empty string for other cell types or null cells              
        }
      
    }
    


    public static void main(String[] args) throws InterruptedException, IOException 
    {
        AddEmailFromExcel obj = new AddEmailFromExcel();
        obj.chrome();
        obj.addEmailsFromExcel("C:\\Users\\Aaditya\\eclipse-workspace\\PoonamCoatingsCRM\\src\\Testing\\Bulk Email Add.xlsx");
        obj.driver.quit(); // Quit the WebDriver session after completing tasks
    }
}
