Feature: Add To Bag

  Scenario: Adding a product to the Bag
    Given the user is on a product page
    When adding the product to the Bag
    Then the product should appear in the Bag

  Scenario: AC1
    Given the user is on a product page
    When adding the product to the Bag
    When the user remove a product
    Then the product should be removed from the bag

  Scenario: AC2
    Given the user is on a product page
    When adding the product to the Bag
    When the user change the quantity to "2"
    Then product quantity should be increased

  Scenario: AC3
    Given the user is on a product page
    When adding the product to the Bag
    When the user change the quantity to "3"
    When the user remove the quantity
    Then product quantity should be removed from the bag

    #FEATURE: BAG
    #AC1
    #Given there are products in the bag
    #When I remove a product
    #Then the product is removed from the bag
    #AC2
    #Given there are products in the bag
    #When I add quantity
    #Then product quantity is increased
    #AC3
    #Given there are products in the bag
    #When I remove quantity
    #Then product quantity is removed from the bag