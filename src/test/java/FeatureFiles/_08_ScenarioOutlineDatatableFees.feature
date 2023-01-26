#Senaryo :
#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 5 farklı değerler için çalıştırınız.

Feature: Fees Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Create a Fees
    And Click on the element in left nav
      | setupLeft      |
      | parametersLeft |
      | feesSetup      |

    And Click on the element in the Dialog
      | plusIcon |

    And User sending the keys in Dialog Content
      | name            | <name>            |
      | code            | <code>            |
      | integrationCode | <integrationCode> |
      | priorty         | <priorty>         |

    And Click on the element in the Dialog
      | toggleBar |
      | save      |

    Then Success message should be displayed

    And User delete item from Dialog
      | <name> |

    Then Success message should be displayed
    Examples:
      | name    | code | integrationCode | priorty |
      | kljert1 | kl1  | 856558          | 2       |
      | kljert2 | kl2  | 856557          | 2       |
      | kljert3 | kl3  | 856556          | 2       |
      | kljert4 | kl4  | 856555          | 2       |


#    CTRL+ALT+L çubukları düzenlemek için