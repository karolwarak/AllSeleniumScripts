package _5_practical_problems;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class _4_HandlingSslCertifications {

    public static void main(String[] args) {

        // added extra capabilities to my chrome driver
        //

        // general chrome profile
        DesiredCapabilities extraCapabilities = DesiredCapabilities.chrome();
        //extraCapabilities.acceptInsecureCerts();

        // accept both certifications when they appear on site
        extraCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        extraCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        // belongs to my local browser profile
        ChromeOptions driverOptions = new ChromeOptions();

        // inject general chrome profile to local chrome browser
        driverOptions.merge(extraCapabilities);

        System.setProperty("webdriver.chrome.driver", "/home/karol/ProjectsJAVA/SeleniumTraining/chromedriver_linux64/chromedriver");

        // inject local chrome profile to actual open chrome browser
        WebDriver driver = new ChromeDriver(driverOptions);







    }
}
