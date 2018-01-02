$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/featurefile/ArgumentFeature.feature");
formatter.feature({
  "id": "to-see-how-the-argument-are-supplied",
  "description": "",
  "name": "To see how the argument are supplied",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "to-see-how-the-argument-are-supplied;to-supply-the-argument-in-the-steps",
  "description": "",
  "name": "To supply the argument in the steps",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "I open the bugzila home page with \"http://www.google.com\"",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "I provide the search text as \"Search\"",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "Click on search \"Search 1\" and \"Search 2\"",
  "keyword": "And ",
  "line": 6
});
formatter.step({
  "name": "Check for responce time 12",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.google.com",
      "offset": 35
    }
  ],
  "location": "ArgumentStepDfn.i_open_the_bugzila_home_page_with(String)"
});
formatter.result({
  "duration": 4714821,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Search",
      "offset": 30
    }
  ],
  "location": "ArgumentStepDfn.i_provide_the_search_text_as(String)"
});
formatter.result({
  "duration": 85527,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Search 1",
      "offset": 17
    },
    {
      "val": "Search 2",
      "offset": 32
    }
  ],
  "location": "ArgumentStepDfn.click_on_search_and(String,String)"
});
formatter.result({
  "duration": 102633,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "12",
      "offset": 24
    }
  ],
  "location": "ArgumentStepDfn.check_for_responce_time(int)"
});
formatter.result({
  "duration": 143115,
  "status": "passed"
});
formatter.uri("cucumber/featurefile/Firstfile.feature");
formatter.feature({
  "id": "bugzilla-feature-file",
  "description": "",
  "name": "Bugzilla feature file",
  "keyword": "Feature",
  "line": 1
});
formatter.scenario({
  "id": "bugzilla-feature-file;to-check-the-login-functionality-of-bugzila-page",
  "description": "",
  "name": "To check the login functionality of bugzila page",
  "keyword": "Scenario",
  "line": 3,
  "type": "scenario"
});
formatter.step({
  "name": "I open the bugzila home page",
  "keyword": "Given ",
  "line": 4
});
formatter.step({
  "name": "I provide the username and password",
  "keyword": "When ",
  "line": 5
});
formatter.step({
  "name": "Click on login button",
  "keyword": "And ",
  "line": 6
});
formatter.step({
  "name": "Homepage of Bugzila should open",
  "keyword": "Then ",
  "line": 7
});
formatter.match({
  "location": "Firstfile.i_open_the_bugzila_home_page()"
});
formatter.result({
  "duration": 750928,
  "status": "failed",
  "error_message": "java.lang.NullPointerException\r\n\tat helper.WindowHelper.navigateToPage(WindowHelper.java:67)\r\n\tat cucumber.stepdefination.Firstfile.i_open_the_bugzila_home_page(Firstfile.java:36)\r\n\tat ✽.Given I open the bugzila home page(cucumber/featurefile/Firstfile.feature:4)\r\n"
});
formatter.match({
  "location": "Firstfile.i_provide_the_username_and_password()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Firstfile.click_on_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Firstfile.homepage_of_Bugzila_should_open()"
});
formatter.result({
  "status": "skipped"
});
});