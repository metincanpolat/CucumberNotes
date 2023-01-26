#Senaryo :
#Senaryo :
#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel1  |
#| IT exam is1     | academicPeriod1              | gradeLevel2  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel3  |
#| Math exam  is1  | academicPeriod1              | gradeLevel4  |

Feature: Exam Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfully

  Scenario Outline: Create and Delete Exam
    And Click on the element in left nav
      | entranceExams    |
      | setupExam        |
      | entranceExamsSub |

    And Click on the element in the Dialog
      | plusIcon |

    And User sending the keys in Dialog Content
      | name | <ExamName> |

    And Click on the element in Form Content
      | academicPeriod         |
      | <AcademicPeriodOption> |
      | gradeLevel             |
      | <GradeLevelOption>     |

    And Click on the element in the Dialog
      | save |

    Then Success message should be displayed

    And Click on the element in left nav
      | entranceExams    |
      | setupExam        |
      | entranceExamsSub |

    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed
    Examples:
      | ExamName       | AcademicPeriodOption | GradeLevelOption |
      | Math exam 1.   | period2022           | gradeLevel2      |
      | IT exam 1.     | period2022           | gradeLevel3      |
      | Oracle exam 1. | period2022           | gradeLevel4      |
      | Math exam  1.  | period2022           | gradeLevel5      |