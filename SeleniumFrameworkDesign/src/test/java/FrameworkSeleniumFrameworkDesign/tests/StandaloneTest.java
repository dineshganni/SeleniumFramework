package FrameworkSeleniumFrameworkDesign.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTests;
import SeleniumFrameworkDesign.pageobjects.Orderpage;
import SeleniumFrameworkDesign.pageobjects.cartpage;
import SeleniumFrameworkDesign.pageobjects.cartpageclass;
import SeleniumFrameworkDesign.pageobjects.confirmationpage;
import SeleniumFrameworkDesign.pageobjects.productcart;

public class StandaloneTest extends BaseTests {
    
	String itemname="IPHONE 13 PRO";
	
	@Test(dataProvider="getdata", groups="Purchase")
	public void submitorder(HashMap<String, String> input ) throws InterruptedException, IOException{
		
		
		productcart item = landingpage.applicationlogin(input.get("email"), input.get("password"));
		List<WebElement> items = item.getProductList();
		item.addproducttocart(input.get("itemname"));
		cartpage cartspage= item.cartpage();
		Boolean cart = cartspage.verifyproductsdisaply(input.get("itemname"));
		Assert.assertTrue(cart);
		cartpageclass cartpagecls= cartspage.checkout();
		cartpagecls.action("india");
		confirmationpage confrimpage= cartpagecls.submitorder();
		String confirmMessage = confrimpage.getconfirmationmesaage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
	
	}
	
	@Test(dependsOnMethods= {"submitorder"})
	public void orderitems() 
	{   
		
		productcart item = landingpage.applicationlogin("marse@gmail.com", "Mars@123");
		Orderpage Orderpages = item.gotoOrderspage();
		Assert.assertTrue(Orderpages.verifyproductsdisaplyorder(itemname));	
		//driver.quit();
		
	}
	
	@DataProvider()
	public Object[][] getdata() throws IOException 
	{
		
		List<HashMap<String, String>> data = getdatafromjson(System.getProperty("user.dir")+"//src//test//java//fetchingthedata//data//Data.json");
		
		return 
				new Object [] []  {{data.get(0)} ,{data.get(1)} };
		
		
	}
	
	
	//HashMap<String, String> map = new HashMap <String, String>();
	//map.put("email" ,"marse@gmail.com");
	//map.put("password" ,"Mars@123");
	//map.put("itemname" , "ADIDAS ORIGINAL");
	
	//HashMap<String, String> map1 = new HashMap <String, String>();
	//map1.put("email" ,"marse@gmail.com");
	//map1.put("password" ,"Mars@123");
	//map1.put("itemname" , "IPHONE 13 PRO");
	
	
	//@DataProvider()
	//public Object[][] getdata() 
	//{
		//return 
				//new Object [] []  {{"marse@gmail.com","Mars@123","ADIDAS ORIGINAL" } ,{"marse@gmail.com","Mars@123","IPHONE 13 PRO"}};
		
		
	//}
	
	
}
