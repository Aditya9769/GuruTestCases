Feature: Verify Add to Cart and Cart Management functionality

  Scenario: Add Sony Xperia to cart, update quantity, and empty the cart
    Given User is on the Homepage
    When User click on the Mobile menu
    And User click on ADD TO CART for the Sony Xperia mobile
    And User change the QTY value to "1000" and click the UPDATE button
    Then User should see the error message
    And User click on the EMPTY CART link in the footer
    Then User should see that the cart is empty