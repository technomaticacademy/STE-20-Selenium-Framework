package pages;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import utils.Datatable;
import utils.GenericReusbales;
import utils.ObjectHandlers;
import utils.Reporting;

public class BuzzPage extends GenericReusbales {
	String sheetName = this.getClass().getSimpleName();
	String environment;
	WebDriver driver;

	Datatable datatable;
	ObjectHandlers object;
	Reporting reporting;
	HashMap testcase;

	public BuzzPage(HashMap testcase) {
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
	
	//Locators
	By EDIT_POST = By.xpath("//textarea[contains(@placeholder,' on your mind?')]");
	By POST = By.xpath("//button[@type='submit']");
	
	public void writePost() throws Exception {
		String ip_Post = datatable.getCellData("WritePost");
		
		object.set(EDIT_POST, ip_Post, "Post Editbox");
		
		object.click(POST, "Post button");
		
		reporting.report(Status.PASS, "Created a new post");
		
	}
	
	

}
