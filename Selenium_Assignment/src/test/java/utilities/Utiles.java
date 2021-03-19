package utilities;

import java.io.FileInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

public class Utiles {


	public WebDriver driver;
	public Properties prop;
	//-----------Initialization of Properties file--------

	public Properties init_prop() 
	{
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/config.properties");
			prop.load(file);
		}
		catch (FileNotFoundException e) {

			System.out.println("config.properties file not found");
			e.printStackTrace();;
		}
		catch(IOException e)
		{
			System.out.println("IOException occured");
		}

		return prop;
	}

	//-----------Initialization for WebDriver and Browser configuration
	public WebDriver init_driver(Properties prop)
	{
		String BrowserName = prop.getProperty("browser");
		
		System.out.println("Running on-->" + BrowserName + "browser" + ", " + System.getProperty("os.name") + ", " + System.getProperty("os.arch") + ", " + System.getProperty("os.version")+ ", Java Version: " 
		+ System.getProperty("java.version"));
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			if(prop.getProperty("headless").equalsIgnoreCase("yes"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			}
			else 
			{
				driver = new ChromeDriver();
			}
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
		{	
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
			 WebDriverManager.chromedriver().setup();
			if(prop.getProperty("headless").equalsIgnoreCase("yes"))
			{
				FirefoxOptions fb = new FirefoxOptions();
				fb.addArguments("--headless");
				driver = new FirefoxDriver(fb);
			}
			else 
			{
				driver = new FirefoxDriver();
			}		
		}
		
		else if(BrowserName.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/operadriver.exe");
			driver = new OperaDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		if(prop.getProperty("maximize").equalsIgnoreCase("yes"))
			
		{
			driver.manage().window().maximize();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("ImplicitWait")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("PageLoadTimeout")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}







