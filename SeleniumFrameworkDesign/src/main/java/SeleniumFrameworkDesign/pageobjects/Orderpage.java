package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.abstractcomponet.abstractcomponent;

public class Orderpage extends abstractcomponent {
	
	WebDriver driver;
	
	
	public Orderpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
 
	
	
	@FindBy(css=(".totalRow button"))
	WebElement cartitems;
	
	@FindBy(css=("tr td:nth-child(3)"))
	private List<WebElement> orderitems;
	

   
   public Boolean verifyproductsdisaplyorder(String itemname)
   
   {
	   
	   Boolean cart = orderitems.stream().anyMatch(cartss->cartss.getText().equalsIgnoreCase(itemname));
	   return cart;
   }
   
  
   
   
}



	

	
