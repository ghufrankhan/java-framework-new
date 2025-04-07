Feature: API tests for the Genderize.io service
"""
  Endpoint example: https://api.genderize.io?name=peter
  More information: https://www.freepublicapis.com/genderizeio
"""

  Scenario: Verify that the name and gender are returned for a male
    Given I send a GET request to the endpoint with the value 'John'
    Then the response status code should be 200
    And the response body contains the name 'John'
    And the response body contains the gender 'male'

  Scenario: Verify that the name and gender are returned for a female
    Given I send a GET request to the endpoint with the value 'Lisa'
    Then the response status code should be 200
    And the response body contains the name 'Lisa'
    And the response body contains the gender 'female'

  Scenario: Verify that null is returned for an invalid name
    Given I send a GET request to the endpoint with the value '123'
    Then the response status code should be 200
    And the response body contains the name '123'
    And the response body contains the gender 'null'