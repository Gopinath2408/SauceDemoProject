package TestMethods;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import POM.TitleUrl;
import POM.UserCredentials;
import POM.VerifyUser;
import Utility.utilityclass;



public class TitileUrlTest extends hooks {
	public String uname;
	public String pass;
	TitleUrl ur;

	@Test
	public void test001() throws InterruptedException {

		VerifyUser login = new VerifyUser(dr, userdata);
		login.Verify();
		
		ur = new TitleUrl(dr);
		assertEquals(ur.Titile(),"Swag Labs");
		assertEquals(ur.url(),"https://www.saucedemo.com/inventory.html");

		ur.selectSortOptionByIndex();
		ur.addFirstItemToCart();
		ur.goToCart();

		assertEquals(ur.getFirstCartItemName(),"Test.allTheThings() T-Shirt (Red)");
		ur.clickCheckout();
		ur.fillCheckoutForm();
		ur.ClkContinue();
		ur.clickFinish();

		assertEquals(ur.getOrderConfirmationText(),"Thank you for your order!");

	}
}
