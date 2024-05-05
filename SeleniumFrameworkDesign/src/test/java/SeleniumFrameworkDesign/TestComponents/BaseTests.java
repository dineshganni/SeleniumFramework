package SeleniumFrameworkDesign.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFrameworkDesign.pageobjects.Landingpage;

public class BaseTests {

   public WebDriver driver; 
   public Landingpage landingpage;
	
	public WebDriver intilization() throws IOException {
	
	Properties pro = new Properties();
	FileInputStream fil = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//SeleniumFrameworkDesign//resources//globalTest.properties");
    pro.load(fil);
	String browsername = pro.getProperty("browser");
	
	if(browsername.equalsIgnoreCase("chrome"))
	
	{
		System.setProperty("web.driver.chrome",
				"C://Users//dineshma//OneDrive - Radware LTD//Desktop//My_Learning//Selenium_Traning//chromedriver_win32//chromedriver.exe");
		 driver = new ChromeDriver();
      
		
	}
	else if(browsername.equalsIgnoreCase("firefox"))
	{
		System.setProperty("web.driver.firefox",
				"C://Users//dineshma//OneDrive - Radware LTD//Desktop//My_Learnings//Selenium_Traning//geckodriver-v0.33.0-win-aarch64//geckodriver.exe");
		 driver = new FirefoxDriver();
		
	}
	
	else if(browsername.equalsIgnoreCase("Edge"))
	
	{
		System.setProperty("web.driver.edge",
				"C://Users//dineshma//OneDrive - Radware LTD//Desktop//My_Learnings//Selenium_Traning//edgedriver_win64//msedgedriver.exe");
		 driver = new EdgeDriver();
		
	}
	
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
     driver.manage().window().maximize();
     return driver;
     
	}
	
    public List<HashMap<String, String>> getdatafromjson(String filepath) throws IOException 
	
	{
		//read json data into the string 
	  String jsondata = FileUtils.readFileToString(new java.io.File(filepath),StandardCharsets.UTF_8);
		
	  //Convert the string to hashMap 
	  
	  ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsondata, new TypeReference<List<HashMap<String, String>>> () {});
	
	return 
			data;
	
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchingpage( ) throws IOException 
	
	{
		driver= intilization();
		landingpage = new  Landingpage(driver);
		landingpage.goTO();
		return landingpage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown( ) 
	{
		driver.close();
	}
	
}
