package TestMethods;
import static org.testng.Assert.assertEquals;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import POM.ExtractUrl;
import POM.UserCredentials;
import POM.VerifyUser;
import Utility.utilityclass;


public class ExtractUrlTest extends hooks {

	public String uname;
	public String pass;
	ExtractUrl extract;

	@Test
	public void test002() {
		
		VerifyUser login = new VerifyUser(dr,userdata);
		login.Verify();
		
		
		extract = new ExtractUrl(dr);
		
		List<WebElement> lnk = extract.extractlink();

		for (WebElement web1 : lnk) {
		 
			
			if(!web1.getText().isEmpty())
				System.out.println(web1.getText());
		}

	}

}
