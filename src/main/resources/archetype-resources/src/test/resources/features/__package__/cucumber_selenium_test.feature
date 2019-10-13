@web
Feature: Testing basic functionality of a web page

    This feature shows an example of how to test a web application using Selenium. Please, notice that
    the @web annotation in the beginning of the feature is NECESSARY since it indicates the library to
    bootstrap some necessary dependencies. Failing to do so will make your feature fail.

    You can run this feature using the following command:

    mvn verify -Dit.test=${groupId}.${artifactId}.${package}.CucumberSeleniumIT -DSELENIUM_GRID=127.0.0.1:4444

    P.S. Besides using your local browser, you can specify a selenium grid and even a Selenium standalone node
    for running selenium tests. For more information about this, check the wiki of gingerspec at:
    https://github.com/PrivaliaTech/gingerspec/wiki/Running-Selenium-tests

    You can check a more complete list of selenium steps and examples at:
    https://github.com/PrivaliaTech/gingerspec/wiki/Selenium-steps

    Scenario: Verify that there are two main sections "Interactions" and "Widgets"
        Given My app is running in 'demoqa.com:80'
        And I browse to '/'
        When '2' elements exists with 'class:widget-title'
        And I wait '1' seconds

    Scenario: This is the same scenario as above, but in one line, using custom steps
        Given I verify the Interactions and Widgets sections are present

    Scenario: Write text on a text input
        Given My app is running in 'demoqa.com:80'
        And I browse to '/autocomplete'
        When '1' elements exists with 'id:tags'
        Then I type 'Java' on the element on index '0'
        And I wait '1' seconds