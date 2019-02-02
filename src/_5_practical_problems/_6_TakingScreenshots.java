package _5_practical_problems;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class _6_TakingScreenshots {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://alaskatrips.poweredbygps.com/");
        driver.manage().window().maximize();

        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(sourceFile, new File("/home/karol/Downloads/screenshot.png"));

    }
}
