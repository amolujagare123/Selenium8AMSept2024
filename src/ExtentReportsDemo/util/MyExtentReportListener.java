package ExtentReportsDemo.util;

import TestNGDemo.Demo2.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static ExtentReportsDemo.util.ForExtentReport.initExtentObj;
import static ExtentReportsDemo.util.ForExtentReport.takeScreenshot;

public class MyExtentReportListener extends Base implements ITestListener
{
    ExtentReports extent;
    ExtentTest test;

    public void onTestStart(ITestResult result) {

        System.out.println("onTestStart");
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
        test.pass("test is passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        test.info("test is failed");
        test.fail(result.getThrowable());
        try {
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
        test.info("test is skipped");
        test.skip(result.getThrowable());
    }

    public void onStart(ITestContext context) {

        if(extent==null)
         extent = initExtentObj();

        System.out.println("onStart");
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish");

        extent.flush();
    }
}
