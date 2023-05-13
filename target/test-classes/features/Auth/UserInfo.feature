Feature: As a user i want to get user information

  @UserInfo
  Scenario: as user i want to input all valid data in get user information
    Given user have endpoint auth
    When user send endpoint Auth
    When user has endpoint to get user information
    And user get user information
    Then user get user information status code 200

