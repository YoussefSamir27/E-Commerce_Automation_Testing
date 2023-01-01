@Regression
Feature: verify register functionality

  Scenario: User could register with valid data
    Given user navigate to registration page
    When user choose gender
    And user enter first name
    And user enter last name
    And user enter email
    And user enter password
    And user confirm password
    Then user could register successfully
    And receive success message








