package _5_practical_problems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _1_HandlingRecaptchaConfirmation {

    public static void main(String[] args) {

        /*System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();*/

        System.setProperty("webdriver.gecko.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/geckodriver-v0.23.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://9gag.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@class='button_button--lgX0P intro_acceptAll--23PPA ']")).click();
        driver.findElement(By.id("jsid-signup-button")).click();
        driver.findElement(By.xpath("//a[text()='Email Address']")).click();

        //System.out.println(driver.findElements(By.tagName("iframe")).size());

        int frameNumber = findFrameNumberWithCheckboxElement(driver, By.xpath("//*[@id='recaptcha-anchor']/div[5]"));

        driver.switchTo().frame(frameNumber);

        driver.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[5]")).click();
    }


    // I HAVE PROBLEM WITH IFRAMES. IN THIS METHOD WHILE DEBUG LOOP I GET MESSAGE "Frames are not available"? Why ??
    // IT LOOKS LIKE I LOST DATA

    public static int findFrameNumberWithCheckboxElement(WebDriver driver, By by) {

        int i;

        // number of iframe in application is equal to number of iframe tags
        int frameCount = driver.findElements(By.tagName("iframe")).size();

        // using this loop I will search through all the iframes in the page
        for (i = 0; i < frameCount; i++) {

            driver.switchTo().frame(i);

            // if 0 - element is not at this iframe || if 1 - element is on the page
            int countCheckboxesInFrame = driver.findElements(by).size();

            if (countCheckboxesInFrame > 0) {
                //driver.findElement(by).click();
                break; // when I found earlier the element I quite the loop
            }
        }

        driver.switchTo().defaultContent();

        // return number of iframe that have checkbox that I need
        return i;
    }
}