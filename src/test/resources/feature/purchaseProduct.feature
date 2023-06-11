Feature: Purchase a product on Guru99 website

  Scenario Outline: Verify User is able to purchase product using registered email ID
    Given User is on the Homepage
    When User click on the My Account link
    And User logs in to the application using previously created credentials
    And User go to the TV Menu
    And User add a product to wishlist
    And User clicks on the MY WISHLIST link
    And User clicks on Add to Cart link on the wishlist page
    And User clicks Proceed to checkout
    And User enters the following shipping information:
      | Country   | State     | Zip    | Address | City    | Telephone  |
      | <Country> | <State>   | <Zip>  | <Address> | <City>  | <Telephone> |
    And User clicks Estimate
    Then User verifies that the shipping cost is generated
    And User clicks Continue in the shipping method section
    And User selects Check Money order radio button in the payment information section
    And User clicks Continue
    And User verifies that the selected shipping cost is updated in the total
    And User clicks PLACE ORDER button
    Then User verifies that the order is generated and notes the order number

    Examples:
      | Country        | State     | Zip    | Address | City     | Telephone  |
      | United States  | New York  | 542896 | ABC     | New York | 12345678   |