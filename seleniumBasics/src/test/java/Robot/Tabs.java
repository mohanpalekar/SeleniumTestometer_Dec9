package Robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tabs {

	public static void main(String[] args) throws AWTException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();

		String url = "https://www.guvi.in/blog/robot-class-in-selenium-webdriver/";

		driver.get(url);

		WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));

		Robot robot = new Robot();

		inputBox.sendKeys("Test");

		robot.keyPress(KeyEvent.VK_TAB);


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		robot.keyPress(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
		
		//C:\Users\palek\OneDrive\Pictures\Screenshots\Screenshot 2024-10-22 085120.png



	}

}
