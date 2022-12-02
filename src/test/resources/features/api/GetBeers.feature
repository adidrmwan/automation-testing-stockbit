@Api @Beers
Feature: As User, I have be able to get beers data based on parameter

  @GetBeers
  Scenario Outline: As User, I have be able to get data with number of data parameter
    Given user prepare data for the parameter of per page "<number>"
    When user send get beers HTTP request with param
    Then user validate response status code <status_code> from get beers
    And user validate the data per page is <number>

  Examples:
    |number   |status_code    |
    |1        |200            |
    |5        |200            |
    |20       |200            |

  @GetBeersValidateJsonSchema
  Scenario: As User, I have be able to get data and validate the response with json schema
    Given user send get beers HTTP request
    Then user validate response status code 200 from get beers
    And user validate the data per page is 25
    And user see list of name in response of get beers
    And user validate the response of get beers with json schema