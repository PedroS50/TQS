package ua.deti.pedros50.SelJupTest;

import ua.deti.pedros50.SelJupTest.total.webpages.FreelancerApplyPage;
import ua.deti.pedros50.SelJupTest.total.webpages.HomePage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.seljup.SeleniumJupiter;

import java.util.concurrent.TimeUnit;

@ExtendWith(SeleniumJupiter.class)
public class AppTest {
    
    // 3a
    @Test
    void testWithOneChrome(ChromeDriver driver) {
        driver.get( "https://www.ua.pt" );
        assertThat( driver.getTitle(), containsString("Universidade de Aveiro") );
    }

    @Test
    void testWithTwoChrome(ChromeDriver driver1, ChromeDriver driver2) {
        driver1.get( "https://www.ua.pt" );
        driver2.get( "https://bonigarcia.github.io/selenium-jupiter/" );
        assertThat( driver1.getTitle(), containsString("Universidade de Aveiro") );
        assertThat( driver2.getTitle(), containsString("JUnit 5 extension for Selenium") );
    }

    // Only works if Firefox is installed
    // @Test
    // void testWithFirefox(FirefoxDriver driver) {
    //     driver.get( "https://www.ua.pt" );
    //     assertThat( driver.getTitle(), containsString("Universidade de Aveiro") );
    // }

    // @Test
    // void testWithChromeAndFirefox(ChromeDriver driver1, FirefoxDriver driver2) {
    //     driver1.get( "https://www.ua.pt" );
    //     driver2.get( "https://bonigarcia.github.io/selenium-jupiter/" );
    //     assertThat( driver1.getTitle(), containsString("Universidade de Aveiro") );
    //     assertThat( driver2.getTitle(), containsString("JUnit 5 extension for Selenium") );
    // }

    // 3b
    @Test
    void testWithHeadlessBrowser(HtmlUnitDriver driver) {
        driver.get( "https://www.ua.pt" );
        assertThat( driver.getTitle(), containsString("Universidade de Aveiro") );
    }

    // 3c
    @Test
    public void testflightpurchase(ChromeDriver driver) {
        driver.get("https://blazedemo.com/");
        driver.manage().window().setSize(new Dimension(1389, 789));
        
        {
          WebElement element = driver.findElement(By.name("fromPort"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).clickAndHold().perform();
        }
        {
          WebElement element = driver.findElement(By.name("fromPort"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.name("fromPort"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).release().perform();
        }
        {
          WebElement dropdown = driver.findElement(By.name("toPort"));
          dropdown.findElement(By.xpath("//option[. = 'London']")).click();
        }
        {
          WebElement element = driver.findElement(By.name("toPort"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).clickAndHold().perform();
        }
        {
          WebElement element = driver.findElement(By.name("toPort"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).perform();
        }
        {
          WebElement element = driver.findElement(By.name("toPort"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).release().perform();
        }

        driver.findElement(By.cssSelector(".btn-primary")).click();

        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Flights from Paris to London:"));

        driver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Pedro Santos");
        driver.findElement(By.cssSelector(".control-group:nth-child(2) > .controls")).click();
        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("123123123123");
        driver.findElement(By.cssSelector(".btn-primary")).click();

        assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("Thank you for your purchase today!"));
        //  Test will fail if the following line is uncommented:
        //assertThat(driver.getTitle(), is("BlazeDeo Confirmation"));
        assertThat(driver.getTitle(), is("BlazeDemo Confirmation"));
    }

    // 4
    @Test
    public void applyAsFreelancer(ChromeDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Create object of HomePage Class
        HomePage home = new HomePage(driver);
        home.clickOnFreelancerApplyButton();

        //Create object of FreelancerApplyPage
        FreelancerApplyPage applyPage =new FreelancerApplyPage(driver);

        //Check if page is opened
        assertThat(applyPage.isPageOpened(), is(true));

        //Fill up data
        applyPage.setFreelancer_email("dejan@toptal.com");
        applyPage.setFreelancer_full_name("Dejan Zivanovic Automated Test");
        applyPage.setFreelancer_password("password123");
        applyPage.setFreelancer_password_confirmation("password123");
        
        //Close driver
        driver.close();
    }
}