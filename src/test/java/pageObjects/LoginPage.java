package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement btnLogin;

	@FindBy(xpath = "//span[text()='Products']")
	WebElement msgHeading;
		
	@FindBy(xpath = "//a[@id='item_4_title_link']")
	WebElement firstProductName;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement firstProductPrice;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement clkAddToCartButton;
	
	@FindBy(xpath = "//div[@class='shopping_cart_container']")
	WebElement clkCartIcon;
	
	@FindBy(xpath = "//a[@id='item_4_title_link']")
	WebElement cartProductName;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement cartProductPrice;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement clkMenu;
	
	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement clkLogout;
	

	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
		
	public String captureFirstProductName() {
		return firstProductName.getText();
	}
	
	public String captureFirstProductPrice() {
		return firstProductPrice.getText();
	}
	
	public void clickAddToCartButton() {
		clkAddToCartButton.click();
	}
	
	public void clickOnCartIcon() {
		clkCartIcon.click();
	}
	
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
