package _1_basic;// all classes with .selenium are loaded from jars

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_StartupWithSelenium {

    public static void main(String[] args) {

        // 4. download Third Party Browser Drivers for proper OS and set properties

        // System.setProperty("key value", "third party browser driver path")

        // webdriver.chrome.driver - key value for Chrome browser
        // webdriver.gecko.driver - key value for Firefox browser
        // webdriver.ie.driver - key value for Internet Explorer browser

        // invoke .exe file first

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");

        // 1. download selenium client version for java from
        // 2. https://www.seleniumhq.org/download/
        // 3. and add all jar files to project

        // create ChromeDriver object for chrome browser
        // but to have all methods from interface WebDriver object should have type WebDriver

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.phptravels.net/"); // get this url on the browser

        System.out.println(driver.getTitle()); // print title of current open page

        // I can validate if I landed on correct url, check url for security purpose
        System.out.println(driver.getCurrentUrl()); // print url from current open page

        // use when right click then view page source is unavailable in browser (bank websites)
        System.out.println(driver.getPageSource()); // print page source from current open page


        // ---- browser navigate section ----

        driver.get("https://www.google.com/"); // open new url on the same browser card (tab)

        driver.navigate().back(); // click left arrow (navigate back) in the browser

        driver.navigate().forward(); // click right arrow (navigate forward) in the browser

        driver.navigate().refresh(); // refresh current page

        driver.close(); // close current browser

        driver.quit(); // close all browsers opened by selenium script
    }
}
