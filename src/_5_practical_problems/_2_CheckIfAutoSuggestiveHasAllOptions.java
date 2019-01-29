package _5_practical_problems;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class _2_CheckIfAutoSuggestiveHasAllOptions {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ksrtc.in/oprs-web/");
        driver.manage().window().maximize();

        WebDriverWait waitingForLeavingFromField = new WebDriverWait(driver, 10);
        waitingForLeavingFromField.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromPlaceName")));

        driver.findElement(By.id("fromPlaceName")).sendKeys("Beng");

        WebDriverWait waitingForDropdownMenu = new WebDriverWait(driver, 10);
        waitingForDropdownMenu.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));


        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.UP);

        // selenium can not identify hidden elements - (Ajax implementations)
        System.out.println(driver.findElement(By.id("fromPlaceName")).getText());

        // Javascript DOM can handling hidden elements
        // investigate the properties of element (object) if it have any hidden text

        // JavascriptExecutor - selenium help for hidden text

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // script in JavaScript which will read hidden text
        String scriptInJavaScript = "return document.getElementById(\"fromPlaceName\").value;";

        String text = (String) js.executeScript(scriptInJavaScript);


        while(!text.equalsIgnoreCase("BENGALURU AIRPRT")){

            driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);

            text = (String) js.executeScript(scriptInJavaScript);

            System.out.println(text);
        }
    }
}
