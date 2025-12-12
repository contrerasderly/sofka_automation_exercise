@api
Feature: PetStore API Automation
  As a QA Engineer
  I want to validate the lifecycle of a pet using the PetStore API
  So that I can ensure the API works correctly

  Scenario: Create and retrieve a pet successfully
    Given Derly is an API user
    When she creates a new pet
    Then the response status should be 200
    And she retrieves the pet by id
    Then the pet should be returned successfully

