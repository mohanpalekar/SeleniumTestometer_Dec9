package asserts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertsInSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		//Initialize js executor
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		String url = "https://www.flipkart.com/";

		driver.get(url);

		driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement loinButton = driver.findElement(By.xpath("//a[@title='Login']"));

		executor.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", loinButton);

		String loginText = loinButton.getText();

		if(loginText.equals("Login")) {
			System.out.println("Correct");
		}else System.out.println("Incorrect");

		Assert.assertEquals(" Test Message", loginText, "Login");

		Thread.sleep(3000);

		//Assert.assertFalse(loginText.equals("Login123"));

		Assert.fail();

		driver.close();

	}

}
