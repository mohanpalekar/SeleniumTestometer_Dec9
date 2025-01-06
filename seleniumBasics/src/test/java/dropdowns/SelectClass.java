package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		String url = "https://demo.guru99.com/test/newtours/register.php";
		
		driver.get(url);
		
		WebElement dropDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("country")));
		
		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", dropDown);	
		
		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", dropDown);		
		
		//dropDown.click();
		Select select = new Select(dropDown);
		
		//select.selectByIndex(6);
		//select.selectByVisibleText("BHUTAN");
		select.selectByValue("AUSTRIA");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();	

	}

}
