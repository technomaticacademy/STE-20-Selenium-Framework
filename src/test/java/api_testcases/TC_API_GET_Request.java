package api_testcases;

import java.io.Reader;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.API;
import pages.AutoPage;
import pages.HomePage;
import utils.Reporting;

import static io.restassured.RestAssured.given;

public class TC_API_GET_Request extends Base {

	public TC_API_GET_Request() {
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

			//Get the response
			Response response = given()
					.contentType(ContentType.JSON)
					.param("page", "2")
					.when()
					.get("/api/users/")
					.then()
					.extract().response();


			//Print the Status code
			reporting.report(Status.PASS, String.valueOf(response.getStatusCode()));

			//Get the response body details
			reporting.report(Status.PASS,response.getBody().asString());
			
			String page = response.jsonPath().getString("page");
			reporting.report(Status.PASS, "page = " + page);

			String per_page = response.jsonPath().getString("per_page");
			reporting.report(Status.PASS, "per_page = " + per_page);

			String total = response.jsonPath().getString("total");
			reporting.report(Status.PASS, "total = " + total);

			String total_pages = response.jsonPath().getString("total_pages");
			reporting.report(Status.PASS, "total_pages = " + total_pages);

			JsonPath jsonPathEvaluator = response.jsonPath();
			List<String> allemail = jsonPathEvaluator.getList("data.email");
			for(String email : allemail)
			{
				reporting.report(Status.PASS,email);
			}

		
		} catch (Exception e) {
			teardownexception(reporting, e);
		}
	}


}
