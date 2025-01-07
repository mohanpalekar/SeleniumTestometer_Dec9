package checkbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckHobbies {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.manage().window().maximize();
		
		String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox";
		
		driver.get(url);
		
		//WebElement frame = driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame("iframeResult");
		
		WebElement hobbies1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("vehicle1")));
		
		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", hobbies1);
		
		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", hobbies1);
		
		System.out.println(hobbies1.isSelected());
		
		hobbies1.click();
		
		System.out.println(hobbies1.isSelected());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		
	}

}
