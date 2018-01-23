# README

## ACCEPTANCE TESTS

Cucumber automated acceptance tests.
This module depends on a QA library (bdt-lib), where common logic and steps are implemented.

## EXECUTION

These tests will be executed as part of the continuous integration flow as follows:

mvn verify [-D\<ENV_VAR>=\<VALUE>] [-Dit.test=\<TEST_TO_EXECUTE>|-Dgroups=\<GROUP_TO_EXECUTE>]

Example (Purchase Order test):
 mvn verify -Dit.test=com.privalia.som.bo.po.POTestsIT.java -DUSER=myuser -DPASSWORD=mypassword -DlogLevel=DEBUG  -DSELENIUM_GRID=172.17.0.1:4444

1. -Dit.test=com.privalia.som.bo.po.POTestsIT.java to run test (feature) o test suite (group of features)
2. -DlogLevel=DEBUG to see the Scenario steps printed
3. -DSELENIUM_GRID=172.17.0.1:4444  Selenium Grid


### Up Selenium Grid and Selenium Server with Chrome Driver:

java -jar selenium-server-standalone-3.4.0.jar -role hub

java -Dwebdriver.chrome.driver=chromedriver -jar selenium-server-standalone-3.4.0.jar -host localhost -role node -hub http://localhost:4444/grid/register -browser browserName=chrome,version=mybrowser &
v:mybrowser

Example: mvn verify -Dit.test=com.privalia.myproject.mypackage.CucumberRestIT.java