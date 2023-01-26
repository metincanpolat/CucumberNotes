Feature: Country Multi Scenario
  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully
    And Navigate to country page

    Scenario: Create Country
      When Create a country
      Then Success message should be displayed

    Scenario: Create a country parameter data
      When Create a country name as "metidnsLkjo" code as "554ds12il"
      Then Success message should be displayed