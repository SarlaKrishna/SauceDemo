package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[@id='item_4_title_link']")
	WebElement cartProductName;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement cartProductPrice;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement clkMenu;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement clkLogout;
	
	public String cartProdName() {
		return cartProductName.getText();
	}
	
	public String cartProdPrice() {
		return cartProductPrice.getText();
	}
	
	public void clickOnMenu() {
		clkMenu.click();
	}
	
	public void clickLogout() {
		clkLogout.click();
	}
	
}
