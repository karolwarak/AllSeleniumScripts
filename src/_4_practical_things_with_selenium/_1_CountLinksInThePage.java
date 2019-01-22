package _4_practical_things_with_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class _1_CountLinksInThePage {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        // every link on the page should have tag <a>

        // print number of all links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        // limiting webdriver scope by created variable for footer section
        WebElement footerDriver = driver.findElement(By.xpath("//footer[@class='clearfix simple']"));

        // footerDriver acts like a driver but only for footer section
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //limited section of footerDriver
        WebElement footerSiteLinksDriver = footerDriver.findElement(By.xpath("//ul[@class='footer-site-links']"));

        int numberOfFooterSiteLinks = footerSiteLinksDriver.findElements(By.tagName("a")).size();

        System.out.println(numberOfFooterSiteLinks);

        // click on each link in the footer site links and check if the page are opening
        // generic solution -> check how many links are present and click in every link individual

        // open 6 links in different tabs
        for(int i=0; i<numberOfFooterSiteLinks; i++){

            // can click 2 keys in one time ctrl + enter (ctrl + enter = open link in a new tab)
            String ckickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);

            footerSiteLinksDriver.findElements(By.tagName("a")).get(i).sendKeys(ckickOnLink);
        }
    }
}
