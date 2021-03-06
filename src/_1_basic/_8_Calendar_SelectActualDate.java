package _1_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _8_Calendar_SelectActualDate {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        // check if element is enabled on web page (check if I can click on the element and get some action)

        //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled()); // this should be false because field is grey
        // it looks like disable (done in HTML code) from UI perspective
        // but when I click, it is enable that is why Selenium does not see different
        //driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

        // work around if isEnable() method does not give expected results
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

        // validation on attribute level to see if the element state is change or not
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
            System.out.println("Element is enabled from UI perspective");
        } else {
            System.out.println("Element is disable from UI perspective");
        }

        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

        // select current date, it have 2 classes more (because it has different color) which easy identify it
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
    }
}
