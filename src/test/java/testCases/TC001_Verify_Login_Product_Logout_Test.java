package testCases;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.CartPage;
import testBase.BaseClass;

public class TC001_Verify_Login_Product_Logout_Test extends BaseClass{

	@Test(groups={"Master"})
	public void verify_Login_ProductCart()
	{
		
		try
		{

		LoginPage lp=new LoginPage(driver);	//Navigate to the site Saucedemo.com
		lp.setUsername(p.getProperty("username")); //Login to the site
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(2000);
		
		ProductsPage pp = new ProductsPage(driver);
		boolean targetPage=pp.isProductsExists();
		Assert.assertTrue(targetPage);	//Verify that successful login will land the user on Products page
		System.out.println("First product name & price is: "+pp.captureFirstProductName()+" : "+pp.captureFirstProductPrice());		
		
		//***	Get the first product item name and price, store it in a text file
		//***	Add ProductName & Price into Text file
		FileWriter writer = new FileWriter("ProductDetails_File.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(pp.captureFirstProductName()+" : "+pp.captureFirstProductPrice());
        bufferedWriter.newLine();
        bufferedWriter.close();
		
		pp.clickAddToCartButton();	//Click on the add cart
		pp.clickOnCartIcon();
	
		//***	Navigate to add cart and verify that cart page contains the product which was added in the above step
		CartPage cp = new CartPage(driver);
		System.out.println("Added cart product name & price is: "+cp.cartProdName()+" : "+cp.cartProdPrice());	
		Assert.assertEquals(pp.captureFirstProductName(), cp.cartProdName());
		Assert.assertEquals(pp.captureFirstProductPrice(), cp.cartProdPrice());
		
		cp.clickOnMenu();
		Thread.sleep(2000);
		
		cp.clickLogout();	//Logout
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
