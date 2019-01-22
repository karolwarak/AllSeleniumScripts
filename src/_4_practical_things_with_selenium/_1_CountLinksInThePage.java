package _4_practical_things_with_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_CountLinksInThePage {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        // every link on the page should have tag <a>

        // print number of all links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerDriver = driver.findElement(By.xpath("//footer[@class='clearfix simple']"));

        // limiting driver scope
        // footerDriver acts like a driver but only for footer section
        System.out.println(footerDriver.findElements(By.tagName("a")).size());
    }
}
