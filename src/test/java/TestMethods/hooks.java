package TestMethods;

import java.io.IOException;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Utility.utilityclass;
import POM.TitleUrl;
import POM.UserCredentials;
import Utility.utilityclass;

public class hooks {
	
	utilityclass browser;
	WebDriver dr;
	HashMap<Integer, UserCredentials> userdata;
	
	@BeforeClass
	public void launch() throws IOException {
		
		
		browser = new utilityclass();
		dr = browser.load("https://www.saucedemo.com/");
		userdata = browser.readFromExcel();
		
	}
	
	
	@AfterClass
	public void close() throws InterruptedException
	{
		Thread.sleep(4000);
		dr.quit();
	}

}
