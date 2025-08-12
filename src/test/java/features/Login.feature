Feature: Login Functionality

  Background:
    Given The User is on the Login page

   @smoke3
  Scenario: Successful login with valid credentials
     When The User enters a valid username and password
     And The User clicks the login button
     Then The User should be redirected to the Homepage

  @smoke3
  Scenario Outline: Unsuccessful login with invalid credentials
    When The User enters "<username>" and "<password>"
    And The User clicks the login button
    Then An error message should be displayed

    Examples:
      | username   | password   |
      | invalidUser| wrongPass  |
      | testUser   | wrong1234  |

  @smoke3
  Scenario: Login with empty credentials
    When The User leaves the username and password fields empty
    And The User clicks the login button
    Then An session error message should be displayed

  @smoke3
  Scenario: Logout successfully
    When The User enters a valid username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage
    When The User clicks the logout button
    Then The User should be redirected to the Login page