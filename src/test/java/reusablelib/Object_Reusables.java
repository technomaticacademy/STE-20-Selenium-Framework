package reusablelib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Object_Reusables {
	
	public static WebDriver driver;
	
	public Object_Reusables(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click(By xpath, String objName) {
		if(driver.findElements(xpath).size() > 0) {
			driver.findElement(xpath).click();
			System.out.println("Clicking on "+objName);
		}
		else {
			System.out.println("Object is not present");
		}
	}
	
	public void sendKeys(By xpath, String input, String objName) {
		driver.findElement(xpath).sendKeys(input);
		System.out.println("Entered " + input + " in "+ objName);
	}

}
