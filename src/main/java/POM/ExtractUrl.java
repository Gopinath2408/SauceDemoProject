package POM;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtractUrl {
	WebDriver dr;

	@FindBy(tagName = "a")
	private List<WebElement> atag;

	public ExtractUrl(WebDriver dr) {
    
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}

	public List<WebElement> extractlink() {

		
		System.out.println(atag);
		return atag;

	}

}
