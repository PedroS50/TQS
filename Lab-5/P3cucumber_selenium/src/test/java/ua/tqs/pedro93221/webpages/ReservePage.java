package ua.tqs.pedro93221;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReservePage {
	private WebDriver driver;

	@FindBy(tagName="h3")
	private WebElement header;

	@FindBy(css="tr:nth-child(2) .btn")
	private WebElement flightOption;

	//Constructor
	public ReservePage	(WebDriver driver){
		this.driver=driver;

       //Initialise Elements
       PageFactory.initElements(driver, this);
       driver.manage().window().maximize();
	}

	public String getHeader() {
		return header.getText().toString();
	}

	public void chooseFlight() {
		flightOption.click();
	}
}