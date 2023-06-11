Feature: Account Creation and Share Wishlist on Guru99

  Scenario: Verify You can Create account on E-commerce site and can share wishlist to other people using email

    Given User is on the Homepage
    When User click on the My Account link
    And User fill in the new user information except for the email id
    And User click on Register button
    Then User verify that the registration is successful
    When User go to the TV Menu
    And User add a product to wishlist
    And User click on the Share Wishlist button
    And User enter an email and a message and click on Share Wishlist
    Then User check if the wishlist is shared successfully