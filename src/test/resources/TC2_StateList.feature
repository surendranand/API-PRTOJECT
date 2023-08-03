@state
Feature: State Module API Automation
Scenario: Verify User Get StateList Through API
Given User add hearders for the statelist
When User send "GET" request for statelist endpoint
 Then User verify status code is 200
And User should verify the statelist response message matches "Tamil Nadu" and save state id
