Feature: Login Functionality

  Background:
    Given The User is on the Login page

   @smoke @login @regression
  Scenario: Successful login with valid credentials
     When The User enters a valid username and password
     And The User clicks the login button
     Then The User should be redirected to the Homepage

  @smoke @login @regression
  Scenario Outline: Unsuccessful login with invalid credentials
    When The User enters "<username>" and "<password>"
    And The User clicks the login button
    Then An error message should be displayed

    Examples:
      | username   | password   |
      | invalidUser| wrongPass  |
      | testUser   | wrong1234  |

  @smoke @login @regression
  Scenario: Login with empty credentials
    When The User leaves the username and password fields empty
    And The User clicks the login button
    Then An session error message should be displayed

  @smoke @login @regression
  Scenario: Logout successfully
    When The User enters a valid username and password
    And The User clicks the login button
    Then The User should be redirected to the Homepage
    When The User clicks the logout button
    Then The User should be redirected to the Login page

    @smoke @login @regression @location
  Scenario Outline: Login with different locations: The User selects "<location>" for the session
    When The User enters username and password
    And The User selects a "<location>" for the session
    And The User clicks the login button
    Then The User should be redirected to the Homepage
    And The User verifies the selected "<location>" is displayed on the login page
    When The User clicks the logout button
    Then The User should be redirected to the Login page
    Examples:
      | location          |
      | Inpatient Ward    |
      | Isolation Ward    |
      | Laboratory        |
      | Pharmacy          |
      | Registration Desk |
      | Outpatient Clinic |


    @smoke @login @regression @help
    Scenario: When The User clicks on the "Can't log in?" link
      When The User clicks on the "Can't log in?" link
      Then the "Can't log in?" pop up message should appear
      When The User clicks on the Okay button of the "Can't log in?" pop up
      Then the "Can't log in?" pop up message should close


    @security @login @regression
    Scenario Outline: SQL injection Protection on Login Page
      When The User enters "<username>" and "<password>"
      And The User clicks the login button
      Then An error message should be displayed

      Examples:
        | username                 | password                 |
        | ' OR '1'='1              | ' OR '1'='1              |
        | ' UNION SELECT * FROM users; -- | ' UNION SELECT * FROM users; -- |


    @security @login @regression
      Scenario Outline: XSS payload Protection on Login Page
        When The User enters "<username>" and "<password>"
        And The User clicks the login button
        Then An error message should be displayed

        Examples:
          | username                 | password      |
          | <script>('XSS')</script> | dummyPassword |

