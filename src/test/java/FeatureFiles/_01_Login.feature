#Senaryo ;
  #1- siteyi açınız
  #2- username ve password u gönderin ve login butonuna tıklayın
  #3- login olduğunuzu doğrulayın

Feature:Login Functionality
  @Regression
  Scenario: Login with valid username and password
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully
    