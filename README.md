# test-counter

A Maven-based Selenium WebDriver project that runs TestNG tests against the [Flutter Angular](https://flutter-angular.web.app) demo app. It automates the counter UI and validates input behavior.

## Project Description

**test-counter** is an automated UI test suite for the [Flutter Angular](https://flutter-angular.web.app) sample application. It uses Selenium WebDriver with Chrome to drive the browser and TestNG to define and run tests.

The project focuses on the **counter** feature: it verifies that the app’s counter input accepts and retains values correctly (e.g., entering a number and asserting it is displayed). Tests use explicit waits to handle the Flutter/Angular UI and optional elements like the sidenav toggle.

This setup is suitable for regression checks, learning Selenium + TestNG, or extending with more tests against the same app.

## Prerequisites

- **Java 21** (configured in `pom.xml`)
- **Maven** 3.6+
- **Chrome** (latest stable) — tests use ChromeDriver via Selenium Manager

## Getting Started

### Run all tests

```bash
mvn test
```

### Run a specific test class

```bash
mvn test -Dtest=CounterTest
```

## Project Structure

```
test-counter/
├── pom.xml                 # Maven config (Selenium, TestNG, Java 21)
├── src/
│   └── counter/
│       └── CounterTest.java   # Test class
├── target/
│   └── surefire-reports/   # Test reports after `mvn test`
└── test-output/            # TestNG HTML reports
```

## Dependencies

| Dependency        | Version  | Purpose                    |
|-------------------|----------|----------------------------|
| selenium-java     | 4.40.0   | Browser automation         |
| testng            | 7.12.0   | Test framework             |

## Tests

- **CounterTest**  
  - Opens https://flutter-angular.web.app in Chrome.  
  - Waits for the Flutter view, optionally opens the sidenav.  
  - Locates the clicks input (`mat-input-1`), sets its value to `5`, and asserts the value is `5`.

## Test Reports

After `mvn test`:

- **Surefire**: `target/surefire-reports/` (e.g. `counter.CounterTest.txt`, `index.html`)
- **TestNG**: `test-output/` (e.g. `index.html`, `emailable-report.html`)

## License

See the project or repository for license details.
