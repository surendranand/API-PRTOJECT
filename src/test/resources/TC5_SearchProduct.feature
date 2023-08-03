@search
Feature: Search product Module API Automation
Scenario: Verify User Get the search product Through ApI
Given User add hearders for the search product list
When user add request body for search product "<text>"
And  User send "POST" request for search product endpoint
    Then User verify status code is 200
And User should verify the search product response and message "OK"
Examples: 
|text|
|nuts|