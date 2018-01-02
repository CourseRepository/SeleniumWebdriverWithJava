$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/featurefile/Firstfile.feature");
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
  "duration": 4357713485,
  "status": "passed"
});
formatter.match({
  "location": "Firstfile.i_provide_the_username_and_password()"
});
formatter.result({
  "duration": 1641845765,
  "status": "passed"
});
formatter.match({
  "location": "Firstfile.click_on_login_button()"
});
formatter.result({
  "duration": 2244398691,
  "status": "passed"
});
formatter.match({
  "location": "Firstfile.homepage_of_Bugzila_should_open()"
});
formatter.result({
  "duration": 2554955409,
  "status": "passed"
});
});