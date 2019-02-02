package _5_practical_problems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_HandlingTableGrids {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/21258/wi-vs-eng-2nd-test-england-tour-of-west-indies-2019");
        driver.manage().window().maximize();

        // first get locator of parent then traverse to children with
        // locator (common css) that
        // will select all elements from the the table

        WebElement table = driver.findElement(By.xpath("//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));

        //restricts the search field to a table only
        // now it will search elements only in the table area
        // concept of subsections of elements

        //int rowCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();

        int rowsWithNumberToAdd = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

        int totalSumValue = 0;

        for (int i = 0; i < rowsWithNumberToAdd - 2; i++) {

            String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
            int valueInt = Integer.parseInt(value);
            totalSumValue += valueInt;
        }

        String extras = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div[1]")).getText();
        int extrasValue = Integer.parseInt(extras);
        totalSumValue += extrasValue;

        String actualSum = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div[1]")).getText();
        int actualSumValue = Integer.parseInt(actualSum);

        if (totalSumValue==actualSumValue) {
            System.out.println("Wyniki sie zgadzaja");
        } else {
            System.out.println("Wyniki sie nie zgadzaja");
        }
    }
}
