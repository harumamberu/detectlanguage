Feature: Simple Detect detectlang java client

  Background: Registered user
    Given User with API token

  Scenario: Registered User is able to get simple detection of string
    Given the "any text to test that its possible" string
    When User sends SimpleDetect request with "" string
    Then the "" language was received
