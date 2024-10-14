package TestNGDemo.Demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialSites {

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



    @Test (priority = 4)
    public void openFacebook() {
        driver.get("http://facebook.com");
    }

    @Test (priority = 3)
    public void openTwitter() {
        driver.get("http://twitter.com");
    }

    @Test (priority = 5)
    public void openInstagram() {
        driver.get("http://instagram.com");
    }

    @Test (priority = 2)
    public void openLinkedIn() {
        driver.get("http://linkedin.com");
    }

    @Test (priority = 1)
    public void openYouTube() {
        driver.get("http://youtube.com");
    }


}
