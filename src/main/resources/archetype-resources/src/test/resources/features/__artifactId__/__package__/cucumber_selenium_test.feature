@web
Feature: Testing boit-uat20 login and basic layout

    This feature shows an example of how to test a web applicatio using Selenium. Please, notice that
    the @web annotation in the beginning of the feature is NECESSARY, when selenium related tests, since
    it indicates the library to bootstrap some necessary dependencies. Failing to do so will make your
    feature fail.

    Mind that for any Selenium related feature (like this one), is NECESSARY to indicate the address of
    the Selenium Grid service to execute it, in this way:

    mvn verify -Dit.test=com.privalia.myproject.mypackage.CucumberSeleniumIT -DSELENIUM_GRID=172.17.0.1:4444

    Head over http://confluence.privalia.pin/pages/viewpage.action?pageId=29425961 to find more information

    Scenario: Verify that the logistic orders page displays correctly 11 clickable buttons in the top navigation bar
        Given My app is running in 'boit-uat24.privalia-test.com:80'
        And I browse to '/login'
        When '1' elements exists with 'xpath://*[@id="aclusr_username"]'
        Then I type 'root' on the element on index '0'
        When '1' elements exists with 'xpath://*[@id="aclusr_password"]'
        Then I type '1111' on the element on index '0'
        And '1' elements exists with 'xpath://*[@id="submit"]'
        And I click on the element on index '0'
        Given I wait '1' seconds
        When I browse to '/logisticorders/index'
        Then I check every '1' seconds for at least '10' seconds until '11' elements exists with 'xpath://*[contains(@class, 'dir')]' and is 'clickable'
        And I browse to '/login/logout'
        And I wait '2' seconds


    Scenario: Verify that a warning alert appears when clicking on the excel icon without campaigns listed and that the alert can be
    dismissed or accepted
        Given My app is running in 'boit-uat24.privalia-test.com:80'
        And I browse to '/login'
        When '1' elements exists with 'xpath://*[@id="aclusr_username"]'
        Then I type 'root' on the element on index '0'
        When '1' elements exists with 'xpath://*[@id="aclusr_password"]'
        Then I type '1111' on the element on index '0'
        And '1' elements exists with 'xpath://*[@id="submit"]'
        And I click on the element on index '0'
        Given I wait '1' seconds
        When I browse to '/logisticorders/index'
        Then I check every '1' seconds for at least '10' seconds until '1' elements exists with 'xpath://*[@id="pager2"]/table/tbody/tr/td[2]' and is 'clickable'
        And I click on the element on index '0'
        Then I check every '1' seconds for at least '10' seconds until an alert appears
        Then I dismiss the alert
        And I wait '2' seconds
        And I click on the element on index '0'
        Then I check every '1' seconds for at least '10' seconds until an alert appears
        And I accept the alert
        And I browse to '/login/logout'
        And I wait '2' seconds


    Scenario: Using a custom step (check CustomStepDefinition class})
        Given My app is running in 'boit-uat24.privalia-test.com:80'
        And I browse to '/login'
        Given I wait '1' seconds
        Then I want to go to disneyland