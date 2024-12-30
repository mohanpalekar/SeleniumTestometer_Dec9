package JavaScriptExe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutorScrollAndHighLight {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		//Initialize js executor
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		String url = "https://www.amazon.in/";

		driver.get(url);

		driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement socialConnectText = driver.findElement(By.xpath("//div[text()='Connect with Us']"));

		WebElement cart = driver.findElement(By.id("nav-cart"));

		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", cart);

		Thread.sleep(3000);

		executor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", socialConnectText);

		Thread.sleep(2000);

		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", socialConnectText);

		Thread.sleep(3000);
		
		WebElement toys = driver.findElement(By.xpath("//h2[text()='Do up your home']"));
		
		executor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", toys);
		
		Thread.sleep(3000);
		
		executor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", toys);

		Thread.sleep(2000);
		
		driver.close();

	}

}
