import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class _9_End2End {

    @Test
    public void bookingOneWayFlight() {

        System.setProperty("webdriver.gecko.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/geckodriver-v0.23.0-linux64/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        WebElement oneWayRadiobutton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));

        if(!(oneWayRadiobutton.isSelected())) {
            oneWayRadiobutton.click();
        }

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@value='MAA'])[2]"))));

        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']")).click();

        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.id(".ui-state-default.ui-state-highlight.ui-state-active")));
        // test stop in this line for chrome browser

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

        //check if calendar field *RETURN DATE is disable
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("Element is disable from UI perspective");
            assertTrue(true);
        } else {
            System.out.println("Element is enabled from UI perspective");
            assertTrue(false);
        }

        WebElement numberOfPassengeers = driver.findElement(By.id("divpaxinfo"));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("divpaxinfo")));

        numberOfPassengeers.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));

        driver.findElement(By.id("hrefIncAdt")).click();

        for(int i=0; i<2; i++) {
            driver.findElement(By.id("hrefIncChd")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        assertThat(numberOfPassengeers.getText()).as("Number of selected passengers are incorrect").isEqualTo("2 Adult, 2 Child");

        Select currencyDropdownMenu = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
        currencyDropdownMenu.selectByValue("USD");

        WebElement familyAndFriendsCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        if(!(familyAndFriendsCheckbox.isSelected())){
            familyAndFriendsCheckbox.click();
        }

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='OneWay']")));

        WebElement tripLabelOneWay = driver.findElement(By.xpath("//span[text()='OneWay']"));
        assertThat(tripLabelOneWay.getText()).as("Departure Flight web page does not open").isEqualTo("OneWay");
    }
}
