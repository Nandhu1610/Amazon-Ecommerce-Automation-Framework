package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void browserLaunch(String nameOfBrowser) //@Optional("chrome")
	{
		if (nameOfBrowser.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
			driver = new ChromeDriver(option);
		}
		if (nameOfBrowser.equalsIgnoreCase("firefox")) 
		{
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("start-maximized");
			driver = new FirefoxDriver(option);
		}
		if (nameOfBrowser.equalsIgnoreCase("edge")) 
		{
			EdgeOptions option = new EdgeOptions();
			option.addArguments("start-maximized");
			driver = new EdgeDriver(option);
		}
		driver.get("https://www.amazon.in/");
	}

	@AfterMethod
	public void browserQuit() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
