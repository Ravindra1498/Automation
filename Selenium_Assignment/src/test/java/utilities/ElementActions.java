package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ElementActions {
	
	WebDriver driver;
	Properties prop;
	Utiles utiles;
	Actions action;
	JavaScriptUtil javascriptutil;
	WebDriverWait wait;

		
	public ElementActions(WebDriver driver) {
		this.driver = driver;
		utiles = new Utiles();
		prop = utiles.init_prop();
		wait = new WebDriverWait(this.driver, Integer.parseInt(prop.getProperty("WebDriverWaitTimeout")));
		action = new Actions(this.driver);
		javascriptutil = new JavaScriptUtil(driver);
	}
	
	
	public List<WebElement> getElementsList(By locator) 
	{
		List<WebElement> element = null;
		element = driver.findElements(locator);
		return element;
	}
	
	public WebElement getElement(By locator)
	{
		
		WebElement element = driver.findElement(locator);
			
		return element;
	}
	
	//for click on element
	public void doClick(By locator)
	{
		getElement(locator).click();
	}
	
	public void doSendKey(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}
	public void doclear(By locator)
	{
		getElement(locator).clear();
	}
	
	public String doGetText(By locator)
	{
		String text = null;
		text = getElement(locator).getText();
		return text;
	}
	
	
	public void doMoveToElement(By locator)
	{
		action.moveToElement(getElement(locator)).build().perform();
	}
	
	//for getting arrtibute values
	public String getAttributeValue(By locator, String AttributeName)
	{
		WebElement attributeValue = driver.findElement(locator);
		return attributeValue.getAttribute(AttributeName);
	}
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void selectValueFromeDropDown(By locator, String value)
	{
		Select selectElement = new Select(getElement(locator));
		selectElement.selectByVisibleText(value);
	}
	
	public boolean doIsDisplayed(By locator) {
		boolean flag = false;
		flag = getElement(locator).isDisplayed();
		return flag;
	}

	public void waitForElementVisible(By locator) {
		WebElement ele = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public String doGetcurrentURL() {
		String text = null;
		text = driver.getCurrentUrl();
		return text;
	}
	
	public String doGetPageTitle() 
	{ 
		return driver.getTitle();
	}
	
	public void selectByVisibleTextFromDropDown(By locator, String Value)
	{
		Select selectElement = new Select(getElement(locator));
		selectElement.selectByVisibleText(Value);
		
	}
	
	public boolean doIsenable(By locator) {
		boolean flag = false;
		flag = getElement(locator).isEnabled();
		return flag;
	}
	
	public List<String> getWindowList(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		return windowHandlesList;
	}
	
	public void switchToWindowId(WebDriver driver, int windowNumber)
	{
		List<String> windowList = getWindowList(driver);
		driver.switchTo().window(windowList.get(windowNumber));
	}
	
	
	
	
	
}













