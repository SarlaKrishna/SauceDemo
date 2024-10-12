package testCases;

import java.io.BufferedWriter;
import java.io.FileWriter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC001_Product_LoginCart_Test extends BaseClass{

	@Test(groups={"Master"})
	public void verify_Login_ProductCart()
	{
		
		try
		{

		LoginPage lp=new LoginPage(driver);	//Navigate to the site Saucedemo.com
		lp.setEmail(p.getProperty("email")); //Login to the site
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		Thread.sleep(2000);
		
		boolean targetPage=lp.isMyAccountPageExists();
		Assert.assertTrue(targetPage);	//Verify that successful login will land the user on Products page
		System.out.println("First product name & price is: "+lp.captureFirstProductName()+" : "+lp.captureFirstProductPrice());		
		
		//***	Get the first product item name and price, store it in a text file
		//***	Add ProductName & Price into Text file
		FileWriter writer = new FileWriter("ProductDetails_File.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(lp.captureFirstProductName()+" : "+lp.captureFirstProductPrice());
        bufferedWriter.newLine();
        bufferedWriter.close();
		
        
		lp.clickAddToCartButton();	//Click on the add cart
		lp.clickOnCartIcon();
		
		//***	Navigate to add cart and verify that cart page contains the product which was added in the above step
		System.out.println("Added cart product name & price is: "+lp.cartProdName()+" : "+lp.cartProdPrice());	
		Assert.assertEquals(lp.captureFirstProductName(), lp.cartProdName());
		Assert.assertEquals(lp.captureFirstProductPrice(), lp.cartProdPrice());
		
		lp.clickOnMenu();
		Thread.sleep(2000);
		
		lp.clickLogout();	//Logout
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}
