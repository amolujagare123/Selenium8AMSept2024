package ExtentReportsDemo;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static ExtentReportsDemo.util.ForExtentReport.takeScreenshot;

public class LoginTestNG {

    ExtentReports extent;
    // pre setup

    @BeforeClass
    public void initExtent()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report/report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("Stock Management System");
        reporter.config().setReportName("Regression Test");

        extent.setSystemInfo("Project Name","Stock Management System");
        extent.setSystemInfo("Created By","Swathik");
        extent.setSystemInfo("Project Start Date","18-10-2024");
        extent.setSystemInfo("Developer Name","Leela");
        extent.setSystemInfo("Test Lead","Prateek");
    }

    @AfterClass
    public void writeToReport()
    {
        extent.flush();
    }

    @Test
    public  void loginTest1() throws IOException {

        ExtentTest test = extent.createTest("valid Login");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        test.info("webpage is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys("admin");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        test.info("login button is clicked");

        String expected = "Dashboard";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//a[@class='active-tab dashboard-tab']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        try{
            Assert.assertEquals(actual,expected,"This is not a dashboard");
            test.info("Test is passed");

        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));
        }

    }

    @Test
    public  void loginTest2()  throws IOException  {

        ExtentTest test = extent.createTest("in valid Login");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        test.info("webpage is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys("dsds");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("dsdds");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        test.info("login button is clicked");

        String expected = "Wrong Username or Password";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//div[@class='error-box round']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        try {
            Assert.assertEquals(actual, expected, "incorrect or no error message");
            test.pass("Test is passed");
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));

        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
        }

    }

    @Test
    public  void loginTest3() throws IOException {

        ExtentTest test = extent.createTest("blank Login");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        test.info("webpage is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys("");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        test.info("login button is clicked");

        String expected = "POSNIC - Dashboard";
        String actual = driver.getTitle();
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        try{
        Assert.assertEquals(actual,expected,"incorrect or no error message");
        test.info("Test is passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+takeScreenshot(driver));

        }

    }
}
