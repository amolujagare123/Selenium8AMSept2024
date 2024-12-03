package OtherImportant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class MyntaDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/");
        Thread.sleep(3500);
        WebElement menMenu = driver.findElement(By.xpath("//a[@data-group='men']"));

        Actions action = new Actions(driver);

        action.moveToElement(menMenu).perform();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-reactid='64']")).click();

    }
}
