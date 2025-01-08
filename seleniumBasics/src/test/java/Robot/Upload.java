
package Robot;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload {

	public static void main(String[] args) throws AWTException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();

		String url = "https://demoqa.com/automation-practice-form";

		driver.get(url);

		WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadPicture")));

		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", inputBox);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		inputBox.sendKeys("C:\\Users\\palek\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-10-22 085120.png");

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", inputBox);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		driver.close();


	}



}
