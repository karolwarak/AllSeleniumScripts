package _3_action_class_ajax_iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

        // composite interactions -> exactly the same steps that user have to do to type sth in search bar
        pointer.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        pointer.moveToElement(accountAndListsElement).contextClick().build().perform();
        // contextClick() - right click of mouse
    }
}
