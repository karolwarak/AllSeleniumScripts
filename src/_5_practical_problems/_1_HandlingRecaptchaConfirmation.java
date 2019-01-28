package _5_practical_problems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _1_HandlingRecaptchaConfirmation {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();

/*      System.setProperty("webdriver.gecko.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/geckodriver-v0.23.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();*/
        driver.get("https://9gag.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@class='button_button--lgX0P intro_acceptAll--23PPA ']")).click();
        driver.findElement(By.id("jsid-signup-button")).click();
        driver.findElement(By.xpath("//a[text()='Email Address']")).click();

        WebDriverWait waitingForIframe = new WebDriverWait(driver, 15);
        waitingForIframe.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

        int frameNumber = findFrameNumberWithCheckboxElement(driver, By.xpath("//*[@id='recaptcha-anchor']/div[5]"));

        //driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'google.com/recaptcha/api2')]")));

        driver.switchTo().frame(frameNumber);

        WebDriverWait waitingForCheckbox = new WebDriverWait(driver, 10);
        waitingForCheckbox.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='recaptcha-anchor']/div[5]")));

        driver.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[5]")).click();
    }

    // I HAVE PROBLEM WITH FINDING CHECKBOX IN CORRECT ?? (I THINK) IFRAME

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
            } else {
                driver.switchTo().defaultContent();
            }
        }

        driver.switchTo().defaultContent();

        // return number of iframe that have checkbox that I need
        return i;
    }
}