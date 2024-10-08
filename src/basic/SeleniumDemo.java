package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

    public static void main(String[] args) throws InterruptedException {

       WebDriver driver = new ChromeDriver(); // upcasting
     //WebDriver driver = new FirefoxDriver(); // upcasting
      //  WebDriver driver = new EdgeDriver(); // upcasting
        //WebDriver driver = new SafariDriver();

       // driver.manage().window().maximize();
       // driver.get("http://gmail.com");
        driver.get("https://chat.openai.com/");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://gmail.com");

        Thread.sleep(4000);

      //  driver.close(); // closes the current window only

     //  driver.quit(); // closes the all the windows opened by the driver
    }
}
