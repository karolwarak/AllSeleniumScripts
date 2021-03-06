package _4_practical_things_with_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class _5_Calendar_SelectWithDay {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/geckodriver-v0.23.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.manage().window().maximize();

        //select January 29

        driver.findElement(By.id("travel_date")).click();

        // logic -> 1) grab common attribute 2) put into list 3) iterate
        List<WebElement> days = driver.findElements(By.className("day"));
        int count = days.size();

        for(int i=0; i<count; i++){

            String dayOfMonth = days.get(i).getText();
            if(dayOfMonth.equals("20")){
                days.get(i).click();
                break;
            }
        }
    }
}
