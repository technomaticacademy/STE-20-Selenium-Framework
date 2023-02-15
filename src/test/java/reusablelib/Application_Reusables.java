package reusablelib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Application_Reusables {
	
	public static WebDriver driver;
	
	Object_Reusables obj = new Object_Reusables(driver);

	public void launchapplication() {
		// 1. Initialize the driver and launch application
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahim\\Desktop\\Mohammed\\Work\\Technomatic\\git\\Selenium_AutomationFramework_v1.0-main\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.progressive.com/");
		driver.manage().window().maximize();
	}
	
	public void clickAuto() {
		obj.click(By.xpath("//p/span[text()='Auto']"),"Auto");
	}

	
	public void enterZipcode() {
		obj.sendKeys(By.xpath("(//input[contains(@id,'zipCode_overlay')])[1]"),"10001","Zip code");
		obj.click(By.xpath("(//input[contains(@id,'qsButton_overlay')])[1]"),"Get a quote");
	}
	
	public void insuredDetails() {
		obj.sendKeys(By.xpath("//input[contains(@id,'_FirstName')]"),"Mohammed","First name");
		obj.sendKeys(By.xpath("//input[contains(@id,'_LastName')]"),"MM","Last Name");

		new Select(driver.findElement(By.xpath("(//select[contains(@id,'_Suffix')])"))).selectByVisibleText("Jr");
		System.out.println("Entering the suffix");
		
		obj.sendKeys(By.xpath("//input[contains(@id,'_MailingAddress')]"),"Lane 123","Mailing Address");
		obj.sendKeys(By.xpath("//input[contains(@id,'_DateOfBirth')]"),"10/10/1980","DOB");
		obj.click(By.xpath("//button[contains(text(),'Okay, start my quote.')]"), "Start Quote");

	}
	
	public void closeBrowser() {
		driver.close();
		driver.quit();
		System.out.println("Browser closed");
	}
}
