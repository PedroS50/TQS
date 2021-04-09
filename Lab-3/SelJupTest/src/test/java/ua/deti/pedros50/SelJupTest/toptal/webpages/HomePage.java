package ua.deti.pedros50.SelJupTest.total.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
   private WebDriver driver;

   //Page URL
   private static String PAGE_URL="https://www.toptal.com";

   //Locators

   //Apply as Freelancer Button
   @FindBy(how = How.LINK_TEXT, using = "Apply as a Freelancer")
   private WebElement freelancerApplyButton;

   //Constructor
   public HomePage(WebDriver driver){
       this.driver=driver;
       driver.get(PAGE_URL);
       //Initialise Elements
       PageFactory.initElements(driver, this);
	   driver.manage().window().maximize();
   }

   public void clickOnFreelancerApplyButton(){

       freelancerApplyButton.click();

   }
}