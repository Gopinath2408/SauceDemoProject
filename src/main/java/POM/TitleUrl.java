
package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TitleUrl {

    private final WebDriver dr;

//    @FindBy(id = "user-name")
//    private WebElement user;
//
//    @FindBy(id = "password")
//    private WebElement pass;
//
//    @FindBy(id = "login-button")
//    private WebElement btn;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortDropdown;

    @FindBy(xpath = "//div[@class='inventory_list']/div[1]//button")
    private WebElement firstItemAddButton;

    @FindBy(xpath = "//div[@id='shopping_cart_container']/a")
    private WebElement cartLink;

    @FindBy(xpath = "//div[@class='cart_list']//div[3]//a/div")
    private WebElement firstCartItemName;

    @FindBy(xpath = "//div[@class='cart_footer']//button[2]")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;
    
    @FindBy(id = "continue")
    private WebElement ClkContinue;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(xpath = "//div[@id='checkout_complete_container']//h2")
    private WebElement checkoutCompleteHeader;

    public TitleUrl(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
    }

    public String Titile() {
        return dr.getTitle();
    }

    public String url() {
        return dr.getCurrentUrl();
    }

   
    public void selectSortOptionByIndex() {
        new Select(sortDropdown).selectByIndex(1);
    }

    public void addFirstItemToCart() {
        firstItemAddButton.click();
    }

    public void goToCart() {
        cartLink.click();
    }

    public String getFirstCartItemName() {
        return firstCartItemName.getText().trim();
    }
    
  

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void fillCheckoutForm() throws InterruptedException {
        firstName.sendKeys("Gopi");
        lastName.sendKeys("Sakthivel");
        postalCode.sendKeys("636404");
        Thread.sleep(3000);
    }
    
    public void ClkContinue() {
    	ClkContinue.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public String getOrderConfirmationText() {
        return checkoutCompleteHeader.getText().trim();
    }
}
