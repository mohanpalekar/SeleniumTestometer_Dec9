package findElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) throws InterruptedException {

		String url = "https://booking.com";

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		driver.get(url);

		driver.manage().window().maximize();

		Thread.sleep(5000);

		try {

			WebElement popUp = driver.findElement(By.xpath("//button[starts-with(@aria-label,'Dismiss')]"));

			Thread.sleep(1000);

			jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", popUp);

			popUp.click();

		}catch(NoSuchElementException ex) {
			System.out.println("NoSuchElementException occurred");
		}finally {

			Thread.sleep(1000);

		}

		List<WebElement> list= driver.findElements(By.tagName("a"));

		System.out.println(list.size());



		for(WebElement element : list) {

			String linkUrl = element.getDomAttribute("href");

			if(linkUrl.startsWith("https://www.booking.com/hotel")) {
				System.out.println(linkUrl);
			}

		}

		Thread.sleep(2000);

		driver.close();

	}
}
