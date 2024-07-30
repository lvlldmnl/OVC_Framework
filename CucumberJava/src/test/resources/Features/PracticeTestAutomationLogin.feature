@PracticeTestAutomation
Feature: Test login functionality

  @ShoppingCart
  Scenario Outline: Check login is successful with valid credentials
    #Given Browser is open
    Given User is on login page
    When User enter <username> and <password>
    And User clicks on login button
    When the user adds the following items to the cart
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    And User navigate to the shopping cart
    Then User verifies the following items in the cart:
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |

    Examples: 
      | username      | password     | item                     |
      | standard_user | secret_sauce | Sauce Labs Fleece Jacket |
