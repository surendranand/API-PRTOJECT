@login
Feature: login Module API automation

  Scenario: Get User logtoken From login Endpoint
    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login in endpoint
    Then User verify status code is 200
    And User verify the login response body FirstName present as "Anbu" and get the logtoken saved
