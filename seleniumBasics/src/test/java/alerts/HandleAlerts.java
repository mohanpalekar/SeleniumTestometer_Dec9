package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://demo.guru99.com/test/delete_customer.php";

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		driver.get(url);

		driver.manage().window().maximize();

		Thread.sleep(3000);

		WebElement customerIdInputField = driver.findElement(By.name("cusid"));

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", customerIdInputField);

		customerIdInputField.sendKeys("Cust1234");

		Thread.sleep(3000);

		WebElement submitButton = driver.findElement(By.name("submit"));

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", submitButton);

		submitButton.click();
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		
		//alert.dismiss();
		
		System.out.println(alert.getText());
		
		alert.accept();
		
		Thread.sleep(3000);
		
		System.out.println(alert.getText());
		
		alert.accept();
		
		Thread.sleep(3000);

		driver.quit();
	}

}
