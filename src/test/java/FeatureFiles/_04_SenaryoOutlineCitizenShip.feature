#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız.
#Yukarıdki işlemleri Parameter yöntemi ile yapınız.
Feature: CitizenShip

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully
    And Navigate to CitizenShip page

#    @SmokeTest @Regression
    Scenario Outline: CitizenShip Create
      When User a CitizenShip name as "<Name>" short name as "<ShortName>"
      Then Success message should be displayed

      When User a CitizenShip name as "<Name>" short name as "<ShortName>"
      Then Already exist message should be displayed

#      When User delete the "<Name>"
      Then Success message should be displayed

      Examples:
        |Name  |ShortName|
        |MetCa21|MetCa21   |
        |MetCa21|MetCa21   |
#        |MetCa3|MetCa3   |
#        |MetCa4|MetCa4   |

