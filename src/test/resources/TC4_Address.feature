@address
Feature: Address Module API Automation
 Scenario Outline: Verify add user address to the application throught api
    Given User add header and bearer authorization for accessing address endpoint
    When User add resquest body for add new address "<first_name>","<last_name>","<mobile>","<apartment>",<state>, <city>, <country>,"<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for add user address endpoint
    Then User verify status code is 200
    And User should  verify the address response message matches "Address added successfully" and save Address id

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address            | address_type |
      | surendran  | anbu      | 9003100590 | apartment |    35 |   11 |     101 |  202020 | 64/63 partap nagar | home         |
 
  Scenario Outline: Verify update user address to the application throught api
    Given User add header and bearer authorization for accessing address endpoint
    When User add resquest body for update add address "address_id","<first_name>","<last_name>","<mobile>","<apartment>",<state>, <city>, <country>,"<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for  update  user address endpoint
    Then User verify status code is 200
    And User should verify the address response message matches "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address            | address_type |
      | surendran  | anbu      | 9003100590 | apartment |    33 | 3378 |     101 |  202020 | 64/63 partap nagar | home         |

 Scenario: Verify get All address to the application through api
    Given User add header and bearer authorization for accessing address endpoint
    When User send "GET" request for getAllAddress endpoint
    Then User verify status code is 200
    And User should verify the getAllAddress response messagematches"OK"

  Scenario Outline: Verify  delete particular user address throught api
    Given User add header and bearer authorization for accessing address endpoint
    When User add resquest body for delete address  "address_id"
    When User send "DELETE" request for delete paricular user address endpoint
    Then User verify status code is 200
    And User should verify the address response message matches "Address deleted successfully"
