@Regression
Feature: verify variety functions of e-commerce

  Scenario: User could register with valid data
    Given user open browser navigate to registration page
    When user choose gender
    And user enter first name
    And user enter last name
    And user enter email
    And user enter password
    And user confirm password
    Then user could register successfully
    And receive success message


  Scenario: User could log in with valid email and password
    Given user open browser navigate to login page
    When user enter valid email
    And user enter valid password
    And user click on login
    Then user could login successfully and redirected to home page


  Scenario: User could reset his/her password successfully
    Given user opened login page
    And user click on reset password
    And user enter his email
    And user click recover
    Then user should receive a link to reset password
