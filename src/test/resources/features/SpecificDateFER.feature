Feature: Specific date foreign exchange rates end to end scenarios

  Background: When the rates API is available
    Given specific date rates API is available

  @Smoke
  Scenario: Verify response status
    When user calls rates API for specific date
    Then specific date rates response status should be 200

  @Regression
  Scenario: Verify rates API base response details
    When user calls rates API for specific date for GBP symbol
    Then the response for specific date for GBP should match



