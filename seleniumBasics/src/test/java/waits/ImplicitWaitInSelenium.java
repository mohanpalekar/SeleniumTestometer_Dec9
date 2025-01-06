package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitInSelenium {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		String url = "https://www.booking.com/";
		
		driver.get(url);
		
		WebElement popUp = driver.findElement(By.xpath("//button[starts-with(@aria-label,'Dismiss')]"));
		
		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", popUp);

		popUp.click();
		
		driver.close();	
		
	}

}
