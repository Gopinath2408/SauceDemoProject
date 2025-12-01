package TestMethods;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import POM.TitleUrl;
import POM.UserCredentials;
import Utility.utilityclass;

public class TitileUrlTest {

	utilityclass browser;
	TitleUrl ur;
	WebDriver dr;
	HashMap<Integer, UserCredentials> userdata;

	public String uname;
	public String pass;

	@BeforeClass
	public void launch() throws IOException {
		browser = new utilityclass();
		dr = browser.load("https://www.saucedemo.com/");
		userdata = browser.readFromExcel();
		ur = new TitleUrl(dr);
	}

	@Test
	public void test001() throws InterruptedException {

		assertEquals(ur.Titile(), "Swag Labs");
		assertEquals(ur.url(), "https://www.saucedemo.com/");

		for (Map.Entry<Integer, UserCredentials> map : userdata.entrySet()) {
			UserCredentials s1 = map.getValue();

			ur.userName(s1.uname);
			ur.userPass(s1.pass);
			ur.userLogin();

		}

		ur.selectSortOptionByIndex();
		ur.addFirstItemToCart();
		ur.goToCart();

		assertEquals(ur.getFirstCartItemName(), "Test.allTheThings() T-Shirt (Red)");
		ur.clickCheckout();
		ur.fillCheckoutForm();
		ur.ClkContinue();
		ur.clickFinish();

		assertEquals(ur.getOrderConfirmationText(), "Thank you for your order!");

	}
}
