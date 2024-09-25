package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListner implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;


    public void configureReport()
    {
        htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        //add system information/environments info to reports
        reports.setSystemInfo("Machine", "MyPC");
        reports.setSystemInfo("OS","Windows10");


        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("ITLearn360 Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestStart(ITestResult result) {

    }


    public void onTestSuccess(ITestResult result) {
        System.out.println("Name of the test method successfully excuted "+result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("Name of test method failed:"+result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));

        String screenShotPath= System.getProperty("user.dir") +"\\Screenshots\\" + result.getName() + ".png";

        File screenShotFile = new File(screenShotPath);

        if(screenShotFile.exists())
        {
            test.fail("Captured Screenshot is below:" +test.addScreenCaptureFromPath(screenShotPath));
        }
    }


    public void onTestSkipped(ITestResult result) {
        System.out.println("Name of test method skipped "+result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),ExtentColor.YELLOW));
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }


    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("Test Automation Suite started");
    }


    public void onFinish(ITestContext context) {
        System.out.println("Test Automation Suite finished.");
        reports.flush();// it is mandatory to call flush method to ensure information is written ti the started reporter.
    }


}
