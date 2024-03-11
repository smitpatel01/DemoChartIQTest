package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class chartIQTestJava {
	static String searchButton = "//cq-toggle[@reader='Symbol Search']";
	static String enterValue = "//label[@id='lookup_dialog_input_label']/following-sibling::input";
	static String symbolLookup ="//h4[@id='cq-lookup-dialog-title']";
	static String selectAAPL= "//span[text()='AAPL']/parent::*";
	static String stockAAPL= "//cq-symbol[@class='hide-outline']";
	static String submitButton ="//button[@type='submit']";
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.chartiq.com/");
		driver.manage().window().maximize();
/** basic assertion and steps to check end 2 end flow of symbol lookup functionality
 * We can use screenshots and report functionality of test NG for better logs and error handling
 **/
		driver.findElement(By.xpath(searchButton)).click();
		String popUpwindowtitle = driver.findElement(By.xpath(symbolLookup)).getText();
		driver.findElement(By.xpath(enterValue)).sendKeys("AAPL");
		Assert.assertEquals(popUpwindowtitle,"Symbol Lookup");
		driver.findElement(By.xpath(submitButton)).click();
		String stockName = driver.findElement(By.xpath(stockAAPL)).getText();
		Assert.assertEquals(stockName, "AAPL");
		driver.close();
		driver.quit();
		System.out.println("Test is successfully executed");	
	}
}
 