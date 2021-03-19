package tests;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import locators.AddToCartProductPageLocator;
import locators.AfterRegisterLocator;
import locators.LandinfPage_Locators;
import locators.LoginUserDetals_Locators;
import locators.RegisterUser_locator;
import locators.SelectProduct_Locators;
import locators.SendToFriend_Locators;
import locators.SignInPage_locator;
import locators.searchProduct_locator;
import locators.socail_media_icons_locator;
import utilities.ElementActions;
import utilities.JavaScriptUtil;
import utilities.Utiles;
import variables.AddProductsInCart_variables;
import variables.Landing_pageVariable;
import variables.LoginUserDetails;
import variables.Products_variables;
import variables.RegisterUserDetails_Variables;
import variables.SendToFriend_variabelsDetails;
import variables.SignInPage_variable;
import variables.social_icon_Variable;

public class Automation {
	
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	Utiles utiles;
	JavaScriptUtil javascriptutil;
	ElementActions elementActions;
	String url = "http://automationpractice.com/index.php";
	String Title = "My Store";

	
	
	
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
	@Ignore
	@Test    //Url test case
	public void _01_redirectUrl()
	{

		Assert.assertEquals("Url is not match",Landing_pageVariable.ExpectedURL, elementActions.doGetcurrentURL());
		System.out.println("Url verify test pass");
		
	}
	@Ignore
	@Test  //Title Test case
	public void _02_Title_Test()
	{
		Assert.assertEquals("Title not match as My Store", Landing_pageVariable.LandingPageTitle, elementActions.doGetPageTitle());
		System.out.println("Title test pass");
	}
	@Ignore
	@Test
	public void _03_Product_category()
	{
		ArrayList<String> expectedCategoryList = Landing_pageVariable.ExpectedProductCategories();
		
		List<WebElement> actualProductCategoryList = elementActions.getElementsList(LandinfPage_Locators.ProductCatList);
		
		for (int i = 0; i < expectedCategoryList.size(); i++) 
		{
			Assert.assertEquals("Product index no " + (i+1) + " is not matching with expected",expectedCategoryList.get(i), actualProductCategoryList.get(i).getText());
		}
		
		System.out.println("all categories is displayed passed");
	}
	@Ignore
	@Test
	public void _04_logoTest()
	{
		Assert.assertEquals("logo Not diplay",true, elementActions.doIsDisplayed(LandinfPage_Locators.Landing_page_logo));
		System.out.println("Logo is Display : Test Pass");
		
	}
	@Ignore
	@Test
	public void _05_logoHeight()
	{	
		
		Assert.assertEquals("Logo Height not match",Landing_pageVariable.LogoHeight,elementActions.getAttributeValue(LandinfPage_Locators.logoHeight, "height"));
		System.out.println("Logo Height is verify test pass");
	}
	@Ignore
	@Test
	public void _06_logoWidth()
	{	
		
		Assert.assertEquals("Logo Width not match",Landing_pageVariable.LogoWidth,elementActions.getAttributeValue(LandinfPage_Locators.logoWidth, "width"));
		System.out.println("Logo Width is verify test pass");
	}
	@Ignore
	@Test
	public void _07_SignInTitle() 
	{
		elementActions.doClick(LandinfPage_Locators.SignInButtonElement);
		Assert.assertEquals("Signin Page Title is not match",SignInPage_variable.SignInPageTitle,elementActions.doGetPageTitle());
		System.out.println("Title match Test Pass");
	}
	@Ignore
	@Test
	public void _08_UserEmailSignIn()
	{
		elementActions.doClick(LandinfPage_Locators.SignInButtonElement);
		elementActions.doSendKey(SignInPage_locator.userEmail,SignInPage_variable.UserEmail);
		elementActions.doClick(SignInPage_locator.createAnAccountButton);
		Assert.assertEquals("Create an account text is not displayed on register user details page",RegisterUserDetails_Variables.crateAnAccountText,elementActions.doGetText(RegisterUser_locator.CreateAnAccountText));
		System.out.println("create account text is display");
		elementActions.doClick(RegisterUser_locator.maleGenderRadioBtn);
		
		elementActions.doSendKey(RegisterUser_locator.userFirstName,RegisterUserDetails_Variables.userFirstName);

		elementActions.doSendKey(RegisterUser_locator.userLastName, RegisterUserDetails_Variables.userLastName);

		elementActions.doSendKey(RegisterUser_locator.userPassword, RegisterUserDetails_Variables.userPassword);

		elementActions.selectValueFromeDropDown(RegisterUser_locator.userBirthDay, RegisterUserDetails_Variables.BirthDay);

		elementActions.selectValueFromeDropDown(RegisterUser_locator.userBirthMonth, RegisterUserDetails_Variables.BirthMonth);

		elementActions.selectValueFromeDropDown(RegisterUser_locator.userBirthYear, RegisterUserDetails_Variables.BirthYear);
		
		if(RegisterUserDetails_Variables.IsSignUpForNewsLetter)
		{
			elementActions.doClick(RegisterUser_locator.signUpForNewsLetterCheckBox);
		}
		if (RegisterUserDetails_Variables.IsspecialOfferEmailRec) 
		{
			elementActions.doClick(RegisterUser_locator.specialOfferEmailRecCheckBox);
		}
		
		elementActions.doSendKey(RegisterUser_locator.AddressComanyNameTextBoxElement, RegisterUserDetails_Variables.AddressCompanyName);
		
		elementActions.doSendKey(RegisterUser_locator.AddressLine1TextBoxElement, RegisterUserDetails_Variables.AddressLine1);

		elementActions.doSendKey(RegisterUser_locator.AddressLine2TextBoxElement, RegisterUserDetails_Variables.AddressLine2);

		elementActions.doSendKey(RegisterUser_locator.AddressCityTextBoxElement, RegisterUserDetails_Variables.AddressCity);

		elementActions.selectByVisibleTextFromDropDown(RegisterUser_locator.AddressStateDropDownElement, RegisterUserDetails_Variables.AddressState);

		elementActions.doSendKey(RegisterUser_locator.AddressZipCodeTextBoxElement, RegisterUserDetails_Variables.AddressZipCode);

		elementActions.doSendKey(RegisterUser_locator.AddressAdditionalInfoTextBoxElement, RegisterUserDetails_Variables.AddressAdditionalInfo);
		
		elementActions.doSendKey(RegisterUser_locator.AddressMobilePhoneTextBoxElement, RegisterUserDetails_Variables.AddressMobilePhone);

		elementActions.doClick(RegisterUser_locator.registerFormButtonElement);
		
		elementActions.waitForElementVisible(AfterRegisterLocator.registeredUserNameDisplayElement);
		Assert.assertEquals("Registered User First Name And Last Name is not displayed correctly after registration", RegisterUserDetails_Variables.userFirstName + " " + RegisterUserDetails_Variables.userLastName,
				elementActions.doGetText(AfterRegisterLocator.registeredUserNameDisplayElement));
		
		System.out.println("Registered Successfully Name as -> " + RegisterUserDetails_Variables.userFirstName + " " + RegisterUserDetails_Variables.userLastName);
		
		System.out.println("register email test pass");
		
	}
	@Ignore
	@Test
	public void _09_SearchProduct()
	{
		//String Product = "Dress";
		int DressProductCount = 0;
		
		if(elementActions.doIsenable(LandinfPage_Locators.SearchBox))
		{
			elementActions.doSendKey(LandinfPage_Locators.SearchBox,Products_variables.productSearch);
		}
		
		List<WebElement> SearchList = elementActions.getElementsList(searchProduct_locator.AllProduct);
		for(int i=0; i<SearchList.size();i++)
		{
			//System.out.println((1+i)+ " : " + SearchList.get(i).getText());
			
			
			if(SearchList.get(i).getText().contains(Products_variables.productSearch))
			{
				System.out.println(SearchList.get(i).getText());
				DressProductCount++;
			}
		}
		System.out.println("Total Products Contains Dress : " + DressProductCount);
		Assert.assertEquals("Product count not match",String.valueOf(DressProductCount),Products_variables.TotalProductContainDress);
		System.out.println("Test Pass");
		
	}
	@Ignore
	@Test
	public void _10_ProductPriceAndTotal()
	{
		Assert.assertEquals("not in uppercase", Products_variables.ProductCat,elementActions.doGetText(searchProduct_locator.ProductCategore));
		System.out.println("In Uppercase");
		
		elementActions.doClick(searchProduct_locator.ProductCategore);
		List<WebElement> PriceOfAllDress = elementActions.getElementsList(searchProduct_locator.AllpriceofProducts);
		float x = 0f;
		for(int i = 0; i<PriceOfAllDress.size();i++)
		{
		
			System.out.println("All Product " + PriceOfAllDress.get(i).getText());
			x = x + Float.parseFloat(PriceOfAllDress.get(i).getText().substring(1)); 
			
		}
		
		System.out.println("Totoal price of Product is : " + x); 
		Assert.assertEquals("Total not match",String.valueOf(x),Products_variables.TotalPriceOfProducts);
		System.out.println("Test pass");
		
	}
	
	@Ignore
	@Test
	public void _11_login() 
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
	public void _12_ChangeColor() 
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
	@Ignore
	@Test
	public void _13_Socail_mediaFacebook()
	{
		elementActions.doClick(socail_media_icons_locator.FacebookIcon);
		elementActions.switchToWindowId(driver, 1);
		
		Assert.assertEquals("Page Name not match",social_icon_Variable.ExpectedFacebookPageName,elementActions.doGetText(socail_media_icons_locator.facebookPageName));
		System.out.println("Facebook Account Name match");
		driver.close();

		
	}
	@Ignore
	@Test
	public void _14_Socail_mediaTwitter()
	{
		elementActions.doClick(socail_media_icons_locator.TwitterIcon);
		elementActions.switchToWindowId(driver, 1);
		
		Assert.assertEquals("Page Name not match",social_icon_Variable.ExpectedTwitterPageName,elementActions.doGetText(socail_media_icons_locator.twitterPageName));
		System.out.println("Twitter Account Name match");
		driver.close();
		
	}
	@Ignore
	@Test
	public void _15_Socail_mediaYoutube()
	{
		elementActions.doClick(socail_media_icons_locator.YoutubeIcon);
		elementActions.switchToWindowId(driver, 1);
		
		Assert.assertEquals("Page Name not match",social_icon_Variable.ExpectedYoutubePageName,elementActions.doGetText(socail_media_icons_locator.YoutubePageName));
		System.out.println("Youtube Account Name match");
		driver.close();
		
	}
	@Ignore
	@Test
	public void _16_newsLetter()
	{
		elementActions.doSendKey(socail_media_icons_locator.NewsLetterInputtext,social_icon_Variable.NewLetterUserEmail);
		elementActions.doClick(socail_media_icons_locator.SubmitNewsLetterBtn);
		//System.out.println(elementActions.doGetText(socail_media_icons_locator.msg));
		Assert.assertEquals("Msg Not Match", social_icon_Variable.ExpectedNewsLetterMsg,elementActions.doGetText(socail_media_icons_locator.msg));
		System.out.println("Msg Match test pass");
	}
	
	
	
	@Ignore
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
		
//		boolean sucess = elementActions.doIsDisplayed(SelectProduct_Locators.ProductAddSuccess);
//		System.out.println("Product added successFully : "  +sucess);
		Assert.assertTrue(elementActions.doIsDisplayed(SelectProduct_Locators.ProductAddSuccess));
		System.out.println("Product added successFully: True");
		
		Assert.assertEquals("Quantity not match",Products_variables.PlusProduct,elementActions.doGetText(SelectProduct_Locators.productQuantity));
		Assert.assertEquals("Color Not Match", Products_variables.Color,elementActions.doGetText(SelectProduct_Locators.ProductColor).substring(0,6));
		System.out.println("Quantity and Color match");
		
		Assert.assertEquals("Total not match", Float.toString(total),elementActions.doGetText(SelectProduct_Locators.TotalPrice).substring(1));
	
		System.out.println("Price is Twice And Total Price Match-->32.02");
		
		elementActions.doClick(SelectProduct_Locators.CheckOutButton);
		//String ProudctNameInTheCart = elementActions.doGetText(SelectProduct_Locators.ProductInCart);
		
		
//		boolean CheckProductNameInCart = elementActions.doIsDisplayed(SelectProduct_Locators.ProductInCart);
//		System.out.println("Product Name is display : " + CheckProductNameInCart );
		Assert.assertTrue("not display", elementActions.doIsDisplayed(SelectProduct_Locators.ProductInCart));
		System.out.println("Product Name is display : True");
	
	}
	
	@Ignore
	@Test
	public void ValidateCartValueUpdating() throws InterruptedException 
	{ 	
		elementActions.doMoveToElement(AddToCartProductPageLocator.HoverToProduct);
		Thread.sleep(2000);
		elementActions.doClick(AddToCartProductPageLocator.ClickOnAddToCartBtn);
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(AddToCartProductPageLocator.ClickOnContinueShoppingBtn));
		elementActions.doClick(AddToCartProductPageLocator.ClickOnContinueShoppingBtn);
		Thread.sleep(2000);
		elementActions.doMoveToElement(AddToCartProductPageLocator.SecondProductOver);
		Thread.sleep(2000);
		elementActions.doClick(AddToCartProductPageLocator.SecondProductAddToCartBtn);
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(AddToCartProductPageLocator.ClickOnContinueShoppingBtn));
		elementActions.doClick(AddToCartProductPageLocator.ClickOnContinueShoppingBtn);
		Thread.sleep(2000);
		elementActions.doMoveToElement(AddToCartProductPageLocator.ThridProductOver);
		Thread.sleep(2000);
		elementActions.doClick(AddToCartProductPageLocator.ThridProductAddToCartBtn);
		Thread.sleep(2000);
		elementActions.doClick(AddToCartProductPageLocator.ClickOnContinueShoppingBtn);
		Thread.sleep(2000);
		
		Assert.assertEquals("Product Not mtach",AddProductsInCart_variables.ExpectedCartProduct,elementActions.doGetText(AddToCartProductPageLocator.ItemInCart));
		System.out.println("Product Match In Cart is -->3");
		
	}	
	@Ignore
	@Test
	public void ValidateSameProductInCart() throws InterruptedException 
	{
		ValidateCartValueUpdating();
		elementActions.doMoveToElement(AddToCartProductPageLocator.ItemInCart);
		Assert.assertEquals("Faded Short Sleeve T-shirts Not Add In Cart",AddProductsInCart_variables.FadedShortSleeveT_shirts,elementActions.getAttributeValue(AddToCartProductPageLocator.FirstProductInCart, "title"));
		System.out.println("Faded Short Sleeve T-shirts Add In Cart");
		Assert.assertEquals("Blouse Not Add In Cart",AddProductsInCart_variables.Blouse,elementActions.getAttributeValue(AddToCartProductPageLocator.SecondProductInCart, "title"));
		System.out.println("Blouse Add In Cart");
		Assert.assertEquals("Printed Chiffon Dress Not Add In Cart",AddProductsInCart_variables.PrintedChiffonDress,elementActions.getAttributeValue(AddToCartProductPageLocator.ThridProductInCart,"title"));
		System.out.println("Printed Chiffon Dress Add In Cart");
		
	}
	@Ignore
	@Test 
	public void ValidateProductTotal() throws InterruptedException 
	{
		
		ValidateCartValueUpdating();
//		Assert.assertEquals("Product Not mtach",AddProductsInCart_variables.ExpectedCartProduct,elementActions.doGetText(AddToCartProductPageLocator.ItemInCart));
//		System.out.println("Product Match In Cart is -->3");
		float x = 0;
		elementActions.doMoveToElement(AddToCartProductPageLocator.ItemInCart);
		List<WebElement> ListOfProduct = elementActions.getElementsList(AddToCartProductPageLocator.ListOfProductPriceInCart);
		for(int i = 0; i<ListOfProduct.size();i++)
		{
			System.out.println(ListOfProduct.get(i).getText().substring(1));
			x = x + Float.parseFloat(ListOfProduct.get(i).getText().substring(1));
		}
		
		
		x =  x +  Float.parseFloat(elementActions.doGetText(AddToCartProductPageLocator.ShippingPrice).substring(1));
		System.out.println(x);
		Assert.assertEquals("Total Not Match", AddProductsInCart_variables.TotalPriceInCartProduct,x,0.01);
		System.out.println("test pass");
	}
	@Ignore
	@Test
	public void RemoveProductFromCart() throws InterruptedException 
	{
		ValidateCartValueUpdating();
		elementActions.doMoveToElement(AddToCartProductPageLocator.ItemInCart);
		elementActions.doClick(AddToCartProductPageLocator.RemoveCrossBtn);
		Thread.sleep(3000);
		//String value = elementActions.doGetText(AddToCartProductPageLocator.ItemInCart);
		//System.out.println(value);
		Assert.assertEquals("Product Not mtach",AddProductsInCart_variables.ExpectedCartProductAfterRemoving,elementActions.doGetText(AddToCartProductPageLocator.ItemInCart));
		System.out.println("Affter removing One Product Match In Cart is -->2");
		
	}
	
	


	@After
	public void termdown() throws InterruptedException
	{
		
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	
	
	

}
