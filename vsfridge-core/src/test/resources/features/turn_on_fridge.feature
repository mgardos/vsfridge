Feature: Turn on CU_ED
  The fridge is turned off and the user plugs it to the electric currency.

  Background:
    Given the fridge is plugged to the electrical currency
    And the fridge is turned off

  Scenario: Normal flow CU_ED_NR
    When the user turns on the fridge
    Then the fridge initializes
    And the fridge is ready

  Scenario: Alternative flow CU_ED_ALT1 - Fridge detects door opened
    When the user turns on the fridge
    Then the fridge initializes
    But the fridge detects its door opened
    And the use case CU_CR is invoked

