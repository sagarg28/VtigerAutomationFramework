package Vtiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentationClass implements ITestListener{

	
	ExtentReports report;
	ExtentTest test;
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-------------------Suite execution Started------------");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("vtigert Execution Report");
		htmlReport .config().setReportName("Vtiger execution report");
		htmlReport.config().setTheme(Theme.STANDARD);
		
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base url","http://localhost:8888");
		report.setSystemInfo("BaseBrowser", "Firefox");
		report.setSystemInfo("BaseOS", "Windows");
		report.setSystemInfo("ReporterName", "sagar");
		
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("-------------------Suite execution Finished------------");
		report.flush();
	}
	
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "Test Script Failed - "+methodName);
		test.log(Status.FAIL, result.getThrowable());
		String screenShotName = methodName+"-"+jUtil.getSystemDateInFormat();
		try {
			String path = wUtil.takeScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(result.getThrowable());
		test.log(Status.SKIP, "Test script Skipped-"+methodName);
		test.log(Status.SKIP, result.getThrowable());

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		 test = report.createTest(methodName);
		 test.log(Status.INFO, "Test execution Started -"+methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "Test Script Passed-"+methodName);
	}

	
	
}
