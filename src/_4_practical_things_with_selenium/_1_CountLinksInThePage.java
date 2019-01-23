package _4_practical_things_with_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class _1_CountLinksInThePage {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // every link on the page should have tag <a>

        // print number of all links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        // limiting webdriver scope by created variable for footer section
        WebElement footerDriver = driver.findElement(By.xpath("//footer[@class='clearfix simple']"));

        // footerDriver acts like a driver but only for footer section
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //limited section of footerDriver to only 6 links in this footer
        WebElement footerSiteLinksDriver = footerDriver.findElement(By.xpath("//ul[@class='footer-site-links']"));

        int numberOfFooterSiteLinks = footerSiteLinksDriver.findElements(By.tagName("a")).size();

        System.out.println(numberOfFooterSiteLinks);

        // click on each link in the footer site links and check if the page are opening
        // generic solution -> check how many links are present and click in every link individual

        // open 6 links in different tabs
        for (int i = 0; i < numberOfFooterSiteLinks; i++) {

            // can click 2 keys in one time ctrl + enter (ctrl + enter = open link in a new tab)
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);

            footerSiteLinksDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
        }

        Set<String> allOpenWindowsIds = driver.getWindowHandles();

        Iterator<String> windowId = allOpenWindowsIds.iterator();

        //String parentWindowId = windowId.next();

        /*for (String allWindowsIds : allOpenWindowsIds) {
            // if parent window is open the only need to is print title
            if (parentWindowId.equals(allWindowsIds)){
                System.out.println(driver.getTitle());
            } else{
                // if not parent window switch to enother window and get title
                driver.switchTo().window(allWindowsIds);
                System.out.println(driver.getTitle());
            }
        }*/

        while (windowId.hasNext()) {
            // it will start from parent window
            driver.switchTo().window(windowId.next());
            System.out.println(driver.getTitle());
        }
        // go back to parent window after open all tabs
        // driver.switchTo().window(parentWindowId);
    }
}
