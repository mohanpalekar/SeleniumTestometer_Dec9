package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFirstProgram {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.iedriver().setup();
		
		WebDriver driver = new InternetExplorerDriver();
		
		String url = "https://www.google.co.in/";
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.close();
		
	}

}
