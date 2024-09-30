import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");

        // 1. find the web element
        WebElement fromPort = driver.findElement(By.name("fromPort"));

        // 2. create the object of select class
        Select selFromPort = new Select(fromPort);

        Thread.sleep(4000);

        // 3. select the element / option
       // selFromPort.selectByVisibleText("Boston");
     //   selFromPort.selectByIndex(1);
        selFromPort.selectByValue("San Diego");



    }
}
