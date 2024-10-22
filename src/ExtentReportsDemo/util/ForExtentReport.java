package ExtentReportsDemo.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForExtentReport {


    public static String takeScreenshot(WebDriver driver) throws IOException {

        // 1. create the object reference of TakesScreenshot
        // assign driver to it. type cast it to  TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";
        // 2. call the method getScreenshotAs using ts
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // 3. copy this file object into a real image file
        FileUtils.copyFile(srcFile,new File("Report\\screenshots\\"+fileName));

        return fileName;
    }

    public static ExtentReports initExtentObj()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report/report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("Stock Management System");
        reporter.config().setReportName("Regression Test");

        extent.setSystemInfo("Project Name","Stock Management System");
        extent.setSystemInfo("Created By","Swathik");
        extent.setSystemInfo("Project Start Date","18-10-2024");
        extent.setSystemInfo("Developer Name","Leela");
        extent.setSystemInfo("Test Lead","Prateek");

        return extent;
    }
}
