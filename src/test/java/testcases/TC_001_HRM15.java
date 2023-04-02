package testcases;

import org.testng.annotations.Test;

import core.Base;
import pages.AddTrackerLog;
import pages.Add_login_button;
import pages.Dashboard_page;
import pages.Employ_tracker_Log_edit;
import pages.Employ_tracker_screen;
import pages.HRM_LoginPage;
import pages.HomePage;
import utils.Reporting;

public class TC_001_HRM15 extends Base {

	public TC_001_HRM15() {
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
			Add_login_button AD = new Add_login_button(testcase);
			AddTrackerLog AL = new AddTrackerLog(testcase);
			Employ_tracker_Log_edit ED =  new Employ_tracker_Log_edit(testcase);
			
			homepage.launchApp();

			//Login the application
			lg.log_in();
			//navigate to performance screen
		   DB.NavigateToPerformanceScreen();
			
			//click on employ trackers
		   ET.TrackerTabScreen();
		   ED.Edit_log();
		   
			
		   AL.AddLog();
		   
			homepage.closeApp();

		} catch (Exception e) {
			teardownexception(reporting, e);
		}
	}
}
