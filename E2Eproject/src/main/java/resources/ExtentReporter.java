package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports extent;

	 
	public static ExtentReports getReportObject()
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Selenium Web Automation Results");

		reporter.config().setDocumentTitle("Selenium Test Results");

		extent =new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Kiran Hole");
		
		return extent;
	}
}
