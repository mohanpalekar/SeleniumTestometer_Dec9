package action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick {
	


	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();

		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick";
		
		Actions action = new Actions(driver);

		driver.get(url);
		
		WebElement frame = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("iframeResult")));

		driver.switchTo().frame(frame);
		
		//WebElement drag = wait.until(ExpectedConditions.elementToBeClickable(By.id("drag1")));
		
		WebElement clickMe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Double-click me']")));
		
		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", clickMe);
		
		action.doubleClick(clickMe).build().perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
		
	}

}
