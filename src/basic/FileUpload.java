package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/amol.html");

        WebElement fileElement = driver.findElement(By.xpath("/html/body/input[1]"));

        String path = "D:\\MyProg\\Suite.png";

         Thread.sleep(4000);

        fileElement.sendKeys(path);
    }
}
