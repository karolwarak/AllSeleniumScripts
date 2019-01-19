package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _1_FirstSynchronizationScript {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/geckodriver-v0.23.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alaskatrips.poweredbygps.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//label[@for='hotel-car-package-type-hp-package']")).click();
        WebElement goingToField = driver.findElement(By.xpath("//input[@id='hotel-destination-hp-package']"));
        goingToField.sendKeys("nyc");
        goingToField.sendKeys(Keys.ENTER);

        WebElement checkInCalendar = driver.findElement(By.xpath("//input[@id='package-hc-departing-hp-package']"));
        checkInCalendar.click();
        for (int i=0; i<3; i++){
            checkInCalendar.sendKeys(Keys.TAB);
        }
        Thread.sleep(2000);
        checkInCalendar.sendKeys(Keys.ENTER);

    }
}