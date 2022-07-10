@web
Feature: Testing basic functionality of a web page

  This is an example of how to use the provided Selenium steps of GingerSpec to perform actions on a web page. This
  example uses https://testpages.herokuapp.com, a fake online web page for testing

  Steps documentation  -> https://github.com/veepee-oss/gingerspec/wiki/Gherkin-steps#selenium-steps
  Run this in terminal -> mvn verify -Dcucumber.filter.tags="@web"
  Run in IntellijIDEA  -> https://github.com/veepee-oss/gingerspec/wiki/Setting-up-your-IDE#running-cucumber-test

  Scenario: Fill the form and click the submit button
    Given I go to 'https://testpages.herokuapp.com/styled/basic-html-form-test.html'
    And I type 'John' on the element with 'name:username'
    And I type '12345678' on the element with 'name:password'
    And I type on the element with 'name:comments' the text:
      """
         249 avenue du Président Wilson
         LA PLAINE SAINT DENIS (93210)
         FRANCE
      """
    When I select 'Drop Down Item 1' on the element with 'name:dropdown'
    And I click on the element with 'name:submitbutton' index '1'


  Scenario: Wait until the element is present
    Given I go to 'https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html'
    And I click on the element with 'id:button00'
    And I wait until element with 'id:button01' is present
    And I click on the element with 'id:button01'


  Scenario: This is an example of a custom Selenium step
    Given Fill the form and click the submit button