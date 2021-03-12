Feature: Latest foreign exchange rates end to end scenarios

  Background: Rates Service API is available
    When rates API is available

  @Smoke
  Scenario: Verify Rates API response status for Latest Foreign Exchange Rates
    Then the response status for latest foreign exchange rates should be 200

  @Smoke
  Scenario: Verify Rates API response details for Latest Foreign Exchange Rates
    Then the response for latest rates for USD should match

  @Regression
  Scenario: Verify error for invalid rates API URL
    And user hits an invalid URL
    Then user should get error message



