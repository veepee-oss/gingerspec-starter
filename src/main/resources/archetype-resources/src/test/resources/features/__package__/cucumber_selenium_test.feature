@web
Feature: Testing basic functionality of a web page

    This feature shows an example of how to test a web application using Selenium. Please, notice that
    the @web annotation in the beginning of the feature is NECESSARY since it indicates the library to
    bootstrap some necessary dependencies. Failing to do so will make your feature fail.

    Mind that for any Selenium related feature (like this one), is NECESSARY to indicate the address of
    the Selenium Grid service to execute it, in this way:

    mvn verify -Dit.test=${groupId}.${artifactId}.${package}.CucumberSeleniumIT -DSELENIUM_GRID=127.0.0.1:4444

    Head over https://confluence.vptech.eu/pages/viewpage.action?pageId=5442497 to find more information
    on how to start your own Selenium Grid service to execute this test

    Scenario: Verify that there are two main sections "Interactions" and "Widgets"
        Given My app is running in 'demoqa.com:80'
        And I browse to '/'
        When '2' elements exists with 'class:widget-title'
        And I wait '1' seconds

    Scenario: Verify button and checkbox with xpath and click on it
        Given My app is running in 'demoqa.com:80'
        And I browse to '/button'
        When '1' elements exists with 'xpath://*[@id="content"]/div[2]/div/input'
        And I click on the element on index '0'
        And I browse to '/checkboxradio'
        When '1' elements exists with 'xpath://*[@id="content"]/div[2]/div/fieldset[1]/label[1]'
        And I click on the element on index '0'
        And I wait '1' seconds

    Scenario: Write text on a text input
        Given My app is running in 'demoqa.com:80'
        And I browse to '/autocomplete'
        When '1' elements exists with 'id:tags'
        Then I type 'Java' on the element on index '0'
        And I wait '1' seconds

    Scenario: Using a custom step (check CustomStepDefinition class)
        Given My app is running in 'demoqa.com:80'
        And I browse to '/'
        Given I wait '1' seconds
        Then I want to go to disneyland
        Given I wait '1' seconds