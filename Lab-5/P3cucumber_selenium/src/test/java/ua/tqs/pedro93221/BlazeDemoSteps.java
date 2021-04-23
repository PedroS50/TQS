package ua.tqs.pedro93221;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class BlazeDemoSteps {
	private WebDriver driver = new ChromeDriver();

	HomePage home;
	ReservePage reserve;
	PurchasePage purchase;
	ConfirmationPage confirmation;

    @When("I access {string}")
	public void i_access(String page_url) {
		home = new HomePage(driver, page_url);
		assertThat(home.isPageOpened(), is(true));
	}

	@Then("I verify that the title is {string}")
	public void i_verify_that_the_title_is(String title) {
		assertThat(driver.getTitle(), is(title));
	}

	@Then("I choose my departure as {string}")
	public void i_choose_my_departure_as(String from) {
		home.chooseFromCity(from);
	}
	
	@Then("I choose my destination as {string}")
	public void i_choose_my_destination_as(String to) {
		home.chooseToCity(to);
	}
	
	@When("I click the Find Flights button")
	public void i_click_the_find_flights_button() {
		home.clickFindFlightsButton();
	}
	
	@Then("I verify that the new page's header states {string}")
	public void i_verify_that_the_new_page_s_header_states(String header) {
		reserve = new ReservePage(driver);
		assertThat( reserve.getHeader(), is(header) );
	}
	
	@When("I press the second flight from the available options")
	public void i_press_the_second_flight_from_the_available_options() {
		reserve.chooseFlight();
	}
	
	@Then("The purchase page opens with the title {string}")
	public void the_purchase_page_opens_with_the_title(String title) {
		purchase = new PurchasePage(driver);
		assertThat( driver.getTitle(), is(title) );
	}
	
	@Then("I fill in the name as {string}")
	public void i_fill_in_the_name_as(String name) {
		purchase.fillName(name);
	}
	
	@Then("I fill the CC number as {string}")
	public void i_fill_the_cc_number_as(String num) {
		purchase.fillCCNumber(num);
	}
	
	@Then("I press the Purchase Flight button")
	public void i_press_the_purchase_flight_button() {
		purchase.clickPurchaseFlightButton();
	}

	@Then("I verify that the confirmation page's header states {string}")
	public void i_verify_that_the_confirmation_page_s_header_states(String header) {
		confirmation = new ConfirmationPage(driver);
		assertThat( confirmation.getHeader(), is(header) );

	}
	@Then("I verify that the confirmation page's title is {string}")
	public void i_verify_that_the_confirmation_page_s_title_is(String title) {
		assertThat( driver.getTitle(), is(title) );
	}

	@Then("I close the webpage")
	public void i_close_the_webpage() {
		driver.close();
	}


}