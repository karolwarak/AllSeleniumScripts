import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _4_AutoSuggestiveDropdownMenu {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        WebElement fromField = driver.findElement(By.id("hp-widget__sfrom"));

        fromField.clear(); // wipeout all default data in this field
        fromField.sendKeys("Mum");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[text()='Search Result']"))));

        // item Search Result appear in the list after typing mum
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Search Result']")));

        fromField.sendKeys(Keys.ENTER); // Keys is enum with all keyboard event

        WebElement toField = driver.findElement(By.id("hp-widget__sTo"));
        toField.clear();
        toField.sendKeys("Del");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[text()='Search Result'])[2]")));
        // or (the same effect)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='locationFilter autocomplete_to']//li[text()='Search Result']")));
        toField.sendKeys(Keys.ARROW_DOWN);
        toField.sendKeys(Keys.ENTER);
    }
}