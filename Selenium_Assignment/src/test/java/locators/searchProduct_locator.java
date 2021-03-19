package locators;

import org.openqa.selenium.By;

public class searchProduct_locator {
	
	public static By AllProduct = By.xpath("//div[@class='ac_results']//li");
	
	public static By ProductCategore = By.xpath("//div[@id='block_top_menu']/ul/li[2]/a");
	
	public static By AllpriceofProducts = By.xpath("//ul[@class='product_list grid row']//div[@class='right-block']//span[@class='price product-price']");

}
