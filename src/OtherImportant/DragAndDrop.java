package OtherImportant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement source = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement destination = driver.findElement(By.xpath("//div[@id='box106']"));

        Actions action = new Actions(driver);

        action.dragAndDrop(source,destination).perform();


        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@data-reactid='64']")).click();

    }
}
