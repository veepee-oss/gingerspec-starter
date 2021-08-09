@web
Feature: Testing basic functionality of a web page

  This is an example of how to use the provided Selenium steps of GingerSpec to perform actions on a web page. For a
  complete list of all steps, check https://github.com/veepee-oss/gingerspec/wiki/Gherkin-steps#selenium-steps

  You can run this feature directly in Intellij IDEA, for more info check:
  https://github.com/veepee-oss/gingerspec/wiki/Setting-up-your-IDE#running-cucumber-test
  Or by running the following command in the terminal: mvn verify -Dcucumber.filter.tags="@web"

  Scenario: Fill the form and click the submit button
    Given I go to 'http://demoqa.com/text-box'
    And I type 'John' on the element with 'id:userName'
    And I type 'john.smith@email.com' on the element with 'id:userEmail'
    And I type '123 fake address' on the element with 'id:currentAddress'
    When I scroll down until the element with 'id:submit' is visible
    And I click on the element with 'id:submit'
    Then at least '1' elements exists with 'id:output'

  Scenario: Interacting with radio buttons and doing double click
    Given I go to 'http://demoqa.com/radio-button'
    And I click on the element with 'xpath://input[@id='yesRadio']/following-sibling::label'
    And at least '1' elements exists with 'id:yesRadio'
    And the element on index '0' IS selected
    And I wait '3' seconds
    Given I go to 'http://demoqa.com/buttons'
    And I double click on the element with 'id:doubleClickBtn'
    And I right click on the element with 'id:rightClickBtn'
    And I click on the element with 'xpath://button[.='Click Me']'

  Scenario: This is an example of a custom Selenium step
    Given Fill the form and click the submit button