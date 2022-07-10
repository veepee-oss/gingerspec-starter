@rest
Feature: Testing a RestFull API example

  This is an example of how to use the provided Rest steps of GingerSpec to test an API. This example
  uses https://jsonplaceholder.typicode.com, Fake Online REST API for Testing and Prototyping

  Steps documentation  -> https://github.com/veepee-oss/gingerspec/wiki/Gherkin-steps#rest-steps
  Run this in terminal -> mvn verify -Dcucumber.filter.tags="@rest"
  Run in IntellijIDEA  -> https://github.com/veepee-oss/gingerspec/wiki/Setting-up-your-IDE#running-cucumber-test

  Scenario: Check a successful response with a valid body is returned
    Given I securely send requests to 'jsonplaceholder.typicode.com:443'
    When I send a 'GET' request to '/posts'
    Then the service response status must be '200'
    And I save element '$.[0].userId' in environment variable 'USER_ID'
    Then '${USER_ID}' matches '1'

  Scenario: Send a POST request with body example
    Given I securely send requests to 'jsonplaceholder.typicode.com:443'
    When I send a 'POST' request to '/posts' with body
        """
            {
              "userId": 1,
              "title": "This is a test",
              "body": "This is a test"
            }
          """
    Then the service response status must be '201'

  Scenario: This is an example of a custom REST step
    Given I verify that a successful response with a valid body is returned