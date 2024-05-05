package SeleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.abstractcomponet.abstractcomponent;

public class confirmationpage extends abstractcomponent {

	WebDriver driver;

	public confirmationpage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = (("h1[class=\"hero-primary\"]")))
	WebElement conmeg;

	public String getconfirmationmesaage()

	{

		return conmeg.getText();
	}

}
