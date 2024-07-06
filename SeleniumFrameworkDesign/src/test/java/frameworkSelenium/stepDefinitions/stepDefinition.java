package frameworkSelenium.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import SeleniumFrameworkDesign.TestComponents.BaseTests;
import SeleniumFrameworkDesign.pageobjects.Landingpage;
import SeleniumFrameworkDesign.pageobjects.cartpage;
import SeleniumFrameworkDesign.pageobjects.cartpageclass;
import SeleniumFrameworkDesign.pageobjects.confirmationpage;
import SeleniumFrameworkDesign.pageobjects.productcart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition extends BaseTests{

	public confirmationpage confrimpage;
	public productcart item;
	public Landingpage launchingpage;
	
	@Given ("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		launchingpage();
		
	}

	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password) {
		
	 item = landingpage.applicationlogin(username, password);
	}
	
    @When("^I add product (.+) to cart$")
    public void I_add_product_to_cart(String productname) throws InterruptedException {
    	
    	List<WebElement> items = item.getProductList();
		item.addproducttocart(productname);
    }
	
    
    @And("^Checkout (.+) submit the order$")
    public void Checkout_submit_the_order(String productname ) throws InterruptedException
    
    {
    	cartpage cartspage= item.cartpage();
		Boolean cart = cartspage.verifyproductsdisaply(productname);
		Assert.assertTrue(cart);
		cartpageclass cartpagecls= cartspage.checkout();
		cartpagecls.action("india");
		confrimpage= cartpagecls.submitorder();
    }
   
    
    @Then("{string} message is displayed on ConfirmationPage")
    public void ConfirmationPage(String string) {
    	String confirmMessage = confrimpage.getconfirmationmesaage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	    driver.close();
    }
    
    
    @Then("{string} message is displayed")
    public void message_is_displayed(String stringArg1) {
    	
		Assert.assertEquals(stringArg1, landingpage.geterrormessage());
		driver.close();
    }
}
