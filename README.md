# API Test Automation project
API test automation framework created with Java and Rest Assured using Cucumber. You can find the APIs here which have been automated as a part of this project:
`https://ratesapi.io/documentation/`

# Prerequisites
1. Requires JDK version 8 or later to be installed in your system. Gradle uses the JDK libraries which is installed and sets to the JAVA_HOME environmental variable.
2. Gradle should be installed in your system. If not, run
`brew install gradle` to install it using Homebrew.

# Usage
* Please run below command to execute the Unit tests:
```$xslt
./gradlew clean runUnitTests -Dtag=SMOKE
```
* Please run below command to execute cucumber features
```$xslt
./gradlew cucumberTests
```
OR
```$xslt
./gradlew -Dcucumber.options="--tags @Smoke" clean test
```
OR
```$xslt
./gradlew -Dcucumber.options="--tags @Regression" clean test
```

* The request sent, the endpoint and the response returned, all are getting logged to the Reports as well as on the standard output.

# Reporting
* For generating test execution reports, `ReportNg` is being used 
* To see the reports, go to the path `/build/RunTests/html` and open `index.html` in any browser. Click on `Gradle Tests` hyperlink to see more detailed report with the logs.

