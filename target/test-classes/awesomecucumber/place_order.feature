Feature:place order
  Scenario: place an order
    Given I'm on the store page
    #//NEWLY ADDED lINE
    And my billing details are
      |first name|last name|country           |address1|address2|town/city|state  |Zip code|email   |
      |asdff     |wefwffdfr|United States (US)|dfsffsfg|fwereg |hkhkh    | Utah   |23467  |sfsggg@gmail.com|
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart
    And I should go to checkout page
    And I have to provide billingDetails
   #these line of data has moved to second step //to create sharing between between steps
    Then I should be place order
