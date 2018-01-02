Feature: To test the integration of TestNg

Scenario: To test the button helper class
	When I click on the "New" link
	Then I should be redirected to the login page
	When I provide the username and password and click on login button
	Then I should be logged in
	And I click on log out