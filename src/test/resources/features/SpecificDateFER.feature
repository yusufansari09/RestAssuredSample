Feature: Specific date foreign exchange rates end to end scenarios

  Background: Rates Service API is available
    When specific date rates API is available

  @Smoke
  Scenario: Verify response status
    Then specific date rates response status should be 200

  Scenario: Verify rates API base response details
    Then the response for specific date for GBP should match

  Scenario: Verify error for invalid rates API URL
    Given user hits a future date rates API
    Then specific date rates response status should be 200
    Then the response for specific date for GBP should match



