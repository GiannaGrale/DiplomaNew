Feature: Pop-up message

  Scenario: Pop up message test
    Given browser is started
    *  Boris' login page is opened
    * log in with correct credentials
    When dashboard page is opened
    Then pop-up message check