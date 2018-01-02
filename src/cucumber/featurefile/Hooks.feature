Feature: Cucumber Hooks

  Background: 
    Given User is at Bugzila login page with "http://localhost:5001/"

  @firefox
  Scenario: To check for the Home link
    When I click on "Home" link
    Then the title should be "Bugzilla Main Page1"
    And I close the browser

  @firefox
  Scenario: To check for the Home link
    #Given User is at Bugzila login page with "http://localhost:5001/"
    When I click on "New" link
    Then the title should be "Log in to Bugzilla"
    And I close the browser

  @chrome
  Scenario: To check for the Home link
    #Given User is at Bugzila login page with "http://localhost:5001/"
    When I click on "Browse" link
    Then the title should be "Browse"
    And I close the browser

  @chrome
  Scenario: To check for the Home link
    #Given User is at Bugzila login page with "http://localhost:5001/"
    When I click on "Reports" link
    Then the title should be "Reporting and Charting Kitchen"
    And I close the browser
