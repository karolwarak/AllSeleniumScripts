import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _7_CheckBox {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement familyAndFriendsCheckbox = driver.findElement(By.cssSelector("input[name*='_friendsandfamily']"));

        System.out.println(familyAndFriendsCheckbox.isSelected()); // return boolean value about checkbox status
        familyAndFriendsCheckbox.click();
        System.out.println(familyAndFriendsCheckbox.isSelected());

        System.out.println(driver.findElements(By.xpath("//input[contains(@name, 'ctl00$mainContent$chk_')]")).size());


    }
}
