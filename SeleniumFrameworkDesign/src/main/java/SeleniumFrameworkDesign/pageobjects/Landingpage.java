package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.abstractcomponet.abstractcomponent;

public class Landingpage extends abstractcomponent {
	
	WebDriver driver;
	
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
 
	
	@FindBy(id="userEmail")
	WebElement usermail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	@FindBy(css="[class*='flyInOut']")
	WebElement Errormessage;
	
	public productcart applicationlogin(String username, String userpassword) 
	
	{
		usermail.sendKeys(username);
		password.sendKeys(userpassword);
		submit.click();
		productcart item= new productcart(driver);
		
		return item;
		
	}
	
	public String geterrormessage() 
	
	{   waitwebelementtobeapper(Errormessage);
		return Errormessage.getText();
	}
	
	public void goTO() 
	{
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
}


	

	
