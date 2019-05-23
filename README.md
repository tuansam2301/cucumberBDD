# cucumberBDD
Run Test from Command Line

1. Open the command prompt and cd until the project root directory.

2. Run Test using some command option as below
a. Run all test
mvn test
b. Running Scenarios using Tags
mvn test -Dcucumber.options="--tags @tag Name"
ex: mvn test -Dcucumber.options="--tags @Smoke"

3. Report
You could find the report from {the project root directory}/target/cucumber-report/report.html
