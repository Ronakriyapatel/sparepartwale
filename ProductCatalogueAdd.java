package Testing;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductCatalogueAdd 
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
		
		//Setting 		
		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
		Settings.click();	
		Thread.sleep(2000);	
				
		//ProductCatalogue
		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
		ProductCatalogue.click();	
		Thread.sleep(2000);	
	}

	public void Addbrand() throws InterruptedException
	{		
//		//Setting 		
//		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
//		Settings.click();	
//		Thread.sleep(2000);	
//		
//		//ProductCatalogue
//		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
//		ProductCatalogue.click();	
//		Thread.sleep(2000);	
		
		//Brand Click		
		WebElement BrandClick=driver.findElement(By.xpath("//button[@class='product-cat-btn active']"));
		BrandClick.click();	
		Thread.sleep(2000);				
		
		//AddBrand		
		WebElement AddBrand=driver.findElement(By.xpath("//button[@class='btn-primary']"));
		AddBrand.click();	
		Thread.sleep(2000);	
		
		WebElement BrandName=driver.findElement(By.xpath("//input[@id='name']"));
		BrandName.sendKeys("AATest0");	
		Thread.sleep(2000);	
		
		//Submit button work
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();
		
		//Perfect code
	
	}
	
	public void AddCategory() throws InterruptedException
	{		
//		//Setting 		
//		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
//		Settings.click();	
//		Thread.sleep(2000);	
//		
//		//Product Catalogue
//		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
//		ProductCatalogue.click();	
//		Thread.sleep(2000);	
		
		//Category Click		
		WebElement CategoryClick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/button[2]"));
		CategoryClick.click();	
		Thread.sleep(2000);				
		
		//AddProduct Category		
		WebElement AddProductCategory=driver.findElement(By.xpath("//button[@class='btn-primary']"));
		AddProductCategory.click();	
		Thread.sleep(2000);					
		
		//Brand		
		WebElement BrandClick=driver.findElement(By.xpath("//div[@class='direct fixedHeight']"));
		BrandClick.click();	
		Thread.sleep(2000);	
		
		WebElement BrandSelect=driver.findElement(By.xpath("//span[normalize-space()='Sherwin Williams']"));
		BrandSelect.click();	
		Thread.sleep(2000);
		
		//Category Name		
		WebElement CategoryName=driver.findElement(By.xpath("//input[@id='category']"));
		CategoryName.sendKeys("AATest4");	
		Thread.sleep(2000);		
		
		//Submit button work
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();
		
		//Perfect code
	
	}
	
	
	public void AddSubCategory() throws InterruptedException
	{		
//		//Setting 		
//		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
//		Settings.click();	
//		Thread.sleep(2000);	
//		
//		//Product Catalogue
//		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
//		ProductCatalogue.click();	
//		Thread.sleep(2000);	
		
		//SubCategory Click		
		WebElement SubCategoryClick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/button[3]"));
		SubCategoryClick.click();	
		Thread.sleep(2000);				
		
		//AddSubCategory		
		WebElement AddSubCategory=driver.findElement(By.xpath("//button[@class='btn-primary']"));
		AddSubCategory.click();	
		Thread.sleep(2000);				
		
		//Category	
		WebElement CategoryClick=driver.findElement(By.xpath("//div[@class='direct fixedHeight']"));
		CategoryClick.click();	
		Thread.sleep(2000);		
		WebElement CategorySelect=driver.findElement(By.xpath("//span[normalize-space()='Primer (JOTUN)']"));
		CategorySelect.click();	
		Thread.sleep(2000);
		
		//SubCategory Name		
		WebElement SubCategoryName=driver.findElement(By.xpath("//input[@id='category']"));
		SubCategoryName.sendKeys("ATest5");	
		Thread.sleep(2000);
				
		//Submit button work
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();
		
		//Perfect code
	
	}
	
	public void AddSubChildCategory() throws InterruptedException
	{		
		
//		//Setting 		
//		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
//		Settings.click();	
//		Thread.sleep(2000);	
//		
//		//ProductCatalogue
//		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
//		ProductCatalogue.click();	
//		Thread.sleep(2000);			
		
		//SubChildCategory Click		
		WebElement SubChildCategoryClick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/button[4]"));
		SubChildCategoryClick.click();	
		Thread.sleep(2000);				
		
		//AddSubChildCategory		
		WebElement AddSubChildCategory=driver.findElement(By.xpath("//button[@class='btn-primary']"));
		AddSubChildCategory.click();	
		Thread.sleep(2000);				
		
		//SubCategory	
		WebElement SubCategoryClick=driver.findElement(By.xpath("//div[@class='direct fixedHeight']"));
		SubCategoryClick.click();	
		Thread.sleep(2000);		
		WebElement SubCategorySelect=driver.findElement(By.xpath("//div[@id='delete-card-container']//div[3]//span[1]"));
		SubCategorySelect.click();	
		Thread.sleep(2000);
		
		//SubChildCategory Name		
		WebElement SubChildCategoryName=driver.findElement(By.xpath("//input[@id='category']"));
		SubChildCategoryName.sendKeys("Epoxy Primer1A");	
		Thread.sleep(2000);
				
		//Submit button work
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();
		
		//Perfect code
	
	}
	
	
	public void PaintType() throws InterruptedException
	{		
		
//		//Setting 		
//		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
//		Settings.click();	
//		Thread.sleep(2000);	
//				
//		//ProductCatalogue
//		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
//		ProductCatalogue.click();	
//		Thread.sleep(2000);					
	
		//PaintTypeClick		
		WebElement PaintTypeClick=driver.findElement(By.xpath("//button[normalize-space()='Paint Type']"));
		PaintTypeClick.click();	
		Thread.sleep(2000);		
	
		//AddPaintType		
		WebElement AddPaintType=driver.findElement(By.xpath("//button[@class='btn-primary']"));
		AddPaintType.click();	
		Thread.sleep(2000);		
		
		//AddPaintName		
		WebElement PaintTypeName =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
		PaintTypeName.sendKeys("ATest6");
		Thread.sleep(2000);			
		
		//Submit button work
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();
		
		//Perfect code
	
	}	
	
	public void FinishType() throws InterruptedException
	{		
		
//		//Setting 		
//		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
//		Settings.click();	
//		Thread.sleep(2000);	
//				
//		//ProductCatalogue
//		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
//		ProductCatalogue.click();	
//		Thread.sleep(2000);					
	
		//FinishTypeClick		
		WebElement FinishTypeClick=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/button[6]"));
		FinishTypeClick.click();	
		Thread.sleep(2000);		
		
		//AddFinishType		
		WebElement AddFinishType=driver.findElement(By.xpath("//button[normalize-space()='ADD FINISH']"));
		AddFinishType.click();	
		Thread.sleep(2000);		
		
		//FinishTypeName		
		WebElement FinishTypeName=driver.findElement(By.xpath("//input[@id='name']"));
		FinishTypeName.sendKeys("ATest7");
		Thread.sleep(2000);				
		
		//Submit button work
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();
		
		//Perfect code
	
	}	
	
	public void UOM() throws InterruptedException
	{		
		
//		//Setting 		
//		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
//		Settings.click();	
//		Thread.sleep(2000);	
//				
//		//ProductCatalogue
//		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
//		ProductCatalogue.click();	
//		Thread.sleep(2000);					
	
		//UOMClick		
		WebElement UOMClick=driver.findElement(By.xpath("//button[normalize-space()='UOM']"));
		UOMClick.click();	
		Thread.sleep(2000);		
		
		//AddUOM		
		WebElement AddUOMType=driver.findElement(By.xpath("//button[normalize-space()='ADD UOM']"));
		AddUOMType.click();	
		Thread.sleep(2000);		
		
		try
		{
		//UOMName		
		WebElement UOMName=driver.findElement(By.xpath("//input[@id='uom']"));
		//UOMName.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));		
		UOMName.sendKeys("AATestrrr");
		Thread.sleep(3000);		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//Submit button work
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();	
		
		//Perfect code
	}
	
	
	public void Color() throws InterruptedException
	{		
		
//		//Setting 		
//		WebElement Settings=driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
//		Settings.click();	
//		Thread.sleep(2000);	
//				
//		//ProductCatalogue
//		WebElement ProductCatalogue=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[10]/div[6]"));
//		ProductCatalogue.click();	
//		Thread.sleep(2000);					
	
		//COLORClick		
		WebElement ColorClick=driver.findElement(By.xpath("//button[normalize-space()='Color']"));
		ColorClick.click();	
		Thread.sleep(2000);		
		
		//AddColor		
		WebElement AddUOMType=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/button[1]"));
		AddUOMType.click();	
		Thread.sleep(2000);		
		
		//UOMName		
		WebElement UOMName=driver.findElement(By.xpath("//input[@id='uom']"));
		UOMName.sendKeys("ATest9");
		Thread.sleep(2000);				
		
		//Submit button work
		WebElement Submit=driver.findElement(By.xpath("//button[@type='submit']"));
		Submit.click();	
		
		
		//Error in actual code --> Not perfect
	}
	
	
	
	public static void main(String[] args) throws InterruptedException
	{
	// TODO Auto-generated method stub
	ProductCatalogueAdd obj = new ProductCatalogueAdd();
//	obj.chrome();
//	obj.Addbrand();
//	obj.AddCategory();
//	obj.AddSubCategory();
//	obj.AddSubChildCategory();
//	obj.PaintType();
//	obj.FinishType();
//	obj.UOM();
	obj.Color();
	
	}

}
