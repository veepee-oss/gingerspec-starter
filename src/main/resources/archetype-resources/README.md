
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

mvn verify [-D\<ENV_VAR>=\<VALUE>] [-Dit.test=\<TEST_TO_EXECUTE>|-Dgroups=\<GROUP_TO_EXECUTE>]  
  
Example:  
    mvn verify -Dit.test=${package}.${artifactId}.CucumberSeleniumIT -DSELENIUM_GRID=127.0.0.1:4444 -DlogLevel=DEBUG  
      
1. -Dit.test=${package}.${artifactId}.CucumberSeleniumIT to run test (feature) o test suite (group of features)  
2. -DlogLevel=DEBUG to see the Scenario steps printed  
3. -DSELENIUM_GRID=127.0.0.1:4444 Selenium Grid (if the test requires selenium)  
  
 
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
  
Check more information about the GingerSpec framework [here](https://confluence.vptech.eu/pages/viewpage.action?pageId=5442509)  

List of all the steps in the library [here
](https://confluence.vptech.eu/pages/viewpage.action?pageId=5442503)

Follow the instructions [here](https://confluence.vptech.eu/pages/viewpage.action?pageId=5442497) to set up your own local Selenium Grid to use in your tests if necessary
