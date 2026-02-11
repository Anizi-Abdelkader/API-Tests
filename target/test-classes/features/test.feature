Feature: Test


  Scenario: test Post : login
    Given The user has their username and password
      | username         | user@example.com |
      | password         | string           |
    When The user the user logs in
    Then The status code is 200
    And This response was returned
      | token | string |