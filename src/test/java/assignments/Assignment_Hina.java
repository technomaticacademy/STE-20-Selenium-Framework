package assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Assignment_Hina {

	public static WebDriver driver;

	@Test
	public void hina() throws InterruptedException {
		// 1. Initialize the driver and launch application
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahim\\Desktop\\Mohammed\\Work\\Technomatic\\git\\Selenium_AutomationFramework_v1.0-main\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.progressive.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url); 
		driver.findElement(By.xpath("//li[@class='item purple big']")).click();

		driver.findElement(By.xpath("//input[@id='zipCode_overlay']")).sendKeys("10469");
		driver.findElement(By.xpath("//input[@id='qsButton_overlay']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'_FirstName')]")).sendKeys("usman");
		driver.findElement(By.xpath("//input[contains(@id,'MiddleInitial')]")).sendKeys("n");
		driver.findElement(By.xpath("//input[contains(@id,'LastName')]")).sendKeys("malik");

		Select suffix = new Select(driver.findElement(By.xpath("//select[contains(@id,'Suffix')]")));
		suffix.selectByVisibleText("Sr");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@name,'MailingAddress')]")).sendKeys("2400 Laconia Ave");
		driver.findElement(By.xpath("//input[contains(@name,'ApartmentUnit')]")).sendKeys("2");
		driver.findElement(By.xpath("//input[contains(@name,'City')]")).sendKeys("BRONX");


		driver.findElement(By.xpath("//input[contains(@name,'DateOfBirth')]")).sendKeys("10'27'1990");
		driver.findElement(By.xpath("//span[text()='P.O. Box/Military Address']")).click();
		driver.findElement(By.xpath("//div/forward-navigation/loading-button/button")).click();
		Select veichle = new Select(driver.findElement(By.xpath("//select[contains(@name,'list_Year')]")));
		veichle.selectByValue("2014");
		Thread.sleep(1000);
		Select make = new Select(driver.findElement(By.xpath("//select[contains(@name,'list_Make')]")));
		make.selectByValue("HONDA");
		Thread.sleep(1000);
		Select model = new Select(driver.findElement(By.xpath("//select[contains(@name,'list_Model')]")));
		model.selectByIndex(1);
		Thread.sleep(1000);
		Select body_type = new Select(driver.findElement(By.xpath("//select[contains(@id,'_BodyStyle')]")));
		body_type.selectByValue("2DR 4CYL");
		Thread.sleep(1000);

		Select use = new Select(driver.findElement(By.xpath("//select[contains(@id,'list_VehicleUse')]")));
		use.selectByIndex(2);


		Thread.sleep(1000);
		Select own_or_lease = new Select(driver.findElement(By.xpath("//select[contains(@id,'_OwnOrLease')]")));
		own_or_lease.selectByIndex(1);
		Thread.sleep(1000);
		Select duration = new Select(driver.findElement(By.xpath("//select[contains(@id,'_LengthOfOwnership')]")));
		duration.selectByValue("A");
		Thread.sleep(1000);
		Select Mileage = new Select(driver.findElement(By.xpath("//select[contains(@id,'_AnnualMileageForRate')]")));
		Mileage.selectByValue("12,000 - 13,999");
		Thread.sleep(1000);


		driver.findElement(By.xpath("//loading-button/button")).click();

		Thread.sleep(1000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement continue_button = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
		js.executeScript("arguments[0].click()", continue_button);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='DriversAddPniDetails_embedded_questions_list_Gender_F']")).click();
		Thread.sleep(1000);
		Select marriage_status = new Select(driver.findElement(By.xpath("//select[contains(@id,'ist_MaritalStatus')]")));
		marriage_status.selectByValue("S");

		driver.findElement(By.xpath("//input[contains(@id,'_SocialSecurityNumber')]")).sendKeys("2343457654");
		Thread.sleep(1000);
		Select primary_residence = new Select(driver.findElement(By.xpath("//select[contains(@id,'t_PrimaryResidence')]")));
		primary_residence.selectByValue("H");
		Thread.sleep(1000);
		Select LicenseType = new Select(driver.findElement(By.xpath("//select[contains(@id,'_LicenseType')]")));
		LicenseType.selectByValue("O");
		Thread.sleep(1000);
		Select licenseStatus = new Select(driver.findElement(By.xpath("//select[contains(@id,'_LicenseStatus')]")));
		licenseStatus.selectByValue("V");
		Thread.sleep(1000);
		Select licenseYear = new Select(driver.findElement(By.xpath("//select[contains(@id,'_DriverYearsLicensed')]")));
		licenseYear.selectByValue("3");

		driver.findElement(By.xpath("//fieldset[contains(@id,'_list_HasAccidentsOrClaim')]/div[2]/div")).click();
		driver.findElement(By.xpath("//input[contains(@id,'_HasTicketsOrViolations_N')]")).click();
		Thread.sleep(3000);
		WebElement continue_button2= driver.findElement(By.xpath("//button[text()='Continue']"));
		//js.executeScript("arguments[0].click()", continue_button2);
		continue_button2.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Thread.sleep(3000);
		Select move_in = new Select(driver.findElement(By.xpath("//select[contains(@name,'HasPriorAddress')]")));
		move_in.selectByValue("N");
		driver.findElement(By.xpath("//input[contains(@id,'list_InsuranceToday_N')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'InsuranceLastMonth_N')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'_OtherPolicies_N')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'	list_PrimaryEmailAddress')]")).sendKeys("usman@gmail.com");
		driver.findElement(By.xpath("//input[contains(@id,'_OtherPolicies_N')]")).click();
		Thread.sleep(1000);
		Select resident = new Select(driver.findElement(By.xpath("//select[contains(@id,'list_TotalResidents')]")));
		resident.selectByValue("3");

		WebElement continue_button3= driver.findElement(By.xpath("(//button[text()='Continue'])[1]"));
		js.executeScript("arguments[0].click()", continue_button3);

		driver.findElement(By.xpath("//input[contains(@id,'SnapshotPolicyEnrollment_N')]")).click();
	}

}
