@rest
Feature: Testing a RestFull API

    This feature provides an example for testing a remote REST API. Notice that the @rest
    annotation is NECESSARY when testing REST services, since it indicates the library to
    bootstrap some necessary dependencies. Failing to do so will make your feature fail.

    This example uses https://jsonplaceholder.typicode.com, Fake Online REST API for Testing and Prototyping

    Execute this test like this:
    mvn verify -Dit.test=${groupId}.${artifactId}.runners.CucumberRestIT

    Or run it by tag like this>
    mvn verify -Dcucumber.filter.tags="@rest"

    You can check a more complete list of steps and examples at:
    https://github.com/vpTechOSS/gingerspec/wiki/Gherkin-steps#rest-steps
    https://vptechoss.github.io/gingerspec/com/privalia/qa/specs/RestSpec.html

    Scenario: A successful response with a valid body is returned
        Given I securely send requests to 'jsonplaceholder.typicode.com:443'
        When I send a 'GET' request to '/posts'
        Then the service response status must be '200'
        And I save element '$.[0].userId' in environment variable 'USER_ID'
        Then '${USER_ID}' matches '1'

    Scenario: This is the same scenario as above, but in one line, using custom steps
        Given I verify that a successful response with a valid body is returned

    Scenario: A new element is inserted via a POST call
        Given I securely send requests to 'jsonplaceholder.typicode.com:443'
        When I send a 'POST' request to '/posts' based on 'schemas/mytestdata.json' as 'json'
        Then the service response status must be '201'
        And I save element '$.title' in environment variable 'TITLE'
        Then '${TITLE}' contains 'This is a test'

    Scenario: Data in local file is altered using a datatable before sending
        Given I securely send requests to 'jsonplaceholder.typicode.com:443'
        When I send a 'POST' request to '/posts' based on 'schemas/mytestdata.json' as 'json' with:
            | $.title | UPDATE | This is a test 2 |
        Then the service response status must be '201'
        And I save element '$' in environment variable 'response'
        And 'response' matches the following cases:
            | $.title   | contains  | 2              |
            | $.body    | contains  | This is a test |
            | $.userId  | not equal | 2              |

