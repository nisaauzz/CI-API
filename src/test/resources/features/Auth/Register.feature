Feature: As a user i want to create new user register

  @CreateRegister
  Scenario: as user i want to input valid data for create user register
    Given user has endpoint for create user register
    When user send endpoint for create user register
    Then user get status code 200
    And I receive valid data user register

  @CreateRegister-2
  Scenario: as user i cannot create user register with invalid endpoint
    Given user set invalid endpoint for create user register
    When user send request to invalid endpoint for create user register
    Then user see error status code 404