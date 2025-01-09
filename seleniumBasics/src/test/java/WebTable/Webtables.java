package WebTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtables {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();

		String url = "https://www.nyse.com/ipo-center/filings";

		driver.get(url);

		WebElement recentIPOs = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Recent IPOs']")));

		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", recentIPOs);
		
		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", recentIPOs);

		recentIPOs.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement last90Days = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='90']")));

		jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", last90Days);
		
		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", last90Days);

		last90Days.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> table = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@data-testid='largest-10']//tbody/tr")));
		
		System.out.println(table.size());
		
		////table[@data-testid='largest-10']//tbody/tr[1]/td[6]
		
		for(int i=1; i!=table.size(); i++) {
			
			WebElement row = driver.findElement(By.xpath("//table[@data-testid='largest-10']//tbody/tr["+i+"]/td[3]"));
			
			jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", row);
			
			jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", row);
			
			System.out.println(row.getText());
			
		}
		
		driver.close();
	}

}
