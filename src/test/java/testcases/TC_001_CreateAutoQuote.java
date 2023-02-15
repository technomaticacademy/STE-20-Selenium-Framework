package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import core.Base;
import pages.AutoPage;
import pages.HomePage;
import utils.Reporting;

public class TC_001_CreateAutoQuote extends Base {

	public TC_001_CreateAutoQuote() {
		testcasename = this.getClass().getSimpleName();
		testcase.put("testcasename", testcasename);
		description = "To check the sample functionality of the application";
	}

	HomePage homepage;
	Reporting reporting;
	AutoPage auto;

	@Test
	public void testcase() {
		try {
			homepage = new HomePage(testcase);
			reporting = new Reporting(testcase);
			auto = new AutoPage(testcase);

			//Launch the URL
			homepage.launchApp();
			
			//createAutoQuote();
			
			//click on auto
			homepage.clickAuto();
		
			//Enter Zip code and click on Get Quote
			auto.enterZipCodeandProceed();
			
			//Fill the personal info
			
			
			//Fill the vehicle info
			
			
			
			homepage.closeApp();

		} catch (Exception e) {
			teardownexception(reporting, e);
		}
	}
	
	
	public void createAutoQuote() throws InterruptedException {
		String AutoXPath = "(//span[text()='Auto'])[1]";
		String ZipXPath = "//*[@id='zipCode_overlay']";
		String GetaQuote = "//input[@id='qsButton_overlay']";
		String FirstNameXPath = "//input[@aria-label='First Name']";
		String LastNameXPath = "//input[@aria-label='Last Name']";
		
		driver.findElement(By.xpath(AutoXPath)).click();
		
		driver.findElement(By.xpath(ZipXPath)).sendKeys("10001");
		
		System.out.println(driver.findElement(By.xpath(ZipXPath)).getAttribute("size"));
		
		System.out.println(driver.findElement(By.xpath(ZipXPath)).getAttribute("type"));
		
		System.out.println(driver.findElement(By.xpath(ZipXPath)).getAttribute("autocomplete"));
		
		System.out.println(driver.findElement(By.xpath(ZipXPath)).getTagName());
		
		System.out.println(driver.findElement(By.xpath(GetaQuote)).isEnabled());
				
		driver.findElement(By.xpath(GetaQuote)).click();
		
		//Thread.sleep(10000); // Not Recommended
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FirstNameXPath)));
		
		driver.findElement(By.xpath(FirstNameXPath)).sendKeys("Mohammed");
		
		
		
		//Fluent Wait
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
			.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LastNameXPath)));

		
		driver.findElement(By.xpath(LastNameXPath)).sendKeys("M");
		
		driver.findElement(By.xpath(FirstNameXPath)).clear();
		
		driver.findElement(By.xpath(LastNameXPath)).getText();
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
}
