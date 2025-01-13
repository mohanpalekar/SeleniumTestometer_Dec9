package logs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogsInSelenium {
	
	public static void main(String[] args) {
		
		Logger logger = LogManager.getLogger();
	
		logger.info("Creating webdriver session");
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		String url = "https://www.geeksforgeeks.org/logging-in-java/";
		
		driver.get(url);
		
		logger.warn("launched driver");
		
		driver.close();
		
		if(driver == null) {
			logger.info("Session closed");
		}else {
			logger.debug("Session in progress");
		}
		
	}

}
