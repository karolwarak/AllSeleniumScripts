package _1_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _6_AlertsTypeOf {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();

        // Alert class use only if I can't use locator technique (can not see html code after inspect) on object in window

        // driver object control switched to the alert window (whatever alert is display actually on page)
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept(); //  accept method used for click ok (positive scenario) in alert

        //driver.switchTo().alert().dismiss(); // method for click cancel (negative scenario) in alert
        //driver.switchTo().alert().sendKeys("uzupelnia text box w alercie");


    }
}
