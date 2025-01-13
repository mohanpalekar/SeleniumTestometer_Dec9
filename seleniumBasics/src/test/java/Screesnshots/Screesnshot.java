package Screesnshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screesnshot {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();

		String url = "https://www.google.co.in/";

		driver.get(url);

		WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", searchBox);

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", searchBox);

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File file = screenshot.getScreenshotAs(OutputType.FILE);

		File desitnationFile = new File(".//target//file_"+System.currentTimeMillis()+".png");

		FileUtils.copyFile(file, desitnationFile);
		
		searchBox.sendKeys("Amazon"+Keys.ENTER);
		
		file = screenshot.getScreenshotAs(OutputType.FILE);
		
		desitnationFile = new File(".//target//file_"+System.currentTimeMillis()+".png");
		
		FileUtils.copyFile(file, desitnationFile);

		driver.close();

	}

}
