Feature: End to End Tests for Pet shop

Background: A valid user is created
Given The valid user logon to aplication succesfully

Scenario: The valid user is able to add pet
When User add pet to store
Then pet is added succesfully

Scenario: The valid user is able to check pets for given status
When user check pets for given status
Then valid result is displayed successfully


Scenario: The valid user is able to update pet
When user update the pet status
Then that pet is updated successfully

Scenario: The valid user is able to delete pet
When user delete the pet from store
Then that pet is deleted successfully



