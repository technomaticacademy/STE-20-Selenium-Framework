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

public class LoginPage extends GenericReusbales {
	String sheetName = this.getClass().getSimpleName();
	String environment;
	WebDriver driver;

	Datatable datatable;
	ObjectHandlers object;
	Reporting reporting;
	HashMap testcase;

	public LoginPage(HashMap testcase) {
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
	By USERNAME = By.xpath("//input[@name='username']");
	By PASSWORD = By.xpath("//input[@name='password']");
	By LOGIN = By.xpath("//button[@type='submit']");


	
	public void login() throws Exception {
		
		String ip_username = datatable.getCellData("Username");
		String ip_password = datatable.getCellData("Password");
		
		//Enter user name
		object.set(USERNAME,ip_username, "Username");
		
		//Enter password
		object.set(PASSWORD, ip_password, "Password");
		
		//Click on login
		object.click(LOGIN, "Login");
		
		reporting.report(Status.PASS, "Login to the applciation is successfull");
		
	}
	
	
	

}
