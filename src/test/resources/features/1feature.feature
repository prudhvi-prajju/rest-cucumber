Feature: Get user details

  Scenario: get all employees information
    Given register end point "https://reqres.in/api"
    And define request
    When request is sent to Restfull service
    Then response received should be in JSON

  Scenario: Get specific employee information
    Given register end point "https://reqres.in/api"
    And define request
    When request is sent for respective employee "2" details
    Then JSON response received should contain employee details only
