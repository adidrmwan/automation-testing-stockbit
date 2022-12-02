@Android @Transaction
Feature: As user, I have be able to add item to cart, So that I can checkout the item

  Background:
    Given user on catalog screen

  @Positive @SuccessBuyTheProduct
  Scenario Outline: User success buy the product
    When user select the item "<item_name>" with colour "<colour_name>" and quantity <number> of item
    And user tap add to cart button
    And user proceed to checkout the item "<item_name>" with colour "<colour_name>" and quantity <number> of item
    And user need login to process the item
    And user input shipping address
    And user input payment detail
    And user review the order of the item "<item_name>"
    Then user see complete transaction

    Examples:
      |item_name                      |colour_name   |number |
      |Sauce Lab Back Packs           |Blue          |2      |
      |Sauce Lab Fleece T-Shirt       |Gray          |3      |