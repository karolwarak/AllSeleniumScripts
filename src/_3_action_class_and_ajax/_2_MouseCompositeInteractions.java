package _3_action_class_and_ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _2_MouseCompositeInteractions {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        Actions pointer = new Actions(driver); // pass the driver as argument so driver will have capabilities of Actions class methods

        WebElement accountAndListsElement = driver.findElement(By.cssSelector("#nav-link-accountList"));

        pointer.moveToElement(accountAndListsElement).build().perform();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hello");
    }
}
