package FrameworkSeleniumFrameworkDesign.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTests;
import SeleniumFrameworkDesign.pageobjects.Landingpage;
import SeleniumFrameworkDesign.pageobjects.cartpage;
import SeleniumFrameworkDesign.pageobjects.productcart;
import junit.framework.Assert;

public class ErrorValidation extends BaseTests {

	@SuppressWarnings("deprecation")
	@Test(groups = {"ErrorValidation"})
	public void loginerrorvalidation() throws InterruptedException, IOException{
		
		
		String itemname="IPHONE 13 PRO";
		landingpage.applicationlogin("marse@gmail.comm", "Mars@123");
		Assert.assertEquals("Incorrect email or password.", landingpage.geterrormessage());
	}
	
	@Test
	public void producterrorvalidation() throws InterruptedException, IOException {

		String itemname = "IPHONE 13 PRO";
		productcart item = landingpage.applicationlogin("marse@gmail.com", "Mars@123");
		List<WebElement> items = item.getProductList();
		item.addproducttocart(itemname);
		cartpage cartspage = item.cartpage();
		Boolean cart = cartspage.verifyproductsdisaply("IPHONE 13 PROp");
		Assert.assertFalse(cart);
	}
}
