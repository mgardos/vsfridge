Feature: Take Product CU_TP
  The user opens the fridge door and then takes a product from inside the fridge.

    Background:
      Given the use case CU_AR executed successfully

  Scenario: Normal flow CU_TP_NR
    When the user takes a product from inside the fridge
    Then the fridge detects an object was taken from inside
    And the fridge records object detection is needed
    Then the user closes the fridge door
    Then the use case CU_CR is invoked

  Scenario: Alternative flow CU_TP_ALT1 - Take another product
    When the user takes another product from inside the fridge
    Then the fridge detects an object was taken from inside
    And the fridge records object detection is needed
    Then the user closes the fridge door
    Then the use case CU_CR is invoked