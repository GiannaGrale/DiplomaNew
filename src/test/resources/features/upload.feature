Feature: Upload

  Scenario: Upload a picture to a test case
    Given browser is started
    * Anna's login page is opened
    And successfulSignIn
    When Project is created
    Then Create a test case in a project with an uploaded picture