@ui
Feature: UI - Amazon Shopping Cart

  Scenario: user can add an item from today deal to shopping cart
    Given user navigate to "https://www.amazon.com.au/" url
    Then the page should display with title is "Amazon.com.au: Shop online for Electronics, Apparel, Toys, Books, DVDs & more"
#    When user select "Today's Deals" at top trending search
#    Then the page should display with title is "Today's Deals"
#    When user sort the the item by "Discount - high to low" order
#    And user add a product to shopping cart
#    Then the selected item is added to shopping card
