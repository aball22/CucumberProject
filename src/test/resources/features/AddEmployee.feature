Feature: Add employee to HRMs

  Background:
    When user enters valid username and password
    And user clicks on login button
    Then user sees dashboard page
    When user clicks on PIM option
    And user clicks on Add Employee option

  @accept1
  Scenario Outline: Admin user adds employee by first name and middle name and last name
    When user enters "<firstName>" and "<middleName>" and "<lastName>"
    And user clicks save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | Jane      | Anne       | Doe      |
      | John      | Jacob      | Doe      |
      | Jill      |Jo          |Doe       |

  @accept2 @Excel
  Scenario: Admin user adds employee by first name and last name and id
    When admin user adds employees and id numbers

  @accept3 @Empty
  Scenario: Incomplete add employee fields
    When user enters invalid first name and last name
    And user clicks save button
    Then empty field error message is displayed
