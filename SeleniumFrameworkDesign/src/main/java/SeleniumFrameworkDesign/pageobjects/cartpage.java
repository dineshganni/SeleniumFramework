package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFrameworkDesign.abstractcomponet.abstractcomponent;

public class cartpage extends abstractcomponent {
	
	WebDriver driver;
	
	
	public cartpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
 
	
	
	@FindBy(css=(".totalRow button"))
	WebElement cartitems;
	
	@FindBy(css=(".cartSection h3"))
	private List<WebElement> cartitemss;
	
	
   public cartpageclass checkout()
   
   {
	   cartitems.click();
	  	
	  return new cartpageclass(driver);
       

   }

   
   public Boolean verifyproductsdisaply(String itemname)
   
   {
	   
	   Boolean cart = cartitemss.stream().anyMatch(cartss->cartss.getText().equalsIgnoreCase(itemname));
	   return cart;
   }
   
  
   
   
}



	

	
