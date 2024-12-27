package seleniumBasics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		String url = "https://www.booking.com/";

		driver.get(url);

		Thread.sleep(2000);

		driver.manage().window().maximize();

		//		Thread.sleep(2000);
		//		
		//		driver.manage().window().minimize();
		//		
		//		Thread.sleep(2000);
		//		
		//		Dimension dim = new Dimension(100, 200);
		//		
		//		driver.manage().window().setSize(dim);
		//		
		//		Thread.sleep(10000);

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getTitle());

		driver.quit();


	}

}
