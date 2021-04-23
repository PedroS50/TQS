package ua.tqs.pedro93221;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ConfirmationPage {
	private WebDriver driver;

	@FindBy(tagName="h1")
	private WebElement header;


	//Constructor
	public ConfirmationPage (WebDriver driver){
		this.driver=driver;

       //Initialise Elements
       PageFactory.initElements(driver, this);
       driver.manage().window().maximize();
	}

	public String getHeader() {
		return header.getText().toString();
	}

}