package testcases;

import org.testng.annotations.Test;

import core.Base;
import pages.Emergency_Contacts;
import pages.HRM_LoginPage;
import pages.HRM_My_Info;
import pages.HomePage;
import utils.Reporting;

public class TC_005_HRM19 extends Base {

	public TC_005_HRM19() {
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
			HRM_My_Info MI = new HRM_My_Info(testcase);
			Emergency_Contacts EC=new Emergency_Contacts(testcase);
			homepage.launchApp();
			lg.log_in();
			MI.MyInfo();
			EC.EmergencyContacts();
			EC.Add_Button();
			EC.Add_contacts();;
		//	
			
			////*[text()='Assigned Emergency Contacts']/../button
			
			homepage.closeApp();

		} catch (Exception e) {
			teardownexception(reporting, e);
		}
	}
}
