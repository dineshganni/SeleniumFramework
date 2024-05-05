package SeleniumFrameworkDesign.abstractcomponet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameworkDesign.pageobjects.Orderpage;
import SeleniumFrameworkDesign.pageobjects.cartpage;

public class abstractcomponent {

	WebDriver driver;
	
	public abstractcomponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(css="[routerlink*='cart']")
	WebElement cartout;
	
	
			
	@FindBy(css="[routerlink*='myorders']")
	WebElement Orderout;		
	
	public void waitelementtobeapper(By FindBy)
	
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
		
	}
	
     public void waitwebelementtobeapper(WebElement FindBy)
	
	{
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(FindBy));
		
	}
	
    public void waitelementtobedisapper() throws InterruptedException
	
	{	
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
	}
	
    public cartpage cartpage() 
    
    {
    	cartout.click();
    	cartpage carts = new cartpage(driver);
 	   
 	   return carts;
    }
   
	

    public  Orderpage gotoOrderspage() 
    
    {
    	Orderout.click();
    	Orderpage Order = new Orderpage(driver);
 	    return Order;
 	   
 	   
    }

	

	

	
	
}
