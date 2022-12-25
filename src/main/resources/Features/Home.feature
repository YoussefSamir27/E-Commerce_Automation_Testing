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


  Scenario: Logged User could search for any product
    Given user login to his account
    And user enter name of product at search box
    And user click on search
    Then user could see the product displayed


  Scenario: Logged user could select different Categories
    Given user logged in to select category
    And user hover on category and select subcategory
    Then the selected category should be displayed


  Scenario: Logged user could filter with color
    Given user is logged in to filter
    When user select category
    And user filter by color
    Then products with this attribute should be displayed


  Scenario: Logged user could add different products to Shopping cart
    Given user logged in to add product to cart
    When user choose category
    And user add product to cart
    Then product should be added successfully to cart


  Scenario: Logged user could add different products to Wishlist
    Given user logged in to add product to wishlist
    When user select any category
    And user add product to wishlist
    Then product should add to wishlist successfully


  Scenario:  Logged user could add different products to compare list
    Given user logged in to add product to compare list
    When user select specific category
    And user add product to compare list
    Then the product should added to compare list successfully







