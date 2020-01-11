Feature: Put Product CU_PP
  The user opens the fridge door and then puts a product inside the fridge.

  Background:
    Given the use case CU_AR executed successfully

  Scenario: Normal flow CU_PP_NR
    When the user puts a product inside the fridge
    Then the fridge detects an object was put inside
    And the fridge records product detection is needed
    Then the user closes the fridge door
    And the use case CU_CR is invoked

  Scenario: Alternative flow CU_PP_ALT1 - Put another product
    When the user puts another product inside the fridge
    Then the fridge detects an object was put inside
    And the fridge records product detection is needed
    Then the user closes the fridge door
    And the use case CU_CR is invoked