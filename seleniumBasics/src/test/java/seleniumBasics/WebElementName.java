package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementName {

	public static void main(String[] args) throws InterruptedException {

		// Setup a chrome driver
		WebDriverManager.chromedriver().setup();

		// Initialize a driver
		WebDriver driver = new ChromeDriver();

		// url
		String url = "https://www.google.co.in/";

		// Launch the browser
		driver.get(url);

		// maximize the browser window
		driver.manage().window().maximize();

		// print page title
		System.out.println(driver.getTitle());

		// wait for 2 seconds
		Thread.sleep(2000);

		//Webelement - input box
		//WebElement inputBox = driver.findElement(By.name("q"));
		WebElement inputBox = driver.findElement(By.xpath("//textarea[@name='q']"));

		inputBox.sendKeys("Text to search");
		
		//WebElement - submit button
		WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
		
		submitButton.click();

		// wait for 2 seconds
		Thread.sleep(6000);

		// close the browser
		driver.close();

	}

}
