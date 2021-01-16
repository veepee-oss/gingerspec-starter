@rest
Feature: Testing a RestFull API

    The @rest annotation is necessary when using GingerSpec Rest steps, here is why:
    https://github.com/vpTechOSS/gingerspec/wiki/Hook-tags#rest-tag

    This example uses https://jsonplaceholder.typicode.com, Fake Online REST API for Testing and Prototyping

    Execute this test like this:
    mvn verify -Dit.test=${groupId}.${artifactId}.runners.CucumberRestIT

    Or run it by tag like this:
    mvn verify -Dcucumber.filter.tags="@rest"

    You can check a more complete list of steps and examples at:
    https://github.com/vpTechOSS/gingerspec/wiki/Gherkin-steps#rest-steps

    Scenario: A successful response with a valid body is returned
        Given I securely send requests to 'jsonplaceholder.typicode.com:443'
        When I send a 'GET' request to '/posts'
        Then the service response status must be '200'
        And I save element '$.[0].userId' in environment variable 'USER_ID'
        Then '${USER_ID}' matches '1'

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

    Scenario: This is an example of a custom REST step
        Given I verify that a successful response with a valid body is returned