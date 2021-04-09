package ua.deti.pedros50.SauceLabsStack;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Unit test for simple App.
 */
public class AppTest
{
    private WebDriver browser;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/pedro/chromedriver_linux64/chromedriver");
        browser = new ChromeDriver();
    }

    @AfterEach
    public void cleanUp() {
        browser.close();
    }

    @Test
    public void site_header_is_on_home_page() { 
        browser.get("https://www.saucelabs.com"); 
        browser.manage().window().maximize();
        WebElement href = browser.findElement(By.xpath("//a[@href='https://accounts.saucelabs.com/']"));        

        assertTrue((href.isDisplayed()));
    }
}
