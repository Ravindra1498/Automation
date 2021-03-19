package tests;

import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import locators.LandinfPage_Locators;
import locators.LoginUserDetals_Locators;
import locators.SelectProduct_Locators;
import locators.SendToFriend_Locators;
import utilities.ElementActions;
import utilities.JavaScriptUtil;
import utilities.Utiles;
import variables.LoginUserDetails;
import variables.Products_variables;
import variables.SendToFriend_variabelsDetails;

public class SendFeature {
	
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	Utiles utiles;
	JavaScriptUtil javascriptutil;
	ElementActions elementActions;
	
	
	@Before
	public void setup()
	{
		utiles = new Utiles();
		prop = utiles.init_prop();
		driver = utiles.init_driver(prop);
		elementActions = new ElementActions(driver);
		javascriptutil = new JavaScriptUtil(driver);
		wait = new WebDriverWait(this.driver, Integer.parseInt(prop.getProperty("WebDriverWaitTimeout")));
		
	}
	
	//Login In site
	@Ignore
	@Test
	public void login() throws InterruptedException 
	{
		elementActions.doClick(LandinfPage_Locators.SignInButtonElement);
		wait.until(ExpectedConditions.presenceOfElementLocated(LandinfPage_Locators.SignInButtonElement));
		elementActions.doSendKey(LoginUserDetals_Locators.UserEmailAddressTextElement,LoginUserDetails.UserEmail);
		elementActions.doSendKey(LoginUserDetals_Locators.UserPasswordTextElement, LoginUserDetails.UserPassword);
		elementActions.doClick(LoginUserDetals_Locators.SubmitBtnElement);
		wait.until(ExpectedConditions.presenceOfElementLocated(SelectProduct_Locators.CategoryTshirtElement));
		elementActions.doClick(SelectProduct_Locators.CategoryTshirtElement);
		wait.until(ExpectedConditions.presenceOfElementLocated(SelectProduct_Locators.ProductHoverMoreOption));
		elementActions.doMoveToElement(SelectProduct_Locators.ProductHoverMoreOption);
		elementActions.doClick(SelectProduct_Locators.ClickOnMoreOptionElementBtn);
		wait.until(ExpectedConditions.presenceOfElementLocated(SelectProduct_Locators.SendToFriendLinkElement));
		elementActions.doClick(SelectProduct_Locators.SendToFriendLinkElement);
		
		elementActions.doSendKey(SendToFriend_Locators.SendToFriendNameOfFriendTextElement,SendToFriend_variabelsDetails.NameOfFriend);
		elementActions.doSendKey(SendToFriend_Locators.SendToFriendEmailOfFriendTextElement, SendToFriend_variabelsDetails.EmailOfFriend);
		elementActions.doClick(SendToFriend_Locators.SendBtnElement);
		wait.until(ExpectedConditions.presenceOfElementLocated(SendToFriend_Locators.AfterEmailendMsg));
		Assert.assertEquals("Email No send msg not Match",SendToFriend_variabelsDetails.AfterEmailSendMsgExpectedText,elementActions.doGetText(SendToFriend_Locators.AfterEmailendMsg));	
		//System.out.println("email send msg--> Your e-mail has been sent successfully");
		elementActions.doClick(SendToFriend_Locators.AfterSendEmailOkBtnElement);

		System.out.println("Email Successfull Send");
		System.out.println("Test pass");
	}
	
	

	@Ignore
	@Test
	public void ChangeColor()  throws InterruptedException
	{
		elementActions.doClick(LandinfPage_Locators.ProductCategorie);
		
		String img1 = elementActions.getAttributeValue(SelectProduct_Locators.first_img, "src");
		//System.out.println("src " + img1);
		
		elementActions.doMoveToElement(SelectProduct_Locators.ProductHoverMoreOption);
		elementActions.doClick(SelectProduct_Locators.SelectProductColor);
		
		String img2 = elementActions.getAttributeValue(SelectProduct_Locators.Second_img, "src");
		//System.out.println("Second Img Src : " + img2);
		
		if(img1.equals(img2))
		{	
			Assert.assertTrue(true);
			System.out.println("image not change");
		}
		else
		{
			Assert.assertFalse(false);
			System.out.println("Image is change and test pass");
		}
	}
	
	@Test
	public void End_to_End() throws InterruptedException
	{
		float OneProduct = 16.51f;
		float total = OneProduct*2;
		System.out.println(total);
		
		elementActions.doClick(LandinfPage_Locators.SignInButtonElement);
		
		elementActions.doSendKey(LoginUserDetals_Locators.UserEmailAddressTextElement,LoginUserDetails.UserEmail);
		elementActions.doSendKey(LoginUserDetals_Locators.UserPasswordTextElement, LoginUserDetails.UserPassword);
		elementActions.doClick(LoginUserDetals_Locators.SubmitBtnElement);
		
		elementActions.doClick(SelectProduct_Locators.CategoryTshirtElement);
		elementActions.doMoveToElement(SelectProduct_Locators.ProductHoverMoreOption);
		
		
		String productValue = elementActions.doGetText(SelectProduct_Locators.ProductPrice).substring(1);
		System.out.println("Price : " +productValue);
		
		elementActions.doMoveToElement(SelectProduct_Locators.ProductHoverMoreOption);
		elementActions.doClick(SelectProduct_Locators.ClickOnProduct);
		
		//elementActions.doClick(SelectProduct_Locators.AddQuantity);//-->  Plus Quantity using plus button
		elementActions.doclear(SelectProduct_Locators.AddQuantityProduct);
		elementActions.doSendKey(SelectProduct_Locators.AddQuantityProduct,Products_variables.PlusProduct);
		
		elementActions.selectValueFromeDropDown(SelectProduct_Locators.selectSize,Products_variables.size);
		Thread.sleep(3000);
		
		//waitForElementVisible(SelectProduct_Locators.AddToCartButton);
		elementActions.doClick(SelectProduct_Locators.AddToCartButton);
		elementActions.waitForElementVisible(SelectProduct_Locators.ProductAddSuccess);
		//Thread.sleep(3000);
		
		boolean sucess = elementActions.doIsDisplayed(SelectProduct_Locators.ProductAddSuccess);
		System.out.println("Product added successFully : "  +sucess);
		
		Assert.assertEquals("Quantity not match",Products_variables.PlusProduct,elementActions.doGetText(SelectProduct_Locators.productQuantity));
		Assert.assertEquals("Color Not Match", Products_variables.Color,elementActions.doGetText(SelectProduct_Locators.ProductColor).substring(0,6));
		System.out.println("Quantity and Color match");
		
		Assert.assertEquals("Total not match", Float.toString(total),elementActions.doGetText(SelectProduct_Locators.TotalPrice).substring(1));
	
		System.out.println("Price is Twice And Total Price Match-->32.02");
		
		elementActions.doClick(SelectProduct_Locators.CheckOutButton);
		//String ProudctNameInTheCart = elementActions.doGetText(SelectProduct_Locators.ProductInCart);
		
		
		boolean CheckProductNameInCart = elementActions.doIsDisplayed(SelectProduct_Locators.ProductInCart);
		System.out.println("Product Name is display : " + CheckProductNameInCart );
		
		
		
		
	}
	

	

	@After
	public void termdown()
	{
		driver.quit();
	}
	
	
	

}



