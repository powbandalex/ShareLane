Feature: Search course

  @qa
  Scenario Outline: User searches for course
    Given User is on main screen
    When User clicks "Курсы" tab
    And User click <course> button
    Then "Front End разработчик" option presents and is first in the list
    Examples:
      | course         |
      | "Офлайн курсы" |
      | "Онлайн-курсы" |


  @prod
  Scenario: User searches for course
    Given User is on main screen
    When User clicks "Курсы" tab
    And User click "Офлайн курсы" button
    Then "Python разработчик" option presents and is first in the list
