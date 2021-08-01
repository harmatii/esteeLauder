package esteeLauder.example;

import org.testng.annotations.Test;

import base.Base;


public class TestExampleOne extends Base{

	@Test
	public void shouldAnswerWithTrue() throws InterruptedException {
		openBrowser();
		Thread.sleep(5000);
		driver.get("https://www.esteelauder.com/");
		Thread.sleep(5000);
		driver.quit();
	}
}
