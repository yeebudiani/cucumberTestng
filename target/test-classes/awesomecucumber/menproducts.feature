Feature: men's accessories

Scenario Outline: Add one quantity from store for multiple products
Given I'm on the Mens page
When I will add a "<product_name>" to the cart
Then I should be able to see 1 "<product_name>" in the cart
Examples:
|product_name|
|Basic Blue Jeans|
|Faint Blue Jeans  |
|Red Shoes|