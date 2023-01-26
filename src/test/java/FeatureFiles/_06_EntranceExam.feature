#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

Feature: Exam Functionality
  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario: Create and Delete Exam
    And Click on the element in left nav
      |entranceExams|
      |setupExam|
      |entranceExamsSub|

    And Click on the element in the Dialog
      |plusIcon|

    And User sending the keys in Dialog Content
      |name|kljert1|

    And Click on the element in Form Content
      | academicPeriod  |
      | period2022      |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in the Dialog
      | save |

    Then Success message should be displayed

    And Click on the element in left nav
      |entranceExams|
      |setupExam|
      |entranceExamsSub|

    And User delete item from Dialog
      | kljert1 |

    Then Success message should be displayed







