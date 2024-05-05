package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import SeleniumFrameworkDesign.abstractcomponet.abstractcomponent;

public class cartpageclass extends abstractcomponent {

	WebDriver driver;
	
	public cartpageclass(WebDriver driver)
	
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css= (("[placeholder='Select Country']")))
	WebElement val;
    
	
	@FindBy(xpath= ("//a[text()='Place Order ']"))
	WebElement sumbit;
	
	@FindBy(xpath= (("//button[@class=\"ta-item list-group-item ng-star-inserted\"] [2]")))
	WebElement action;
	
	//By result= By.cssSelector("section[class=\"ta-results list-group ng-star-inserted\"]");
	By result= By.cssSelector(".ta-results");
	
	public void action(String kname) {
		Actions news = new Actions(driver);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,800)");
	    driver.findElements(By.cssSelector(".ta-results")).size();
		news.sendKeys(val, kname).build().perform();
		waitelementtobeapper(result);
		action.click();
	}
	
	

	public confirmationpage submitorder() throws InterruptedException
	
	{
		
		sumbit.click();
	
		return new confirmationpage(driver);
		
	}
	
}
