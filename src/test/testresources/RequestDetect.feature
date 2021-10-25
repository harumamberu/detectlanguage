Feature: recognize language with java client by Detect method

Background: Registered user
  Given User with API token

  Scenario Outline: Registered User is able to detect language of string
      test the detection of main(one) Language in the text
    Given the <language> language
    And the <text> string
    When User sends Detect request
    Then the <language> language was received
    Examples:
      | language | text    |
      | "de"     | "ein Text auf Deutsch"  |
      | "ja"     | "日本に関するいくつかのテキスト"  |


  Scenario Outline: Registered User is able to get evaluation of confidence
    else
    Given the <language> language
    And the <text> string
    When User sends Detect request
    Then the confidence was received
    Examples:
      | language | text    |
      | "de"     | "ein Text auf Deutsch"  |
      | "ja"     | "日本に関するいくつかのテキスト"  |

  Scenario Outline: Registered User is able to get evaluation of very low confidence of one language
  else
    Given the <language> language
    And the <text> string
    When User sends Detect request
    Then the reliability of result <reliability>
    Examples:
      | language | text      | reliability |
      | "de"     | "Kinder"  | true        |
      | "ja"     | "日"       | false       |

  Scenario Outline: Registered User is able to detect few languages of string
  test the default Detect with Two Languages in text
    Given the <language> language
    And the <second_language> language
    And the <text> string
    When User sends Detect request
    Then the <language> language was received
    And the <second_language> language was received
    Examples:
      | language | text                        | second_language |
      | "de"     | "ein Text auf Deutsch"      | "de"            |
      | "ja"     | "日本に関するいくつかのテキスト"  | "ja"            |