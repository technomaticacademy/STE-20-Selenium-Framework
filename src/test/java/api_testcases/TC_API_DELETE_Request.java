package api_testcases;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import core.Base;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.AutoPage;
import pages.HomePage;
import utils.Reporting;

import static io.restassured.RestAssured.given;

public class TC_API_DELETE_Request extends Base {

	public TC_API_DELETE_Request() {
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
			reporting = new Reporting(testcase);

			//Set the base URI
			RestAssured.baseURI = "https://reqres.in";

			//Delete
			Response response = given()
					.header("Content-type", "application/json")
					.when()
					.delete("/users/8")
					.then()
					.extract().response();


			//Print the Status code
			reporting.report(Status.PASS, String.valueOf(response.getStatusCode()));

			
			
		} catch (Exception e) {
			teardownexception(reporting, e);
		}
	}


}