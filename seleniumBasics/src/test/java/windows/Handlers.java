package windows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handlers {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		driver.manage().window().maximize();

		String url = "https://demoqa.com/browser-windows";

		driver.get(url);

		//Open First Window

		Thread.sleep(1000);

		WebElement scrollToThis = driver.findElement(By.xpath("//span[text()='Modal Dialogs']"));

		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", scrollToThis);

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", scrollToThis);

		Thread.sleep(3000);

		WebElement newTabButton = driver.findElement(By.id("tabButton"));

		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", newTabButton);

		Thread.sleep(1000);

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", newTabButton);

		Thread.sleep(2000);

		newTabButton.click();

		//Open Second Window

		Thread.sleep(3000);

		WebElement newTabButton1 = driver.findElement(By.id("windowButton"));

		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", newTabButton1);

		Thread.sleep(1000);

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", newTabButton1);

		Thread.sleep(2000);

		newTabButton1.click();

		//Open Third Window

		Thread.sleep(3000);

		WebElement newTabButton2 = driver.findElement(By.id("messageWindowButton"));

		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", newTabButton2);

		Thread.sleep(1000);

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", newTabButton2);

		Thread.sleep(2000);

		newTabButton2.click();

		String parentHandle = driver.getWindowHandle(); //AB

		Set<String> handles = driver.getWindowHandles(); //Ab, CD

		System.out.println("Parent handle: "+parentHandle);

		System.out.println(handles);

		for(String handle : handles) {

			if(parentHandle.equals(handle)) {

				System.out.println("Skipping this window : "+handle);

			}else {

				driver.switchTo().window(handle);

				System.out.println("Switched to : "+handle);

				Thread.sleep(2000);

				WebElement heading = null;

				try{

					heading = driver.findElement(By.id("sampleHeading"));

				}catch(Exception ex) {

					System.out.println(ex.getMessage());

					heading = driver.findElement(By.xpath("//body[contains(text(),'Knowledge increases')]"));
				}

				jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", heading);

				Thread.sleep(1000);

				jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", heading);

				heading.click();

				System.out.println(heading.getText());

				driver.close();
			}

		}

		driver.switchTo().window(parentHandle);

		driver.close();

	}

}
