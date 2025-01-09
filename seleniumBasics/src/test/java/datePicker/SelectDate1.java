package datePicker;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDate1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();

		String url = "https://www.makemytrip.com/";

		driver.get(url);

		WebElement signUpPopUp = wait.until(ExpectedConditions.elementToBeClickable(By.className("commonModal__close")));

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", signUpPopUp);

		signUpPopUp.click();

		WebElement departure = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='departure']")));

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", departure);

		departure.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Map<String, Integer> month = new HashMap<>();

		month.put("Jan", 1);
		month.put("Feb", 2);
		month.put("Mar", 3);
		month.put("Apr", 4);
		month.put("May", 5);
		month.put("Jun", 6);
		month.put("Jul", 7);
		month.put("Aug", 8);
		month.put("Sep", 9);
		month.put("Oct", 10);
		month.put("Nov", 11);
		month.put("Dec", 12);

		List<WebElement> months = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='DayPicker-Month']/div[@role='heading']/div")));

		WebElement nextMonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@aria-label='Next Month']")));

		String monthTobeSelectd = "Nov";

		System.out.println(month.get(monthTobeSelectd));

		System.out.println(months.get(0).getText().substring(0, 3));

		while( month.get(monthTobeSelectd) != month.get(months.get(0).getText().substring(0, 3)) ) {

			jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", nextMonth);

			nextMonth.click();

		}

		WebElement dateToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Sat Nov 08 2025']")));

		jse.executeScript("arguments[0].setAttribute('style', 'border: 4px solid green;');", dateToSelect);

		dateToSelect.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		driver.close();


	}

}
