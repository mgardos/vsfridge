Feature: Identify Products CU_IP
  The fridge is closed and products were put inside so the identification of products triggers.

  Background:
    Given the fridge door is closed
    And the fridge records product detection is needed

  Scenario: Normal flow CU_IP_NR
    When the fridge starts product detection
    Then the fridge notifies the user product detection is started
    And the fridge scans the products inside
    Then the fridge identifies all products as groceries
    And the fridge records the groceries detected

  Scenario: Alternative flow CU_IP_ALT1 - Unable to identify products
    When the fridge starts product detection
    Then the fridge notifies the user product detection is started
    And the fridge scans the products inside
    Then the fridge identifies some products as groceries
    But other products are left unidentified
    Then the fridge records the groceries detected
    And stores pictures of unidentified products for manual identification

  Scenario: Alternative flow CU_IP_ALT2 - Fridge door open while identifiction
    When the fridge starts product detection
    Then the fridge notifies the user product detection is started
    And the fridge scans the products inside
    Then the user opens the fridge door
    And the fridge stops the product detection
    And the use case CU_AR is invoked

  Scenario: Alternative flow CU_IP_ALT3 - No products inside
    When the fridge starts product detection
    Then the fridge notifies the user product detection is started
    And the fridge scans the products inside
    Then the fridge does not identify groceries inside
    And the fridge records no groceries inside