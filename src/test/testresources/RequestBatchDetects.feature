Feature: send request with java client

  Background: Registered user
    Given User with API token

  Scenario: Registered User is able to send request with array of stings
    Given the "en" language
    And the "string" string
    When User sends BatchDetect request
    Then the "" response was received