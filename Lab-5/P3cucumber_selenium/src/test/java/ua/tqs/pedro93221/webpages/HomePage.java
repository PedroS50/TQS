package ua.tqs.pedro93221;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	private WebDriver driver;

	@FindBy(name="fromPort")
	private WebElement fromPort;

	@FindBy(name="toPort")
	private WebElement toPort;

	@FindBy(tagName="h1")
	private WebElement header;

	@FindBy(css=".btn-primary")
	private WebElement findFlightsBtn;

	//Apply as Freelancer Button
	@FindBy(how = How.LINK_TEXT, using = "Apply as a Freelancer")
	private WebElement freelancerApplyButton;

	//Constructor
	public HomePage(WebDriver driver, String page_url){
		this.driver=driver;
		driver.get(page_url);
		//Initialise Elements
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
	}

	public void chooseFromCity(String city) {
		Select citySelect = new Select(fromPort);
		citySelect.selectByValue(city);
	}

	public void chooseToCity(String city) {
		Select citySelect = new Select(toPort);
		citySelect.selectByValue(city);
	}

	public void clickFindFlightsButton() {
		findFlightsBtn.click();
	}

	public boolean isPageOpened() {
		return header.getText().toString().contains("Welcome to the Simple Travel Agency!");
	}
}