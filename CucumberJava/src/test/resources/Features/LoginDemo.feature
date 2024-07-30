@SmokeScenario
Feature: Test login functionality

  @LoginValidCredentials
  Scenario Outline: Check login is successful with valid credentials
    Given Browser is open
    And User is on login page
    When User enter <username> and <password>
    And User clicks on login button
    Then User is navigated to the home page

    Examples: 
      | username                | password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |

  @LoginInvalidCredentials
  Scenario Outline: Check login is unsuccessful with Invalid credentials
    Given Browser is open
    And User is on login page
    When User enter <username> and <password>
    And User clicks on login button
    Then User receive error message

    Examples: 
      | username                | password     |
      | locked_out_user         | secret_sauce |
