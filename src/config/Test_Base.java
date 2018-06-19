package config;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test_Base {
	protected WebDriver driver = null;
	
	public void configureBrowser(){
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vineet\\workspace\\relayrTest\\drivers\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--lang=en");
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	
	}
	
	public void navigateToHomePage(){
		driver.navigate().to("https://www.google.de/?hl=en");
	}
	
	public void refreshPage()
	{
		driver.navigate().refresh();
	}
	
		
	public void implicitWait(int seconds)
	{
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
}
