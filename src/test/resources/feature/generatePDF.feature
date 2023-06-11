Feature: Verify that you will be able to save previously placed order as PDF file.

  Scenario: Verify order details and PDF generation
    Given User is on the Homepage
    When User click on the My Account link
    And User logs in to the application using previously created credentials
    And User click on My Orders
    And User click on View Orders
    Then User should see the previously created order in the RECENT ORDERS table with the status as pending
    And User click on the Print Order link
    Then User should see that the order is saved as a PDF