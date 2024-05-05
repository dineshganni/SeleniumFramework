package SeleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFrameworkDesign.abstractcomponet.abstractcomponent;

public class productcart extends abstractcomponent {
	
	WebDriver driver;
	
	
	public productcart(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
 
	
	@FindBy(css=".offset-sm-1")
	List<WebElement> products;
	
	
	
	By Prod = By.cssSelector(".offset-sm-1");
	By addcart =By.cssSelector(".card-body button:last-of-type");
	By toast= By.cssSelector("div[id='toast-container']");
	//By spinner = By.cssSelector(".ng-animating");
	
	public List<WebElement> getProductList() 
	
	{
		 waitelementtobeapper(Prod);
		return products; 
	}
	
	
	public WebElement getproductbyname(String itemname)
	{
		WebElement pro = getProductList().stream()
				.filter(prod->prod.findElement(By.cssSelector("b")).getText().equals(itemname)).findFirst().orElse(null);
		return pro;
	}
	
	
	public void addproducttocart(String itemname) throws InterruptedException
	
	{   
		WebElement pro=getproductbyname(itemname);
		pro.findElement(addcart).click();
		waitelementtobeapper(toast);
		waitelementtobedisapper();
		
	
	}
	
}



	

	
