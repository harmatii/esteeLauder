package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver = null;
	
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		driver = new ChromeDriver();
	}
}
