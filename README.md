# About
This project is a mobile test automation project written with Java and Appium. And it's a base project. You can use this project as template for your mobile app test automation project.

# Toolstack
- Java
- Maven
- Appium
- TestNG
- IntelliJ IDE - Development IDE

# Run Project

- You can run directly with feature files in java/test/features directory.

### Maven Run

```
mvn clean run
```

### Cucumber Tag Run

Example for `@verify_products` tag:
```
mvn test -D"cucumber.filter.tags=@verify_products"
```

### TestNG Run

Right click to "tesng.xml" then click Run

# Reporting

- Allure Report
- Cucumber Report

# Project Structure
```
📦 appium-java-mobile-test-automation-base
├─ src
│  └─ test
│     └─ java
│        ├─ apps --> App Package ( apk, ipa )
│        ├─ configs --> Project configs
│        ├─ test --> Features
│        └─ util --> Helper classes, Driver etc.
├─ pom.xml
└─ testng.xml
```
