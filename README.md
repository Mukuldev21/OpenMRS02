# OpenMRS02 Automated Testing Framework

This project is an automated testing framework for the OpenMRS patient record system. It leverages Java, Maven, Selenium WebDriver, and Cucumber to provide robust, maintainable, and scalable end-to-end test automation.

---

## Project Structure

---

## 📁 Project Structure — `OpenMRS02`

```bash
OpenMRS02/
├── pom.xml                          # Maven configuration file
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/              # Page Object Model classes
│   │       │   ├── BasePage.java
│   │       │   ├── HomePage.java
│   │       │   ├── LoginPage.java
│   │       │   └── PatientRecordPage.java
│   │       └── utils/              # Utility classes for config, driver, reporting
│   │           ├── ConfigReader.java
│   │           ├── DriverManager.java
│   │           ├── ExtentReportManager.java
│   │           ├── StepErrorTracker.java
│   │           └── StepTracker.java
│   └── test/
│       ├── java/
│       │   ├── features/           # Cucumber feature files
│       │   │   ├── FindPatientRecord.feature
│       │   │   └── Login.feature
│       │   ├── hooks/              # Cucumber lifecycle hooks
│       │   │   └── CucumberHooks.java
│       │   ├── runner/             # Test runner class
│       │   │   └── TestRunner.java
│       │   ├── steps/              # Step definitions for feature files
│       │   │   ├── FindPatientRecordSteps.java
│       │   │   └── LoginSteps.java
│       │   └── tests/              # Base test setup
│       │       └── BaseTest.java
│       └── resources/
│           ├── spark-config.html   # Spark report theme and layout config
│           ├── config/
│           │   └── config.properties  # Environment and browser settings
│           └── test_data/          # External test data files
│               ├── loginDetails.json
│               └── patientRecordForSearch.json
├── target/                         # Maven build output directory
│   └── (build output)
└── test-output/
    └── ExtentReport/
        └── index.html              # Generated Spark HTML report
```

---



### Key Directories and Files

- **pages/**: Page Object Model classes for each UI page (e.g., `LoginPage.java`, `PatientRecordPage.java`).
- **utils/**: Utility classes for configuration, driver management, reporting, and step tracking.
- **features/**: Cucumber feature files describing test scenarios in Gherkin syntax.
- **steps/**: Step definition classes mapping Gherkin steps to Java code.
- **hooks/**: Cucumber hooks for setup and teardown logic.
- **runner/**: Test runner class to execute Cucumber tests.
- **tests/**: Base test class for common test setup.
- **resources/config/**: Configuration files (e.g., `config.properties`).
- **resources/test_data/**: Test data files in JSON format.
- **test-output/ExtentReport/**: Generated HTML test reports.

---

## Technologies Used

### Java
- Main programming language for test logic and framework code.

### Maven
- Build automation and dependency management tool.
- Handles project lifecycle, dependencies, and plugins.

### Selenium WebDriver
- Automates browser actions for end-to-end UI testing.
- Supports multiple browsers and platforms.

### Cucumber
- Enables Behavior-Driven Development (BDD).
- Uses Gherkin syntax for writing human-readable test scenarios.

### TestNG
- Testing framework for organizing and executing tests.
- Test runner for executing Cucumber scenarios.

### ExtentReports
- Generates detailed and interactive HTML reports for test execution.

### Page Object Model (POM)
- Design pattern for organizing UI interaction logic.
- Improves maintainability and reusability of test code.

---

## How to Run

1. Clone the repository.
2. Update `src/test/resources/config/config.properties` with your environment details.
3. Run tests using Maven:
4. View the test report at `test-output/ExtentReport/index.html`.

---

## Authors

- Mukul Dev Mahato