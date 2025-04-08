# UI and API Test Framework

### About

- UI Testing:
  - Selenium WebDriver for browser automation 
  - Cucumber (BDD) for test scenarios in Gherkin syntax 
  - Follows Page Object Model (POM) design pattern for maintainable tests

- API Testing:
  - RestAssured for REST API validation
  - Cucumber (BDD) for test scenarios in Gherkin syntax

- Test Reporting:
  - Generates detailed test reports using JUnit

### Prerequisites

To run the tests, ensure the following are installed and configured:

- **Git**: Required for cloning the repo
- **IntelliJ IDEA**: The IDE I used for running and debugging the tests
- **Cucumber**: A plugin for IntelliJ
- **Java (JDK)**: My Java version is 20.0.1
- **Maven**: Use _Homebrew_ for macOS or _Chocolatey_ for Windows
- **Chrome/Edge browser**: `Edge` is specified in the config file (located in `src/test/resources/config.properties`)
  but it can be changed to `chrome` if desired

### Cloning the Repository

To get started, clone the repository to your local machine using Git. Run the following command in your terminal or
command prompt:

```
git clone https://github.com/ghufrankhan/java-framework-new.git
```

### Setup

Open up the project in IntelliJ.

You should be prompted to synchronise the `pom.xml` file, but if not, you can do this manually in IntelliJ...

On the left hand side, right-click on the `pom.xml` file in the root of the Project tree, click on **_Maven_** and then
**_Sync Project_**.

IntelliJ will index the project and download dependencies (this may some time depending on your internet connection).

### Running the UI Tests

#### Create a Run Configuration

On the left hand side, right-click on the `uiTestRunner` file (located in `src/test/java/ui/runner/uiTestRunner.java`),
then click on **Run 'uiTestRunner'**.

The Scenario found in the file `SeleniumWebFormTests.feature` (located in
`src/test/resources/features/ui/SeleniumWebFormTests.feature`) should run.

To run the feature file/Scenario again, you can click on the _Play_ button for the Run Configuration that has been
created for you on the top right side of the IntelliJ window. The configuration is called `uiTestRunner`.

### Running the API Tests

#### Create a Run Configuration

On the left hand side, right-click on the `apiTestRunner` file (located in
`src/test/java/api/runner/apiTestRunner.java`),
then click on **Run 'apiTestRunner'**.

The Scenarios found in the file `GenderizeTests.feature` (located in
`src/test/resources/features/api/GenderizeTests.feature`) should run.

To run the feature file/Scenarios again, you can click on the _Play_ button for the Run Configuration that has been
created for you on the top right side of the IntelliJ window. The configuration is called `apiTestRunner`.

### Test Reports

Upon completion of a test run, detailed reports are automatically generated in both **JSON** and **HTML** formats.

#### HTML Report:

Viewable in any web browser with a user friendly interface.

Displays comprehensive details for each executed scenario, including:

Test status (Pass/Fail)

Step-by-step execution logs

Duration and error messages (if any failures)

_**For UI Tests**: Includes screenshots attached to failed scenarios for quick visual debugging._

#### JSON Report:

Ideal for integration with CI/CD pipelines.

#### Report location

The reports can be found in the `target` folder:

UI: `target/ui.json` and `target/ui-report.html`

API: `target/api.json` and `target/api-report.html`