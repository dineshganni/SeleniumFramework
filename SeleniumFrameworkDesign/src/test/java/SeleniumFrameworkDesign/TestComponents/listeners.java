package SeleniumFrameworkDesign.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumFrameworkDesign.resources.ExtentReportNG;

public class listeners  extends BaseTests implements ITestListener {
	
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentReports newreport = ExtentReportNG.ExtentreportDemo();
	 @Override
	  public void onTestStart(ITestResult result) {
	    // Code to execute before a test starts
		test= newreport.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	  }

	  // Implement other methods from ITestListener as needed
	
	 @Override
	 public void onTestSkipped(ITestResult result) {
	  
	    // Open a database connection here (assuming all tests need it)
	  }

	 
	 @Override
	  public void onTestSuccess(ITestResult result) {
	
	    // Send a notification (email, Slack message) indicating a successful test
		 test.log(Status.PASS, "Your test case is passed");
	  }
	
	 @Override
	  public void onTestFailure(ITestResult result) {
	    // Assuming you have ExtentReports setup for reporting
		 extentTest.get().fail(result.getThrowable());
		 try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 String filepath = null;
		try {
			filepath = getscreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		 
		 //Screenshot need to be attached. 
		 
	    
	  }
	 
	 @Override
	 public void onFinish(ITestContext context) {
	  
	    // Open a database connection here (assuming all tests need it)
		 newreport.flush();
	  }
	
}
