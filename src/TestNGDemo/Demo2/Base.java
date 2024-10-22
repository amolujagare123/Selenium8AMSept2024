package TestNGDemo.Demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

    public static WebDriver driver;

    @BeforeClass // this method will execute before first test method of the class
    public  void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass // this method will execute after last test method of class
    public  void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
}
