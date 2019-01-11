import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NumberOfPeopleHotelMenu {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/");
        driver.manage().window().maximize();

        driver.findElement(By.id("travellersInput")).click();

        int i = 0;
        while (i < 2) {
            driver.findElement(By.id("adultPlusBtn")).click(); // click twice in button plus adults = 4 adults
            i++;
        }

        for (int j = 0; j < 2; j++) {
            driver.findElement(By.id("childPlusBtn")).click(); // click twice in button plus child = 2 child
        }

        System.out.println( driver.findElement(By.id("travellersInput")).getText());
        // nic sie nie wyswietla bo tam nie ma textu to jak zwalidowac poprawnie wybrane osoby???
    }
}