Feature: Testing JDBC States

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario: States testing with JDBC
    And Click on the element in left nav
      | setupLeft   |
      | parametersLeft |
      | states     |
    Then Send the query the database "select * from states" and control match