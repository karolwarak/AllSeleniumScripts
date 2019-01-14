import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _4_AutoSuggestiveDropdownMenu {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        driver.findElement(By.id("hp-widget__sfrom")).clear(); // wipeout all default data in this field
        driver.findElement(By.id("hp-widget__sfrom")).sendKeys("mum");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[text()='Search Result']"))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Search Result']")));

        driver.findElement(By.id("hp-widget__sfrom")).sendKeys(Keys.ENTER); // Keys is enum with all keyboard event

    }
}