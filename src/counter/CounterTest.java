package counter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CounterTest {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://flutter-angular.web.app");
	}

	@AfterMethod
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	void clickingIncrementButtonIncreasesCount() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("flutter-view")));
		if (!driver.findElements(By.xpath("//button[@aria-label='Toggle sidenav']")).isEmpty()) {
			driver.findElement(By.xpath("//button[@aria-label='Toggle sidenav']")).click();
		}

		WebElement clicksInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-1")));
		clicksInput.clear();
		clicksInput.sendKeys(String.valueOf(5));
		clicksInput.sendKeys(Keys.TAB);

		String actual = clicksInput.getDomProperty("value");
		Assert.assertEquals(actual, String.valueOf(5));

	}

}
