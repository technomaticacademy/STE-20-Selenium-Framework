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

public class TC_API_POST_Request extends Base {

	public TC_API_POST_Request() {
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

			//Request Payload
			String requestBody = "{\n" +
					"  \"name\": \"mohammed\",\n" +
					"  \"job\": \"test lead\"\n}" ;

			//POST(Create) the request
			Response response = given()
					.header("Content-type", "application/json")
					.and()
					.body(requestBody)
					.when()
					.post("/api/users")
					.then()
					.extract().response();


			//Print the Status code
			reporting.report(Status.PASS, String.valueOf(response.getStatusCode()));

			//Get the response body details
			reporting.report(Status.PASS,response.getBody().asString());
			
			String name = response.jsonPath().getString("name");
			reporting.report(Status.PASS, "name = " + name);
			
			String job = response.jsonPath().getString("job");
			reporting.report(Status.PASS, "job = " + job);
			
			String id = response.jsonPath().getString("id");
			reporting.report(Status.PASS, "id = " + id);
			
			String createdAt = response.jsonPath().getString("createdAt");
			reporting.report(Status.PASS, "createdAt = " + createdAt);

			
		} catch (Exception e) {
			teardownexception(reporting, e);
		}
	}


}
