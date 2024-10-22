package TestNGDemo.Demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites extends Base {


    @Test
    public void openNaukri() {
        driver.get("http://naukri.com");

        Assert.assertEquals(driver.getTitle(),"naukri.com"
                ,"This is not a naukri.com website");
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
