@GoogleSmoke
Feature: feature to test google search functionality

  @GoogleSearch_TC0001
  Scenario: Validate google search is working
    Given Browser is open
    And User is on google search page
    When User enters a text in search box
    And User hits enter
    Then User is navigated to search results
    
