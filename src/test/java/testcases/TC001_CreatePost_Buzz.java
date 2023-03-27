package testcases;

import org.testng.annotations.Test;

import core.Base;
import pages.BuzzPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Reporting;

public class TC001_CreatePost_Buzz extends Base {

	public TC001_CreatePost_Buzz() {
		testcasename = this.getClass().getSimpleName();
		testcase.put("testcasename", testcasename);
		description = "To verify whether the user is able to create a post in buzz screen";
	}

	HomePage homepage;
	Reporting reporting;

	@Test
	public void testcase() {
		try {
			homepage = new HomePage(testcase);
			reporting = new Reporting(testcase);
			LoginPage lg = new LoginPage(testcase);
			BuzzPage buzz = new BuzzPage(testcase);

			//Launch the application
			homepage.launchApp();
			
			//Login to the application
			lg.login();
			
			//Navigate to Buzz screen
			homepage.navigateToBuzz();
			
			//Write a new post
			buzz.writePost();
			
			//Verify whether the newly created post is getting displayed
			
			
			
			//Close the application
			homepage.closeApp();

		} catch (Exception e) {
			teardownexception(reporting, e);
		}
	}
}
