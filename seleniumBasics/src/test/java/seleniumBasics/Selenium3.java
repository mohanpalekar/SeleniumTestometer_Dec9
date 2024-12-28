package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium3 {

	public static void main(String[] args) throws InterruptedException {

		// Setup a chrome driver
		WebDriverManager.chromedriver().setup();

		// Initialize a driver
		WebDriver driver = new ChromeDriver();

		// url
		String url = "https://www.booking.com/";

		// Launch the browser
		driver.get(url);

		// maximize the browser window
		driver.manage().window().maximize();

		// print page title
		System.out.println(driver.getTitle());

		// wait for 2 seconds
		Thread.sleep(2000);

		//Webelement - Sing In
		//WebElement signIn = driver.findElement(By.xpath("//a[@aria-label='Sign in']"));

		WebElement search = driver.findElement(By.id(":rh:"));

		search.sendKeys("Manali");

		// wait for 2 seconds
		Thread.sleep(6000);

		//signIn.click();

		// close the browser
		driver.close();

	}

}
