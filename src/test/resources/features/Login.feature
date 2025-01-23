Feature: Login Validation for HRMs Portal


  @valid
  Scenario: Valid admin login
    When user enters valid username and password
    And user clicks on login button
    Then user sees dashboard page


  @empty @username
  Scenario: Empty username field login
    When user does not enter username
    And user clicks on login button
    Then empty username error message is displayed


  @empty @password
  Scenario:
    When user enters username
    And user does not enter password
    And user clicks on login button
    Then empty password error message is displayed



  @invalid
  Scenario: Invalid admin login
    When user enters invalid username and password
    And user clicks on login button
    Then error message is displayed