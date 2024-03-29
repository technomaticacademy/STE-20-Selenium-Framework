package testcases;

import org.testng.annotations.Test;

import core.Base;
import pages.Dashboard_page;
import pages.Employ_tracker_screen;
import pages.HRM_LoginPage;
import pages.HomePage;
import utils.Reporting;

public class TC_001_HRM13 extends Base {

	public TC_001_HRM13() {
		testcasename = this.getClass().getSimpleName();
		testcase.put("testcasename", testcasename);
		description = "To check the sample functionality of the application";
	}

	HomePage homepage;
	Reporting reporting;

	@Test
	public void testcase() {
		try {
			homepage = new HomePage(testcase);
			reporting = new Reporting(testcase);
			HRM_LoginPage lg = new HRM_LoginPage(testcase);
			Dashboard_page DB = new Dashboard_page(testcase);
			Employ_tracker_screen ET = new Employ_tracker_screen(testcase);
			
			//launch the application
			

			homepage.launchApp();
			
			//Login the application
			lg.log_in();
			//navigate to performance screen
		   DB.NavigateToPerformanceScreen();
			
			//click on employ trackers and click on view button
		   ET.TrackerTabScreen();
			
			
		   
			
			//close the application
			homepage.closeApp();

		} catch (Exception e) {
			teardownexception(reporting, e);
		}
	}
}
