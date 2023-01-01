@Regression
Feature: Verify login Functionality

  Scenario: User could log in with valid email and password
    Given user to login page
    When user enter valid email
    And user enter valid password
    And user click on login
    Then user could login successfully and redirected to home page