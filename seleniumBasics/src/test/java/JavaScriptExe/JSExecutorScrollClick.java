package JavaScriptExe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutorScrollClick {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		//Initialize js executor
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		String url = "https://www.amazon.in/";

		driver.get(url);

		driver.manage().window().maximize();

		Thread.sleep(3000);
		
		WebElement cart = driver.findElement(By.id("nav-cart"));
		
		executor.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", cart);
		
		executor.executeScript("arguments[0].click();", cart);
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
