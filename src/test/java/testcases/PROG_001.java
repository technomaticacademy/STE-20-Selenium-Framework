package testcases;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import reusablelib.Application_Reusables;

public class PROG_001 {

	@Test
	public static void tc001() {
		
		Application_Reusables app = new Application_Reusables();
		
		// 1. Initialize the driver and launch application
		app.launchapplication();
		
		// 2. Select Auto quote
		app.clickAuto();
		
		// 3. Enter Zip code
		app.enterZipcode();
		
		// 4. Enter Insured information
		app.insuredDetails();
		
		// 5. Close the browser
		app.closeBrowser();
	
	
	}

}
