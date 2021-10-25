Feature: recognize language with java client by Batch Detect method

  Background: Registered user
    Given User with API token

  Scenario: Registered User is able to send request with array of stings
    Given the "en" language
    And the "string" string
    When User sends BatchDetect request
    Then the "" response was received

  Scenario Outline: Registered User is able to send request with array of stings
    Given the <language> language
    And the <text> string
    And the <second_language> language
    And the <second_text> string
    When User sends Detect request
    Then the actual results of batch request equls expected

    Examples:
      | language | text                    | second_language | second_text                 |
      | "de"     | "ein Text auf Deutsch"  | "ja"            | "日本に関するいくつかのテキスト"  |