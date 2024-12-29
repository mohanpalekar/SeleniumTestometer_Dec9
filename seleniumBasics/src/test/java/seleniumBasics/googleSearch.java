package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearch {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		String url = "https://www.google.co.in/";
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		WebElement googleSearchBox = driver.findElement(By.name("q"));
		
		googleSearchBox.sendKeys("Booking.com");
		
		googleSearchBox.sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		WebElement siteLink = driver.findElement(By.xpath("//h3[contains(text(),'Official site')]"));
		
		siteLink.click();
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
