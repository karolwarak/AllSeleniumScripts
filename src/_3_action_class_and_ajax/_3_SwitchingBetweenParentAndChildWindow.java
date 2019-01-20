package _3_action_class_and_ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class _3_SwitchingBetweenParentAndChildWindow {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Pomoc']")).click();

        System.out.println(driver.getTitle()); // selenium will get parent window title (this from get)
        // By default Selenium will stick to parent window only until you switch the window

        Set<String> allOpenWindowsIds = driver.getWindowHandles();
        for (String windowHandleName : allOpenWindowsIds){
            System.out.println(windowHandleName);
        }

        Iterator<String> windowId = allOpenWindowsIds.iterator();

        String parentId = windowId.next();

        String childId = windowId.next();

        driver.switchTo().window(childId);
        // now can perform all the operations on child window

        System.out.println(driver.getTitle()); // window switched successfully because I got different title

        driver.switchTo().window(parentId);

        System.out.println(driver.getTitle());

    }
}
