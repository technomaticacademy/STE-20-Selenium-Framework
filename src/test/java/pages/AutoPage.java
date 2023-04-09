package pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utils.Datatable;
import utils.GenericReusbales;
import utils.ObjectHandlers;
import utils.Reporting;

public class AutoPage extends GenericReusbales {
	String sheetName = this.getClass().getSimpleName();
	String environment;
	WebDriver driver;

	Datatable datatable;
	ObjectHandlers object;
	Reporting reporting;
	HashMap testcase;

	public AutoPage(HashMap testcase) {
		this.testcase = testcase;
		this.testcase.put("sheetName", sheetName);
		this.driver = (WebDriver) testcase.get("driver");
		this.environment = (String) testcase.get("environment");
		instantiate();
	}

	public void instantiate() {
		datatable = new Datatable(testcase);
		object = new ObjectHandlers(testcase);
		reporting = new Reporting(testcase);
	}



	public void enterZipCodeandProceed() throws Exception {
		String zipXpath = "//input[@id='zipCode_overlay']";
		String GetQuote = "//input[@id='qsButton_overlay']";
		
		object.set(By.xpath(zipXpath),"10001","Zip Code");
		object.click(By.xpath(GetQuote),"Get a Quote");
		
		if(object.isElementPresent(By.xpath(GetQuote))) {
			reporting.report(Status.PASS, "Get Quote button is present");
		} else
			reporting.report(Status.FAIL, "Get Quote button is not present");
		
		
		By TAB = By.xpath("//div[@role='tablist']");
		String[] TAB_NAME = null;
		int index=0;
		
		List<WebElement> lst_TAB = driver.findElements(TAB);
		
		for(WebElement ele:lst_TAB) {
			TAB_NAME[index] = ele.getText();
			index=index+1;
		}
		
	}
	

}
