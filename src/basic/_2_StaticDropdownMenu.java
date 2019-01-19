package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _2_StaticDropdownMenu {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.phptravels.net/");

        driver.manage().window().maximize();  // maximize browser window

        driver.findElement(By.xpath("//a[@title='Flights']")).click();

        // Select is special class for handling static dropdown menu (with html select tag)
        // apply all methods from Select class for found dropdown menu

        // in tab Flights reservation tab menu
        Select reservationClassesMenu = new Select(driver.findElement(By.xpath("//select[@name='cabinclass']")));

        reservationClassesMenu.selectByValue("business"); // select with attribute value="business"

        reservationClassesMenu.selectByIndex(3); // select third value form menu counting from 0

        reservationClassesMenu.selectByVisibleText("Business");

        // deselect() methods are useful when menu have multiple options to select and I want to deselect some option(s)
    }
}
