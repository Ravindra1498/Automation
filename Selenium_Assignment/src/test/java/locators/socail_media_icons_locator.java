package locators;

import org.openqa.selenium.By;

public class socail_media_icons_locator {
	
	public static By FacebookIcon = By.xpath("//section[@id='social_block']/ul/li[@class='facebook']/a");
	public static By TwitterIcon = By.xpath("//section[@id='social_block']/ul/li[@class='twitter']/a");
	public static By YoutubeIcon = By.xpath("//section[@id='social_block']/ul/li[@class='youtube']/a");
	public static By NewsLetterInputtext =By.xpath("//div[@class='form-group']//input[@id='newsletter-input']");
	public static By SubmitNewsLetterBtn = By.xpath("//div[@class='form-group']//button[@name='submitNewsletter']");
	
	public static By msg = By.xpath("//p[@class='alert alert-success']");
	
	
	
	
	
	//After Click On Icone 
	
	public static By facebookPageName = By.xpath("//div[@class='bi6gxh9e aov4n071']/h2/span[text()='Selenium Framework']");
	public static By twitterPageName = By.xpath("//div[@class='css-1dbjc4n r-6gpygo r-14gqq1x']/div/div/div/div/span/span[text()='Selenium Framework']");
	public static By YoutubePageName = By.xpath("//div[@id='inner-header-container']/div//div/div");
	
	
	
	
	
	
	
	
}
