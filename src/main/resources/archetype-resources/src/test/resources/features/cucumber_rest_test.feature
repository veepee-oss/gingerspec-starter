@rest
Feature: Testing a RestFull API

    This feature provides an example for testing a remote REST API. Notice that the @rest
    annotation is NECESSARY when testing REST services, since it indicates the library to
    bootstrap some necessary dependencies. Failing to do so will make your feature fail.

    This example uses https://jsonplaceholder.typicode.com, Fake Online REST API for Testing and Prototyping

    Execution: mvn verify -Dit.test=${package}.${artifactId}.CucumberRestIT

    Scenario: A successful response with a valid body is returned
        Given I securely send requests to 'jsonplaceholder.typicode.com:443'
        When I send a 'GET' request to '/posts'
        Then the service response status must be '200'
        And I save element '$.[0].userId' in environment variable 'USER_ID'
        Then '!{USER_ID}' matches '1'

    Scenario: A new element is inserted via a POST call
        Given I securely send requests to 'jsonplaceholder.typicode.com:443'
        When I send a 'POST' request to '/posts' based on 'schemas/mytestdata.json' as 'json'
        Then the service response status must be '201'
        And I save element '$.title' in environment variable 'TITLE'
        Then '!{TITLE}' contains 'This is a test'

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

    @runOnEnv(SERVER)
    Scenario: Setting headers using a datatable
        Given I send requests to '${SERVER}'
        Given I set headers:
            | x-user  | myuser     |
            | x-token | 1234567890 |
        When I send a 'GET' request to '/api/v1/shipment/1' as 'json'
        Then the service response status must be '200'
        And I clear headers from previous request
        When I send a 'GET' request to '/api/v1/shipment/1'
        Then the service response status must be '401'

    @runOnEnv(SERVER)
    Scenario: Failed to load resources, no authentication headers
        Given I send requests to '${SERVER}'
        When I send a 'GET' request to '/api/v1/shipment'
        Then the service response status must be '401'
        And I save element '$' in environment variable 'response'
        And 'response' matches the following cases:
            | $.errors[0].title              | contains   | Forbidden access.  |
        And 'response' matches the following cases:
            | $.errors[0].source             | contains   | system             |
