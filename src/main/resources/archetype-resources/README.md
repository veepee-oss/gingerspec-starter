
# Project Title

One Paragraph of project description goes here


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```


### Running the tests

Explain how to run the automated tests for this system

To run all integration tests (runners)
```
mvn verify
```

To run a specific integracion test (specific runner class):
```
mvn verify -Dit.test=${groupId}.${artifactId}.runners.CucumberRunnerIT
```

To run all integration tests but filter scenarios by tag:
```
mvn verify -Dcucumber.filter.tags="@web"
mvn verify -Dcucumber.filter.tags="@web or @rest"
mvn verify -Dcucumber.filter.tags="@web and not @rest"
```
  
More information on how to run automated tests can be found [here](https://github.com/veepee-oss/gingerspec/wiki/Running-your-tests)


### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```


### Release History

* 0.0.1
    * Work in progress
    

### Authors

* **John Smith** - *Initial work* -

  
### The GingerSpec testing library
  
This module depends on the GingerSpec framework (QA testing library), where common logic and steps are implemented. 
  
Check more information about the GingerSpec framework [here](https://github.com/veepee-oss/gingerspec/wiki)  