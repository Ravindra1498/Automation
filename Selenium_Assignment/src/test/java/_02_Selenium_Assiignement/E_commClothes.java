package _02_Selenium_Assiignement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class E_commClothes {

	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get("http://automationpractice.com/index.php");
		
		wait = new WebDriverWait(driver,15);
	}
	
	@Test
	public void Search()
	{
		String Product = "Dress";
		int DressProduct = 0;
		
		
		WebElement SearchBox = driver.findElement(By.id("search_query_top"));
		if(SearchBox.isEnabled())
		{
			SearchBox.sendKeys(Product);
		}
		
		List <WebElement> SearchList  = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		wait.until(ExpectedConditions.visibilityOfAllElements(SearchList));
		//System.out.println(SearchList.size());
		for(int i=0; i<SearchList.size();i++)
		{
			//System.out.println((1+i)+ " : " + SearchList.get(i).getText());
			
			
			if(SearchList.get(i).getText().contains(Product))
			{
				System.out.println(SearchList.get(i).getText());
				DressProduct++;
			}
		}
		
		System.out.println("Total Products Contains Dress : " + DressProduct);
		Assert.assertEquals("Product count not match",DressProduct,5);
		System.out.println("Test Pass");
	}
	
	@Test
	public void ProductPriceAndTotal() throws InterruptedException
	{
		WebElement  CategorieTitle = driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a"));
		//System.out.println(CategorieTitle.getText());
		
		Assert.assertEquals("not in uppercase","DRESSES" ,CategorieTitle.getText());
		System.out.println("Test pass");
		
		Thread.sleep(2000);
		CategorieTitle.click();
		
		List <WebElement> PriceOFAllDress = driver.findElements(By.xpath("//ul[@class='product_list grid row']//div[@class='right-block']//span[@class='price product-price']"));
		float x = 0f;
		for(int i = 0; i<PriceOFAllDress.size();i++)
		{
		
			System.out.println("All Product " + PriceOFAllDress.get(i).getText());
			x = x + Float.parseFloat(PriceOFAllDress.get(i).getText().substring(1)); 
			
		}
		
		System.out.println("Totoal price of Product is : " + x); 
		Assert.assertEquals("Total not match", 152.87,x,0.1);
		System.out.println("Test pass");
	}
	
	@After
	public void termdown()
	{
		driver.quit();
	}
}
