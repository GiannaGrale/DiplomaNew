Feature: Login

  Background:
    Given browser is started
    When Boris' login page is opened

  Scenario: Positive sign in  test
    Then log in with correct credentials

  Scenario: Border value test while logging in
    Then border value in the email input while signing in


