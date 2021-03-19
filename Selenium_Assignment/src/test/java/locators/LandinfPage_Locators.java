package locators;

import org.openqa.selenium.By;

public class LandinfPage_Locators {

	
	public static By SignInButtonElement = By.xpath("//div/a[contains(text(),'Sign in')]");
	
	//for second test 
	public static By ProductCategorie = By.xpath("//div[@id='block_top_menu']/ul/li/a[@title='T-shirts']");
	
	public static By ProductCatList = By.xpath("//div[@id='block_top_menu']/ul/li/a");
	public static By Landing_page_logo = By.xpath("//img[@class='logo img-responsive']");
	
	public static By logoHeight = By.xpath("//img[@class='logo img-responsive']"); 
	public static By logoWidth = By.xpath("//img[@class='logo img-responsive']"); 
	
	//search product
	public static By SearchBox = By.id("search_query_top");
	
	//--------------firfox------------//
	public static By HoverFirstProduct = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/h5/a");
	public static By FirstProductclickOnAddtoCart = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/div[2]/a[1]");
	
}
