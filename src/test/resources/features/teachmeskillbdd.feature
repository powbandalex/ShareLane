Feature: Search course
  Scenario: User searches for course
    Given User is on main screen
    When User clicks "Курсы" tab
    And User click "Офлайн курсы" button
    Then "Front End разработчик" option presents and is first in the list
