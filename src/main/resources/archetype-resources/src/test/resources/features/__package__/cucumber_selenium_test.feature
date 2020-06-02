@web
Feature: Testing basic functionality of a web page

    This feature shows an example of how to test a web application using Selenium. Please, notice that
    the @web annotation in the beginning of the feature is NECESSARY since it indicates the library to
    bootstrap some necessary dependencies. Failing to do so will make your feature fail.

    You can run this feature using the following command:
    mvn verify -Dit.test=${groupId}.${artifactId}.${package}.CucumberSeleniumIT

    Or run it by tag like this>
    mvn verify -Dcucumber.options="--tags @web"

    P.S. Besides using your local browser, you can specify a selenium grid and even a Selenium standalone node
    for running selenium tests. For more information about this, check the wiki of gingerspec at:
    https://github.com/PrivaliaTech/gingerspec/wiki/Running-Selenium-tests

    You can check a more complete list of selenium steps and examples at:
    https://github.com/PrivaliaTech/gingerspec/wiki/Selenium-steps
    https://privaliatech.github.io/gingerspec/com/privalia/qa/specs/SeleniumGSpec.html

    Scenario: Fill the form and click the submit button
        Given I go to 'http://demoqa.com/text-box'
        And I type 'John' on the element with 'id:userName'
        And I type 'john.smith@email.com' on the element with 'id:userEmail'
        And I type '123 fake address' on the element with 'id:currentAddress'
        When I scroll down until the element with 'id:submit' is visible
        And I click on the element with 'id:submit'
        Then at least '1' elements exists with 'id:output'

    Scenario: This is the same scenario as above, but in one line, using custom steps
        Given Fill the form and click the submit button

    Scenario: Write text on a text input
        Given My app is running in 'demoqa.com'
        Given I browse to '/radio-button'
        And I click on the element with 'xpath://input[@id='yesRadio']/following-sibling::label'
        And at least '1' elements exists with 'id:yesRadio'
        And the element on index '0' IS selected
        And I wait '3' seconds
        Given I browse to '/buttons'
        And I double click on the element with 'id:doubleClickBtn'
        And I right click on the element with 'id:rightClickBtn'
        And I click on the element with 'xpath://button[.='Click Me']'