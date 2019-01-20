package _1_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.assertj.core.api.Assertions.*;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class _7_CheckBox_And_Assertions {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement familyAndFriendsCheckbox = driver.findElement(By.cssSelector("input[name*='_friendsandfamily']"));

        //System.out.println(familyAndFriendsCheckbox.isSelected()); // return boolean value of checkbox status

        // AssertJ assertion
        //assertThat(false).as("Checkbox is selected").isEqualTo(familyAndFriendsCheckbox.isSelected());

        //JUnit assertion - krotsza niz w AssertJ
        assertFalse("Checkbox is selected", familyAndFriendsCheckbox.isSelected());

        familyAndFriendsCheckbox.click();

        //System.out.println(familyAndFriendsCheckbox.isSelected());
        assertTrue("Checkbox is not selected", familyAndFriendsCheckbox.isSelected());

        int numberOfCheckboxes = driver.findElements(By.xpath("//input[contains(@name, 'ctl00$mainContent$chk_')]")).size();
        assertThat(numberOfCheckboxes).as("There is no 6 checkboxes on the web page").isEqualTo(5);
        // assertThat(actual - what is on site = what selenium script is return !!!).isEqualTo(expected - what should be on site);
    }
}
