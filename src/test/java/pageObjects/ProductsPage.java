package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='Products']")
	WebElement plpHeading;
		
	@FindBy(xpath = "//a[@id='item_4_title_link']")
	WebElement firstProductName;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	WebElement firstProductPrice;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement clkAddToCartButton;
	
	@FindBy(xpath = "//div[@class='shopping_cart_container']")
	WebElement clkCartIcon;
	
	public boolean isProductsExists()
	{
		try
		{
			return (plpHeading.isDisplayed());
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
	
}
