Feature: Simple Detect via java client

  Background: Registered user
    Given User with API token

  Scenario Outline: Registered User is able to get simple detection of string
    Given the <language> language
    And the <text> string
    When User sends Detect request
    Then the <language> language was received
    Examples:
      | language | text    |
      | "de"     | "ein Text auf Deutsch"  |
      | "ja"     | "日本に関するいくつかのテキスト"  |
