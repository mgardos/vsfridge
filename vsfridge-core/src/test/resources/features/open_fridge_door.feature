Feature: Open Fridge Door CU_AR
  The fridge door is closed and the user opens it.

  Background:
    Given the fridge is turn on
    And the fridge door is closed

  Scenario: Normal flow CU_AR_NF
    When the user opens the fridge door
    Then the fridge increments the counter for door opened
    And the fridge starts the timer for door opened
    When the user closes the fridge door
    Then the use case CU_CR is invoked

  Scenario: Alternative flow CU_AR_ALT1 - Put product
    When the user opens the fridge door
    Then the fridge increments the counter for door opened
    And the fridge starts the timer for door opened
    When the user puts a product inside the fridge
    Then the use case CU_PP is invoked

  Scenario: Alternative flow CU_AR_ALT2 - Take product
    When the user opens the fridge door
    Then the fridge increments the counter for door opened
    And the fridge starts the timer for door opened
    When the user takes a product from inside the fridge
    Then the use case CU_TP is invoked