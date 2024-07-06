package SeleniumFrameworkDesign.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
public static ExtentReports ExtentreportDemo() 
	
	
	{
		
		
			String path = System.getProperty("user.dir") + "\\report\\index.html";
			ExtentSparkReporter  report= new ExtentSparkReporter(path);
			report.config().setReportName("seleniumTestResult");
			report.config().setDocumentTitle("TestResult");
			
			ExtentReports newreport= new ExtentReports();
			newreport.attachReporter(report);
			newreport.setSystemInfo("Tester", "Dinesh M");	
			return newreport;
	}		
					
}



