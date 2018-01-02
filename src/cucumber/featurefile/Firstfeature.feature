Feature: Login page of Bugzila
  To test the login page of Bugzila web site
  #Ft-Id : 17892
  #US-Id : 16695

  Scenario: Login with valid userid and password
    Given I should be at the login page
    And I provide valid userid and password
    When I click on login button
    Then I should be able to login inside the bugzila
    And The title of web page should be Bugzila Main page
