package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for the ITestListener interface of TestNG
 * @author v-bgelli
 *
 */
public class ListenersImplementation implements ITestListener 
{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test=report.createTest(methodName);
		test.log(Status.INFO,"test script execution started");
		//System.out.println(methodName+"----test script execution started---- ");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "Test script passed");
		//System.out.println(methodName+"-----test script passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "Fail");
		test.log(Status.INFO, result.getThrowable());
		//System.out.println(methodName+"----test script failed----");
		//System.out.println(result.getThrowable());
		
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String screenShotName = methodName+"-"+new JavaUtility().getSystemDateInFormat();
		
		try {
			String path = wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path); //go to screenshot location and it will be attached to the report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "Skipped");
		test.log(Status.INFO,result.getThrowable());
		
		//System.out.println(result.getThrowable());//This will print the exception
		//System.out.println(methodName+"----test script skipped--");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Automation execution report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("BasePlatform", "Windows");
		
		//System.out.println("test script execution started");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("test script execution completed");
		report.flush();
		
	}
	
	

}
