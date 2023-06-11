Feature: Handling popup Windows

  Scenario: Verify that you are able to Compare two product

    Given User is on the Homepage
    When User click on the Mobile menu
    And User click on the Add to Compare button for any two mobile phones
    And User click on the Compare button
    Then A pop up window should appear with details of the two selected mobile phones
    And User close the pop up window