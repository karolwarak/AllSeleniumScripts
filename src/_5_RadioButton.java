import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _5_RadioButton {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/geckodriver-v0.23.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();


    }
}