package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _1_FirstSynchronizationScript {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://alaskatrips.poweredbygps.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//label[@for='hotel-car-package-type-hp-package']")).click();
        WebElement goingToField = driver.findElement(By.xpath("//input[@id='hotel-destination-hp-package']"));
        goingToField.sendKeys("nyc");
        //goingToField.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[@class='display-group-results']/child::li[1]")).click();

        driver.findElement(By.id("package-hc-departing-hp-package")).click();

        while(!(driver.findElement(By.className("datepicker-cal-month-header"))).getText().contains("May 2019")){
            driver.findElement(By.cssSelector(".datepicker-paging.datepicker-next.btn-paging.btn-secondary.next")).click();
        }

        /*List<WebElement> days = driver.findElements(By.className("datepicker-cal-date"));
        int count = days.size();

        for(int i=0; i<count; i++){
            String dayOfMonth = days.get(i).getText();
            if(dayOfMonth.equals("7")){
                days.get(i).click();
            }
        }*/

        driver.findElement(By.xpath("//button[@data-day='7']")).click();
        //driver.findElement(By.xpath("//button[@id='search-button-hp-package']")).click();
        //driver.findElement(By.xpath("//label[@class='col search-btn-col']/child::button")).click();

        driver.findElement(By.id("package-hc-returning-hp-package")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//a[contains(@href, 'ttla=JFK&toDate')]")).click();

        driver.findElement(By.xpath("//a[@target='41864']")).click();
    }
}