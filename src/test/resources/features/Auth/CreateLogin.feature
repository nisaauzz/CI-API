Feature: As a user i want to create login user

  @CreateLogin
  Scenario: as user i want to input valid endpoint for create login user
    Given user has endpoint for create login user
    When user send request for create login user
    Then get response with status code 200
    And I receive valid data user login

  @CreateLogin-2
  Scenario: as user i want to get user info not valid auth
    Given user have invalid auth for create login user
    When user send request with invalid auth for create login user
    Then get error with status code 401
