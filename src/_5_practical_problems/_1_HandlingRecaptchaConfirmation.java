package _5_practical_problems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_HandlingRecaptchaConfirmation {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://9gag.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@class='button_button--lgX0P intro_acceptAll--23PPA ']")).click();
        driver.findElement(By.id("jsid-signup-button")).click();
        driver.findElement(By.xpath("//a[text()='Email Address']")).click();
        driver.switchTo().frame(driver.findElement(By.name("a-1tasl6ahsbrs")));
        driver.findElement(By.className("recaptcha-checkbox-checkmark")).click();

    }

    // number of iframe in application is equal to number of iframe tags
    public void switchToFrame(WebDriver driver) {

        int frameCount = driver.findElements(By.tagName("iframe")).size();

        for (int i = 0; i < frameCount; i++) {
            driver.switchTo().frame(i);

            // if 0 - element is not at this iframe || if 1 - element is on the page
            int countCheckboxeInFrame = driver.findElements(By.className("recaptcha-checkbox-checkmark")).size();

            if(countCheckboxeInFrame>0){
                driver.findElement(By.className("recaptcha-checkbox-checkmark")).click();
            }


        }

    }
}