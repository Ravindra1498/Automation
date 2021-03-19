package locators;

import org.openqa.selenium.By;

public class AddToCartProductPageLocator {
	
	 
	
	public static By HoverToProduct = By.xpath("//div[@class='product-container']");
	
	public static By ClickOnAddToCartBtn = By.xpath("//div[@class='button-container']//a[@data-id-product='1']");
	
	public static By ClickOnCrossBtn = By.xpath("//div[@class='clearfix']//span[@class='cross']");
	public static By ItemInCart = By.xpath("//div[@class='shopping_cart']//span[@class='ajax_cart_quantity unvisible']");
	public static By ClickOnContinueShoppingBtn = By.xpath("//div[@class='clearfix']//div[@class='button-container']//span/span");
	
	public static By SecondProductOver = By.xpath("//div[@class='product-container']//div[@class='right-block']//a[@title='Blouse'][1]");
	public static By SecondProductAddToCartBtn = By.xpath("//div[@class='button-container']//a[@data-id-product='2']");
	
	public static By ThridProductOver = By.xpath("//div[@class='product-container']//div[@class='right-block']//a[@title='Printed Chiffon Dress'][1]");
	public static By ThridProductAddToCartBtn = By.xpath("//div[@class='button-container']//a[@data-id-product='7']");
	
	
	//----------Product In Cart-------//
	
	public static By FirstProductInCart = By.xpath("//div[@class='product-name']//a[@title='Faded Short Sleeve T-shirts']");
	public static By SecondProductInCart = By.xpath("//div[@class='product-name']//a[@title='Blouse']");
	public static By ThridProductInCart = By.xpath("//div[@class='product-name']//a[@title='Printed Chiffon Dress']");
	
	//------List Of Product Price locator-----//
	
	public static By ListOfProductPriceInCart = By.xpath("//div[@class='cart_block_list']//div/span[@class='price']");
	
	
	//---------Shipping Price locator-//
	
	public static By ShippingPrice = By.xpath("//div[@class='cart-prices']//div/span");
	
	//------remove cross btn-//
	public static By RemoveCrossBtn = By.xpath("//div[@class='cart_block_list']//span[@class='remove_link']/a");
	
	//-----------After Removing Product-----//
	public static By AfterRemovingProductCart = By.xpath("//div[@class='shopping_cart']//a//span[@class='ajax_cart_quantity']");
	
	
}
