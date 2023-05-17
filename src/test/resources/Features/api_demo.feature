@api
Feature: Demo api test

  Scenario: Should have a working with get method
    When I make a GET call on /posts
    Then I should receive 200 response status code
    And should receive a non-empty body