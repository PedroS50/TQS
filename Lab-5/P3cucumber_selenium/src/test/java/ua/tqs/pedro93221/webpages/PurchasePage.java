package ua.tqs.pedro93221;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PurchasePage {
	private WebDriver driver;

	@FindBy(id="inputName")
	private WebElement inputName;

	@FindBy(id="address")
	private WebElement address;

	@FindBy(id="city")
	private WebElement city;

	@FindBy(id="state")
	private WebElement state;

	@FindBy(id="zipCode")
	private WebElement zipCode;

	@FindBy(id="cardType")
	private WebElement cardType;

	@FindBy(id="creditCardNumber")
	private WebElement ccNumber;

	@FindBy(id="creditCardMonth")
	private WebElement ccMonth;

	@FindBy(id="creditCardYear")
	private WebElement ccYear;

	@FindBy(id="nameOnCard")
	private WebElement ccName;

	@FindBy(css=".btn-primary")
	private WebElement purchaseFlightBtn;

	//Constructor
	public PurchasePage (WebDriver driver){
		this.driver=driver;

       //Initialise Elements
       PageFactory.initElements(driver, this);
       driver.manage().window().maximize();
	}

	public void fillName (String full_name) {
		inputName.clear();
       	inputName.sendKeys(full_name);
	}

	public void fillAddress (String in_address) {
		address.clear();
       	address.sendKeys(in_address);
	}

	public void fillState (String in_state) {
		state.clear();
       	state.sendKeys(in_state);
	}

	public void fillCity (String in_city) {
		city.clear();
       	city.sendKeys(in_city);
	}

	public void fillZipCode (String in_zipCode) {
		zipCode.clear();
       	zipCode.sendKeys(in_zipCode);
	}

	public void fillCCNumber (String in_ccNumber) {
		ccNumber.clear();
       	ccNumber.sendKeys(in_ccNumber);
	}

	public void fillCCMonth (String in_ccMonth) {
		ccMonth.clear();
		ccMonth.sendKeys(in_ccMonth);
	}

	public void fillCCYear (String in_ccYear) {
		ccYear.clear();
		ccYear.sendKeys(in_ccYear);
	}

	public void fillCCName (String in_ccName) {
		ccName.clear();
		ccName.sendKeys(in_ccName);
	}

	public void clickPurchaseFlightButton() {
		purchaseFlightBtn.click();
	}
}