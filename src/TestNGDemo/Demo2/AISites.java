package TestNGDemo.Demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AISites extends Base{




    @Test
    public void openOpenAI() {
        driver.get("https://openai.com");
    }

    @Test
    public void openDeepMind() {
        driver.get("https://deepmind.com");
    }

    @Test
    public void openAnthropic() {
        driver.get("https://anthropic.com");
    }

    @Test
    public void openHuggingFace() {
        driver.get("https://huggingface.co");
    }

    @Test
    public void openStabilityAI() {
        driver.get("https://stability.ai");
    }
}
