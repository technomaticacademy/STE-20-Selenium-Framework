package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.By;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test_AlreadyOpenedBrowser {

	public static void main(String[] args)throws InterruptedException{
		toRunOnOpenedBrowser();
	}
	
	public static void toRunOnOpenedBrowser() {
		System.setProperty("webdriver.chrome.driver",
		         "./drivers/chromedriver.exe");
		      //WebDriver driver2 = new ChromeDriver();
		      //object of ChromeOptions class
		      ChromeOptions opt = new ChromeOptions();
		      //setting debuggerAddress value
		      opt.setExperimentalOption("debuggerAddress", "localhost:18510");
		      
		   // pass ChromeOptions object to ChromeDriver constructor
		      WebDriver driver2=new ChromeDriver(opt);

		      // now you can use now existing Browser
		      driver2.get("http://facebook.com");
		      
		      /*
		      //add options to browser capabilities
		      Capabilities c = ((Object) driver2).getCapabilities(o);
		      Map<String, Object> m = c.asMap();
		      m.forEach((key, value) -> {
		         System.out.println("Key is: " + key + " Value is: " + value);
		      });
		      //set implicit wait
		      driver2.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		      //identify element
		      WebElement l = driver2.findElement(By.id("gsc−i−id1"));
		      //remove existing data in edit box
		      l.clear();
		      l.sendKeys("Tutorialspoint");
		      String s = l.getAttribute("value");
		      System.out.println("Attribute value: " + s);
		      */
	}
	public static void toFindOpenedBrowserPort() {
		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		//get browser capabilities in key value pairs
		Capabilities c = ((RemoteWebDriver) driver1).getCapabilities();
		Map<String, Object> m = c.asMap();
		
//		m.forEach((key, value) -> {
//			System.out.println("Key is: " + key + " Value is: " + value);
//		});
		//set implicit wait
		driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver1.get("https://www.tutorialspoint.com/about/about_careers.htm");
		//identify element
		WebElement l = driver1.findElement(By.id("gsc−i−id1"));
		l.sendKeys("Selenium");
	}

}

