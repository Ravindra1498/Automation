package locators;

import org.openqa.selenium.By;

public class SelectProduct_Locators {
	
	public static By CategoryTshirtElement = By.xpath("//div[@id='block_top_menu']/ul/li/a[@title='T-shirts']");
	public static By ClickOnMoreOptionElementBtn = By.xpath("//a[@class='button lnk_view btn btn-default']/span[contains(text(),'More')]");
	public static By SendToFriendLinkElement = By.xpath("//a[@id='send_friend_button']");
	public static By ProductHoverMoreOption = By.xpath("//div[@class='product-container']");
	
	//for color selector
	public static By first_img = By.xpath("//div[@class='product-image-container']//img");
	public static By SelectProductColor = By.xpath("//a[@id='color_2']");
	public static By Second_img = By.xpath("//img[@id='bigpic']");
	
	//Product Price Locator
	public static By ProductPrice = By.xpath("//div[@class='content_price']/span[1]");
	
	public static By ClickOnProduct = By.xpath("//div[@class='right-block']/h5/a[@class='product-name']");
	public static By AddQuantityProduct = By.xpath("//p[@id='quantity_wanted_p']//input[@id='quantity_wanted']");
	
	public static By AddQuantity = By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']");
	public static By selectSize = By.xpath("//div[@class='selector']/select[@id='group_1']");
	
	public static By AddToCartButton = By.xpath("//button[@class='exclusive']/span"); 
	
	public static By ProductAddSuccess = By.xpath("//div[@id='layer_cart']");
	
	public static By productQuantity = By.xpath("//div[@class='layer_cart_product_info']/div/span[@id='layer_cart_product_quantity']");
	public static By ProductColor = By.xpath("//div[@class='layer_cart_product_info']/span[@id='layer_cart_product_attributes']");
	
	public static By TotalPrice = By.xpath("//div/span[@id='layer_cart_product_price']");
	
	public static By CheckOutButton = By.xpath("//div[@class='button-container']/a"); 
	
	public static By ProductInCart = By.xpath("//tbody//tr//td/p/a[text()='Faded Short Sleeve T-shirts']");
	
}
