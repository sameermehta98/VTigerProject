package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"=====Test Started====");
		
		//create a test script - recognise each @Test
				test = report.createTest(testName);
				
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"=====Passed====");
		
		//Log the success
				test.log(Status.PASS, testName+" == PASS ==");
				
		}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"=====Failed====");
		
		Throwable reason = result.getThrowable();
		System.out.println(reason);
		
		//log for failure
				test.log(Status.FAIL, testName+" == Fail ==");
				test.log(Status.INFO, result.getThrowable());
		
		String screenShotName = testName+new JavaUtility().getSystemDate();
		WebDriverUtility w=new WebDriverUtility();
		try {
			String path=w.captureScreenshot(BaseClass.sdriver, screenShotName );
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		System.out.println(testName+"=====Skipped====");
		//log for Skip
				test.log(Status.SKIP, testName+" == skipped ==");
				test.log(Status.INFO, result.getThrowable());
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("=====Suite Execution Started=====");
	
		 //Basic Report configuration //Report-17-10-2023-20-04-20.html
		ExtentSparkReporter html = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		html.config().setTheme(Theme.DARK);
		html.config().setDocumentTitle("Execution Report");
		html.config().setReportName("Vtiger execution Report");
		
	    report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Sameer");
		
	}

	@Override
	public void onFinish(ITestContext context) {
	System.out.println("=====Suite Execution Finished=====");
	
	//Report genertion
			report.flush();
			
	}

}
