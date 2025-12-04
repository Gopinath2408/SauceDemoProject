package POM;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyUser {

	
	WebDriver dr;
	
	public HashMap<Integer, UserCredentials> userval;
	
	
	@FindBy(id = "user-name")
	static WebElement user;

	@FindBy(id = "password")
	static WebElement pass;

	@FindBy(id = "login-button")
	static WebElement btn;
	
	
	public VerifyUser(WebDriver dr,HashMap<Integer,UserCredentials> val){
		this.dr= dr;
		userval = val;
		PageFactory.initElements(dr,this);
	}

	public void Verify() {
		
		for (Map.Entry<Integer, UserCredentials> map :userval.entrySet()) {
			UserCredentials s1 = map.getValue();
			user.sendKeys(s1.uname);
			pass.sendKeys(s1.pass);
			btn.click();

		}
		
		
		
	}

}
