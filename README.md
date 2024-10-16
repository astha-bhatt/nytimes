# nytimes
This repository contains an automated testing framework for the [New York Times International](https://www.nytimes.com/international/) website. The framework is built using Java, Selenium WebDriver, and TestNG, following the Page Object Model (POM) design pattern.

## Features

- **Cross-Browser Testing**: Supports Chrome, Firefox, Safari, and Edge.
- **Data-Driven Testing**: Ability to read test data from external sources (CSV/Excel).
- **Explicit Waits**: Implements explicit waits to ensure elements are loaded before interaction.
- **Reusable Utility Methods**: Contains utility methods for common functionalities.
- **Clean Code Structure**: Adheres to OOPs.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven
- Selenium WebDriver
- TestNG


## Setup Instructions

1. Clone the repository:

   ```bash
   git clone <repository-url>


2. Configure WebDriver:

Ensure you have the appropriate WebDriver executables (e.g., chromedriver, geckodriver, edgedriver) in your system's PATH

3. Install Maven dependencies:

Navigate to the project directory and run:

mvn clean install

4. Configure Browser Settings:

Browser to be used can be specified in the src/test/resources/browser-config.properties file.

5. To run all tests:

mvn test

To run specific test classes:

mvn -Dtest='Test name' test

6. Test Cases Included
Search Functionality: Validates the search feature on the homepage.
Click sections other than International : Validates click on CANADA
Navigating to the front page section
Navigation to Sections: Verifies navigation to a section of the website.
