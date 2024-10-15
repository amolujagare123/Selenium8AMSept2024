package Assertion;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AddClientTest {

    @Test
    public void addClientTest1()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        driver.findElement(By.linkText("Add Customer")).click();


        driver.findElement(By.name("name")).sendKeys("Saloni");
    /*    driver.findElement(By.name("address")).sendKeys("xyz");
        driver.findElement(By.name("contact1")).sendKeys("5454545");
        driver.findElement(By.name("contact2")).sendKeys("5454545");
*/
        driver.findElement(By.name("Submit")).click();

        String expected = "PLEASE ENTER A CUSTOMER NAME";

        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//label[@for='name']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");
    }

    @Test
    public void addClientTest2()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        driver.findElement(By.linkText("Add Customer")).click();

        String name = "Saloni3";

        driver.findElement(By.name("name")).sendKeys(name);
       driver.findElement(By.name("address")).sendKeys("xyz");
        driver.findElement(By.name("contact1")).sendKeys("5454545");
        driver.findElement(By.name("contact2")).sendKeys("5454545");

        driver.findElement(By.name("Submit")).click();

        String expected = "[ "+name+" ] Customer Details Added !";

        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//div[@class='confirmation-box round']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");
    }

    @Test
    public void addClientTest3()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        WebElement txtUsername = driver.findElement(By.id("login-username"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        driver.findElement(By.linkText("Add Customer")).click();



        //driver.findElement(By.name("name")).sendKeys(name);
      //  driver.findElement(By.name("address")).sendKeys("xyz");
        driver.findElement(By.name("contact1")).sendKeys("54");
        driver.findElement(By.name("contact2")).sendKeys("54");

        driver.findElement(By.name("Submit")).click();

        ArrayList<String> expected = new ArrayList<>();
        expected.add("PLEASE ENTER A CUSTOMER NAME");
        expected.add("PLEASE ENTER AT LEAST 3 CHARACTERS.");
        expected.add("PLEASE ENTER AT LEAST 3 CHARACTERS.");
        ArrayList<String> actual = new ArrayList<>();
        try {
            List<WebElement> wbList = driver.findElements(By.xpath("//label[@class='error']"));

           /* actual.add(wbList.get(0).getText());
            actual.add(wbList.get(1).getText());
            actual.add(wbList.get(2).getText());*/

            for (WebElement wb:wbList)
                actual.add(wb.getText());
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");

/*
        String expected = "";

        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//div[@class='confirmation-box round']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect or no error message");*/
    }
}
