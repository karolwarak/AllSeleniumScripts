package synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class _2_ExplicitWaitExample {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://alaskatrips.poweredbygps.com/");
        driver.manage().window().maximize();

        // if element is displayed before 3 seconds it will continue execution
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//label[@for='hotel-car-package-type-hp-package']")).click();
        WebElement goingToField = driver.findElement(By.xpath("//input[@id='hotel-destination-hp-package']"));
        goingToField.sendKeys("nyc");
        //goingToField.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[@class='display-group-results']/child::li[1]")).click();

        driver.findElement(By.id("package-hc-departing-hp-package")).click();

        while (!(driver.findElement(By.className("datepicker-cal-month-header"))).getText().contains("May 2019")) {
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

        //explicit wait
        WebDriverWait waitingForPageWithHotels = new WebDriverWait(driver, 15);

        // all depends on what condition I will pass to my test
        //waitingForPageWithHotels.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@target='41864']")));
        // waiting for element on new page - like positive scenario

        //waitingForPageWithHotels.until(ExpectedConditions.invisibilityOfElementLocated(By.id("tva-li-1-text")));
        // waiting for element on loading page to disappear from page - like negative scenario

        waitingForPageWithHotels.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@target='41864']")));
        // wait for a specific element until you can click on it
        // it can be on the page you are waiting to be load

        driver.findElement(By.xpath("//a[@target='41864']")).click();
    }
}
