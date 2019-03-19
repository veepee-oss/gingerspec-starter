
# README  

Use this README file to provide some information about your project and how to run your tests
  
  
## Execution  
  
These tests will be executed as part of the continuous integration flow as follows:  
  
mvn verify [-D\<ENV_VAR>=\<VALUE>] [-Dit.test=\<TEST_TO_EXECUTE>|-Dgroups=\<GROUP_TO_EXECUTE>]  
  
Example:  
    mvn verify -Dit.test=${package}.${artifactId}.CucumberSeleniumIT -DSELENIUM_GRID=127.0.0.1:4444 -DlogLevel=DEBUG  
      
1. -Dit.test=${package}.${artifactId}.CucumberSeleniumIT to run test (feature) o test suite (group of features)  
2. -DlogLevel=DEBUG to see the Scenario steps printed  
3. -DSELENIUM_GRID=127.0.0.1:4444 Selenium Grid (if the test requires selenium)  
  
  
## Using Selenium

Follow the instructions [here](https://confluence.vptech.eu/pages/viewpage.action?pageId=5442497) to set up your own local Selenium Grid to use in your tests

## The GingerSpec testing library
  
This module depends on a QA library (GingerSpec), where common logic and steps are implemented. 
  
Check more information about the GingerSpec testing library [here](https://confluence.vptech.eu/pages/viewpage.action?pageId=5442509)  

List of all the steps in the library [here
](https://confluence.vptech.eu/pages/viewpage.action?pageId=5442503)