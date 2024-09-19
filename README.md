# eBanking Project - Automated Testing Framework
Description :

This project is an automated testing solution for the eBanking demo site Guru99. The goal is to provide a robust framework for testing key functionalities of the site using a hybrid framework and modern tools for reporting and continuous integration.

Project Features :

Hybrid Testing Framework: Implementation of a hybrid framework combining best testing practices for efficient execution and simplified test management.
Data-Driven Tests: Development and execution of login tests with and without data to verify various authentication scenarios.
Functionality Testing: Creation of tests for adding clients, ensuring the functionality is verified on the site.
Reporting with ExtentReports: Utilization of ExtentReports to generate detailed test reports, providing a clear view of test results and facilitating performance analysis.
CI/CD Integration with Jenkins: Integration of tests into a CI/CD pipeline using Jenkins to automate test execution and enhance the development process.

Technologies Used:

Selenium WebDriver: For automating the web tests.
Java: Programming language used for writing the test scripts.
TestNG: Test framework for managing test cases and assertions.
ExtentReports: For generating detailed test reports.

Installation and Execution : 

Create an Account : 

Before running the tests, you need to create an account on the Guru99 demo site.
Clone the Repository : git clone https://github.com/your-username/your-repository.git

Configuration : 

Update config.properties: Open the config.properties file and add the username and password from the account you created.
Update loginData: For data-driven tests, open the Excel file loginData and enter the login credentials needed for passing test cases.

Run the Tests

Ensure Java and Maven are installed on your machine.
Execute the tests via Maven: mvn test
To view test reports, check the extent-reports folder.

Integration with Jenkins : 

Import the project into Jenkins and configure a job to run the tests automatically on each commit.
