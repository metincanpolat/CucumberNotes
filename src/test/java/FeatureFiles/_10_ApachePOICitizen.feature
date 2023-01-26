Feature: ApachePOI Citizen Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully
    And Navigate to CitizenShip page

    Scenario: Create citizenship from excel
      When User Create citizenship with excel

    Scenario: Delete citizenship from excel
      Then User Delete citizenship with ApachePOI