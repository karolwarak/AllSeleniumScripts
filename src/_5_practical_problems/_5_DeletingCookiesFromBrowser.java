package _5_practical_problems;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _5_DeletingCookiesFromBrowser {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.globalsign.com/en/ssl-information-center/what-is-an-ssl-certificate/");

        // deleting all cookies
        driver.manage().deleteAllCookies();

        // delete one cookie found by name
        //driver.manage().deleteCookieNamed("ANON");


    }
}
