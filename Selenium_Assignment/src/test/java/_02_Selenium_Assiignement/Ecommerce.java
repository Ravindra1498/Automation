package _02_Selenium_Assiignement;




import static org.junit.Assert.assertTrue;

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
import org.openqa.selenium.support.ui.Select;



public class Ecommerce {
	
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String Title = "My Store";
	
	
	@Before
	public void setup() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/");
		Thread.sleep(3000);
		
	}
	@Test
	public void a_redirectUrl()
	{
		
//		if(driver.getCurrentUrl().equals(url)){
//			System.out.println("Url redirect");
//		}
//		else
//		{
//			driver.navigate().to(url);
//		}

		Assert.assertEquals("Url is not match", driver.getCurrentUrl(), url);
		System.out.println("Url verify");
		
	}
//	
	@Test
	public void b_Title_Test()
	{
		Assert.assertEquals("Title not match as My Store", driver.getTitle(), Title);
		System.out.println("Title Verify");
	}
//	
	@Test
	public void c_Product_category()
	{
		List <WebElement> Product_cat = driver.findElements(By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//a"));
		System.out.println("Total product category" + Product_cat.size());
		
		for(int i = 0;  i< Product_cat.size(); i++)
		{
			//System.out.println(Product_cat.get(i).getText());
//			if(Product_cat.get(i).getText()!="")
//			{
//				//System.out.println(Product_cat.get(i).getText());
//				boolean Product_cat_display = Product_cat.get(i).isDisplayed();
//				System.out.println(Product_cat.get(i).getText()  +  "   is display : "  +  Product_cat_display);
//			}
			assertTrue("", Product_cat.get(i).getText()!="");
			boolean Product_cat_display = Product_cat.get(i).isDisplayed();
			System.out.println(Product_cat.get(i).getText() +  "  Is Display  :  "  +  Product_cat_display);
		}	
		
	}
//	
	@Test
	public void d_logoTest()
	{
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		boolean Logodisplay = logo.isDisplayed();
		System.out.println("logo display : " + Logodisplay);
		
	}
	
	@Test
	public void e_logoHeight()
	{	
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		Assert.assertEquals("Logo Height not match", "99",logo.getAttribute("height"));
		System.out.println("Logo Height is verify");
	}
	@Test
	public void e_logoWidth()
	{	
		WebElement logo = driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		Assert.assertEquals("Logo Width not match","350",logo.getAttribute("width"));
		System.out.println("Logo Width is verify");
	}
//	
//	@Test
//	public void f_SignInTitle() throws InterruptedException
//	{
//		String title = "Login - My Store";
//		WebElement signIn = driver.findElement(By.className("login"));
//		signIn.click();
//		Thread.sleep(15000);
//		String currentTitle = driver.getTitle();
//		Assert.assertEquals("Title not match", currentTitle, title);
//		System.out.println("Title verify");	
//	}
	
//	@Test
//	public void g_UserEmailSignIn() throws InterruptedException
//	{
//		String First_Name = "Ravindra";
//		String Last_Name = "Phapale";

//		String Email = "ravi32@gmail.com";
//		//String AccountText = "CREATE AN ACCOUNT";
//		WebElement SignBtn = driver.findElement(By.className("login"));
//		SignBtn.click();
//		Thread.sleep(1500);
//		WebElement UserEmail = driver.findElement(By.id("email_create"));
//		UserEmail.sendKeys(Email);
//		Thread.sleep(2000);
//		WebElement AccountBtn = driver.findElement(By.id("SubmitCreate"));
//		AccountBtn.click();
//		Thread.sleep(2000);
//		WebElement AccountText = driver.findElement(By.xpath("//h1[@class='page-heading']"));
//		
//		boolean AccountTextDis = AccountText.isDisplayed();
//		//System.out.println("CREATE AN ACCOUNT is display : " + AccountTextDis);
//		Thread.sleep(1500);
//		
//		//	YOUR PERSONAL INFORMATION SECTION
//		
//		WebElement SelectGender = driver.findElement(By.xpath("//input[@id='id_gender1']"));
//		SelectGender.click();
//		Thread.sleep(1500);
//		WebElement FirstName = driver.findElement(By.id("customer_firstname"));
//		FirstName.sendKeys(First_Name);
//		Thread.sleep(1500);
//		WebElement LastName = driver.findElement(By.id("customer_lastname"));
//		LastName.sendKeys(Last_Name);
//		Thread.sleep(1500);
//		WebElement UserPass = driver.findElement(By.id("passwd"));
//		UserPass.sendKeys("Ravindra@");
//		//Thread.sleep(1500);
//		
//		WebElement BirthDay = driver.findElement(By.id("days"));
//		WebElement BirthMonth = driver.findElement(By.id("months"));
//		WebElement BirthYear = driver.findElement(By.id("years"));
//		
//		Ecommerce obj = new Ecommerce();
//		
//		obj.BirthDateSelectFromDropDown(driver,BirthDay, "14  ");
//		//Thread.sleep(2000);
//		obj.BirthDateSelectFromDropDown(driver,BirthMonth, "June ");
//		//Thread.sleep(2000);
//		obj.BirthDateSelectFromDropDown(driver,BirthYear, "1988  ");
//		//Thread.sleep(2000);
//		
//		WebElement checkbox1 = driver.findElement(By.id("uniform-newsletter"));
//		checkbox1.click();
//		Thread.sleep(1500);
//		WebElement checkbox2 = driver.findElement(By.id("uniform-optin"));
//		checkbox2.click();
//		Thread.sleep(2000);
//		
//		//“YOUR ADDRESS” section
////		WebElement AddFname = driver.findElement(By.id("firstname"));
////		AddFname.sendKeys(First_Name);
////		Thread.sleep(1500);
////		WebElement AddLname = driver.findElement(By.id("lastname"));
////		AddLname.sendKeys(Last_Name);
////		Thread.sleep(1500);
//		WebElement company = driver.findElement(By.id("company"));
//		company.sendKeys("xzy");
//		Thread.sleep(1500);
//		WebElement address = driver.findElement(By.id("address1"));
//		address.sendKeys("Nashik shramik nagar");
//		Thread.sleep(1500);
//		WebElement address2 = driver.findElement(By.id("address2"));
//		address2.sendKeys("new apartment 5 floor");
//		Thread.sleep(1500);
//		WebElement city = driver.findElement(By.id("city"));
//		city.sendKeys("Nashik");
//		Thread.sleep(1500);
//		WebElement state = driver.findElement(By.id("id_state"));
//		Select selectState = new Select(state);
//		selectState.selectByVisibleText("Indiana");
//		Thread.sleep(1500);
//		WebElement postcode = driver.findElement(By.id("postcode"));
//		postcode.sendKeys("00000");
//		Thread.sleep(1500);
//		WebElement country = driver.findElement(By.id("id_country"));
//		Select selectCountry = new Select(country);
//		selectCountry.selectByVisibleText("United States");
//		Thread.sleep(1500);
//		WebElement AddInfo = driver.findElement(By.id("other"));
//		
//		AddInfo.sendKeys("lets go to the safe zone");
//		Thread.sleep(1500);
//		WebElement phone = driver.findElement(By.id("phone_mobile"));
//		phone.sendKeys("9665278503");
//		Thread.sleep(1500);
//		WebElement ref = driver.findElement(By.id("alias"));
//		ref.clear();
//		ref.sendKeys("abcdef");
//		Thread.sleep(3000);
//		WebElement RegisterBtn = driver.findElement(By.id("submitAccount"));
//		RegisterBtn.click();
//		Thread.sleep(10000);
//		
//		
//		WebElement accountName = driver.findElement(By.xpath("//div[@class='header_user_info']//a//span"));
//		String accountUserName = accountName.getText();
//		Assert.assertEquals("Name not match on ",First_Name + " " + Last_Name ,accountUserName);
//		System.out.println("verify Name" + First_Name + " " + Last_Name);
//		Thread.sleep(2000);
//	
//		System.out.println("CREATE AN ACCOUNT is display : " + AccountTextDis);
//	}
	@After
	public void termdown()
	{
		driver.quit();
	}
	
	//Reusable method
	public void BirthDateSelectFromDropDown(WebDriver driver,WebElement element, String Value)
	{
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(Value);
		
				
		
	}
}
