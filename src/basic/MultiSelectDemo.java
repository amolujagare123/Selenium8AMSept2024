package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/amol.html");

        // 1. find the web element
        WebElement multiSelText = driver.findElement(By.id("multiSel"));

        // 2. create the object of select class
        Select selText = new Select(multiSelText);

        Thread.sleep(4000);

        // 3. select the element / option
        selText.selectByVisibleText("text 4");
        selText.selectByIndex(4);
        selText.selectByIndex(1);

        Thread.sleep(4000);
       /* selText.deselectByIndex(4);
        selText.deselectByIndex(1);*/

        selText.deselectAll();



    }
}
