Feature: Register new employees

  Scenario Outline: Post new employees data
    Given register end point "https://reqres.in/api"
    And define request
    When post request is sent with "<name>" and "<job>"
    Then response received shows employee ID created

    Examples: 
      | name      | job      |
      | prudhvi   | software |
      | venkatesh | hardware |
