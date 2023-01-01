@Regression
Feature: Logged User could switch between currencies US-Euro

  Scenario: user can switch between currencies
    Given user logged in to select currency
    And user select EURO currency
    Then euro sign should be displayed at website