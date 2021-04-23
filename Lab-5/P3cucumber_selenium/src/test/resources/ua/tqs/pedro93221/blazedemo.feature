Feature: Blaze Test Demo

  Scenario: Select and buy a trip
    When I access "https://blazedemo.com/"
	Then I verify that the title is "BlazeDemo"
	Then I choose my departure as "Paris"
	And I choose my destination as "London"
	When I click the Find Flights button
	Then I verify that the new page's header states "Flights from Paris to London:"
	When I press the second flight from the available options
	Then The purchase page opens with the title "BlazeDemo Purchase"
	And I fill in the name as "Pedro Santos"
	And I fill the CC number as "123123123123"
	Then I press the Purchase Flight button
	And I verify that the confirmation page's header states "Thank you for your purchase today!"
	And I verify that the confirmation page's title is "BlazeDemo Confirmation"
	Then I close the webpage