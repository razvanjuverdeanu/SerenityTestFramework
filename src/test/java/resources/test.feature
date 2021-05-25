Feature: Call to endpoints

  @Positive
  Scenario: Validate response of current comic endpoint
    When the user calls for current comic
    Then the status code is 200
    And the response matches comic data type

  @Positive
  Scenario: Validate response of given comic number endpoint
    Given the user calls for current comic
    When the user calls for comic number by comicId using current comic id
    Then the status code is 200
    And the response contains same data as current comic

  @Negative
  Scenario: Validate that negative comicId returns 404 status code
    When the user calls for -200 comic number endpoint
    Then the status code is 404




