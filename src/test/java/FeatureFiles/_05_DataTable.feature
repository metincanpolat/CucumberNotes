Feature: Datatable Functionality
  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in left nav
    |setupLeft|
    |parametersLeft|
    |countriesLeft|

    And Click on the element in the Dialog
    |plusIcon|

    And User sending the keys in Dialog Content
      |name|kljert1|
      |code|kl44|

    And Click on the element in the Dialog
      |save|

    Then Success message should be displayed

    And User delete item from Dialog
    |kljert1|

    Scenario: Create a Nationality
      And Click on the element in left nav
        |setupLeft|
        |parametersLeft|
        |nationalities|

      And Click on the element in the Dialog
        |plusIcon|

      And User sending the keys in Dialog Content
        |name|kljert1|

      And Click on the element in the Dialog
        |save|

      Then Success message should be displayed

      And User delete item from Dialog
        |kljert1|

  Scenario: Create a Fees
    And Click on the element in left nav
      |setupLeft|
      |parametersLeft|
      |feesSetup|

    And Click on the element in the Dialog
      |plusIcon|

    And User sending the keys in Dialog Content
      |name|kljert1|
      |code|kl1|
      |integrationCode|856558|
      |priorty|2|

    And Click on the element in the Dialog
      |toggleBar|
      |save|

    Then Success message should be displayed

    And User delete item from Dialog
      |kljert1|

    Then Success message should be displayed

    #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
    #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.