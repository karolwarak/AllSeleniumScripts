package _5_practical_problems;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_CheckIfAutoSuggestiveHasAllOptions {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ksrtc.in/oprs-web/");
        driver.manage().window().maximize();

        driver.findElement(By.id("fromPlaceName")).sendKeys("Beng");

        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);

        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);

        // selenium can not identify hidden elements - (Ajax implementations)
        System.out.println(driver.findElement(By.id("fromPlaceName")).getText());

        // Javascript DOM can handling hidden elements
        // investigate the properties of element (object) if it have any hidden text

        // JavascriptExecutor - selenium help for hidden text

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String scriptInJavaScript = "return document.getElementById(\"fromPlaceName\").value;";

        String text = (String) js.executeScript(scriptInJavaScript);

        System.out.println(text);

    }
}
