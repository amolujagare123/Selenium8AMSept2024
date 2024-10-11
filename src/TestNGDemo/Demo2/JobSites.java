package TestNGDemo.Demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites {

    WebDriver driver;

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
    @Test
    public void openNaukri() {
        driver.get("http://naukri.com");
    }

    @Test
    public void openMonsterIndia() {
        driver.get("http://monsterindia.com");
    }

    @Test
    public void openShine() {
        driver.get("http://shine.com");
    }

    @Test
    public void openTimesJobs() {
        driver.get("http://timesjobs.com");
    }

    @Test
    public void openFreshersworld() {
        driver.get("http://freshersworld.com");
    }


}
