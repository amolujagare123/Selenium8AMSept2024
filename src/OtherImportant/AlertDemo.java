package OtherImportant;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/amol.html");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Try it']")).click();

        Thread.sleep(3500);

        Alert alert = driver.switchTo().alert();
        System.out.println("alert Message = "+alert.getText());

        // alert.accept(); // click ok
        alert.dismiss(); // click cancel or escape


        System.out.println(driver.findElement(By.id("demo")).getText());
    }
}
