@Regression
Feature: Create successful order

  Scenario: user can create Order
    When user login to website
    And user choose any category
    And user add any product to cart
    And user open cart page
    And user agree terms and conditions
    And user click on checkout
    And user edit billing address
    And user choose shipping method
    And user choose payment method
    And user check payment information
    And user confirm order
    Then order should be placed successfully