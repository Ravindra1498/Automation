package SwagLab;


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

public class _01_SwagLabTest {

	WebDriver driver;
	WebDriverWait Wait;
	String TextToClick = "Sauce Labs Backpack";
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
		
		Wait = new WebDriverWait(driver,20);
	}
	
//	@Test
//	public void Logo()
//	{
//		driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();
//		System.out.println("Logo is display");
//	}
	@Test
	public void Login() throws InterruptedException
	{
		WebElement UserName = driver.findElement(By.xpath("//input[@id='user-name']"));
		UserName.sendKeys("standard_user");
		Thread.sleep(1500);
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys("secret_sauce");
		Thread.sleep(1500);
		WebElement loginbtn = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginbtn.click();
	
		Assert.assertEquals("Url Not Match", driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		System.out.println("login Success");
		
		//List <WebElement> AllProducts = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		//System.out.println("All Products");
//		for(int i = 0; i<AllProducts.size();i++)
//		{	
//			//System.out.println((1+i) + ":"+ AllProducts.get(i).getText());	
//			if(AllProducts.get(i).getText().equals(TextToClick))
//				{
//					AllProducts.get(i).click();
//				}	
//		}
		
		WebElement AddCartBtn = driver.findElement(By.xpath("//button[@class='btn_primary btn_inventory']"));
		AddCartBtn.click();
		Thread.sleep(1000);
		WebElement cartIcon = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
		cartIcon.click();
		Thread.sleep(1000);
		WebElement cartProduct = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		Assert.assertEquals("Product Not Match", TextToClick, cartProduct.getText());
		System.out.println("Product Added successfully");

	
		
	}
	
//	@Test
//	public void AddtoCard()
//	{
//		driver.get("https://www.saucedemo.com/inventory.html");
//		
//	}
	
	
	
	@After
	public void termdown() throws InterruptedException
	{
		Thread.sleep(1500);
		driver.quit();
	}
	
}
