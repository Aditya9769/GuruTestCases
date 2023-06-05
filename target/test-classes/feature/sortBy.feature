Feature: Verify sorting functionality by Name

  Scenario: Verify sorting by name on Guru99 Mobile page
    Given User is on the Homepage
    When User verify the title of the page
    And User click on the Mobile menu
    Then User verify the title of the Mobilelist page
    And User select Name from the SORT BY dropdown
    Then User verify that all the products are sorted by name