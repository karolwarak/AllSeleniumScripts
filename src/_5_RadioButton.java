import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _5_RadioButton {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/geckodriver-v0.23.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        // handling radiobutton when I don't have exact locator
        int count = driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).size(); // count how many inputs (radio buttons) are with this name

        for(int i=0; i<count; i++){
            // click all radio buttons one by one
            driver.findElements(By.xpath("//input[@name='ctl00$mainContent$rbtnl_Trip']")).get(i).click();
        }
    }
}