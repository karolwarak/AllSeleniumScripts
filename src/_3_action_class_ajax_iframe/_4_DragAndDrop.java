package _3_action_class_ajax_iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _4_DragAndDrop {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        // can select iframe using index but it is not a generic solution because
        // when developer add new iframe, numeration will be outdated

        //driver.switchTo().frame(0); // iframe are number from 0

        // I will get number of iframes on the page
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        // at first I have to switch to the iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //draggableElement.click();

        // then I can locate elements
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement droppableElement = driver.findElement(By.id("droppable"));

        Actions move = new Actions(driver);

        move.dragAndDrop(draggableElement, droppableElement).build().perform();

        // get out of iframes and switch to the normal window
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//a[text()='Accept']")).click();
    }
}
