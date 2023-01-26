#Senaryo :
#  Employee menusu için Create-Exist-Delete bölümleri olan Senaryoyu yazınız
#  Daha sonra aynı senaryoru 5 farklı degerler için çalıştırınız.

Feature: Employee Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Create-Exist-Delete an Employee
    And Click on the element in left nav
      | humanResources |
      | employees      |

    And Click on the element in the Dialog
      | plusIcon |

    And User sending the keys in Form Content
      | firstName      | <firstname>      |
      | lastName       | <lastname>       |
      | employeeID     | <employeeID>     |
      | documentNumber | <documentNumber> |

    And Click on the element in Form Content
      | documentType   |
      | <documentType> |
      | contactAddress |

    And Choose a country

    And Click on the element in Form Content
      | additionalInfo |

    And User sending the keys in Form Content
      | alyup | Offspring |

    And Click on the element in Form Content
      | save |

    Then Success message should be displayed

    And Click on the element in left nav
      | humanResources |
      | employees      |

    And Click on the element in the Dialog
      | plusIcon |

    And User sending the keys in Form Content
      | firstName      | <firstname>      |
      | lastName       | <lastname>       |
      | employeeID     | <employeeID>     |
      | documentNumber | <documentNumber> |

    And Click on the element in Form Content
      | documentType   |
      | <documentType> |
      | contactAddress |

    And Choose a country

    And Click on the element in Form Content
      | additionalInfo |

    And User sending the keys in Form Content
      | alyup | Offspring |

    And Click on the element in Form Content
      | save |

    Then Already exist message should be displayed

    And Click on the element in left nav
      | humanResources |
      | employees      |

    And User delete item from Dialog
      | <firstname>  |

    Then Success message should be displayed
    Examples:
      | firstname | lastname | employeeID | documentNumber | documentType |
      | MetCan    | polat    | 123456     | 654321         | personalID   |
      | NacTem    | talop    | 521254     | 2555321        | passport     |




