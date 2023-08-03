@city
Feature: City Module API Automation

  Scenario: Verify User Get CityList Through ApI
    Given User add hearders for the city list
    When User add request body for add an object
    When User send "POST" request for citylist endpoint
    Then User verify status code is 200
    And User should verify the citylist response and message matches "Yercaud" and saved cityid
