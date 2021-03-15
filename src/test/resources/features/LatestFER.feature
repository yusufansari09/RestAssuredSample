Feature: Latest foreign exchange rates end to end scenarios

  @Smoke
  Scenario: Verify Rates API response status for Latest Foreign Exchange Rates
    Given rates API is available
    When user calls rates API for latest foreign exchange rate
    Then the response status for latest foreign exchange rates should be 200

  @Smoke
  Scenario: Verify Rates API response details for Latest Foreign Exchange Rates
    Given rates API is available
    When user calls rates API for latest foreign exchange rate for USD symbol
    Then the response for latest rates for USD should match

  @Regression
  Scenario: Verify error for invalid rates API URL
    Given rates API is available
    When user hits an invalid URL
    Then user should get error message



