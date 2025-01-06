package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		String url = "https://www.booking.com/";

		driver.get(url);
		
		WebElement popUp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[starts-with(@aria-label,'Dismiss')]")));

		//WebElement popUp = driver.findElement(By.xpath("//button[starts-with(@aria-label,'Dismiss')]"));

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", popUp);

		popUp.click();
		
		WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register")));
		
		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", registerButton);
		
		registerButton.click();

		driver.close();	

	}
	
}
