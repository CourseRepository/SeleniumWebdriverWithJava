Feature: To check for all hyperlink present in the webpage

  Background: 
    Given User should be at the home page "http://localhost:5001/"

  Scenario Outline: To check for links
    When I click on the link "<LinkName>"
    Then I assert for the title "<Title>"
    And I close the browser "<BrowserName>"

    Examples: 
      | LinkName | Title                          | BrowserName |
      | Home     | Bugzilla Main Page             | Iexplorer   |
      | New      | Log in to Bugzilla1            | Firefox     |
      | Browse   | Browse                         | Chrome      |
      | Reports  | Reporting and Charting Kitchen | Safari      |
