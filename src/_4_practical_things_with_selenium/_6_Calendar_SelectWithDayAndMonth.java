package _4_practical_things_with_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class _6_Calendar_SelectWithDayAndMonth {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/geckodriver-v0.23.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();

        //select April 6

        driver.findElement(By.id("travel_date")).click();

        // search for wright month according to text that have web element
        // write most generic locator for the label where is word with month
        while(!(driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"))).getText().contains("April 2019")){
                driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev']")).click();
        }

        // logic -> 1) grab common attribute 2) put into list 3) iterate
        List<WebElement> days = driver.findElements(By.className("day"));
        int count = days.size();

        for(int i=0; i<count; i++){

            String dayOfMonth = days.get(i).getText();
            if(dayOfMonth.equals("6")){
                days.get(i).click();
                break;
            }
        }
    }
}
