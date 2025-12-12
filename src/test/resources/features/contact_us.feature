@ui
Feature: Contact Us Form
  As a user of AutomationExercise
  I want to fill and submit the contact form
  So that I can send a message successfully

  Scenario: Successfully sending the contact us form
    Given Derly opens the AutomationExercise homepage
    When he navigates to the Contact Us section
    And he submits the contact form with:
      | name    | Derly Contreras                         |
      | email   | derly@test.com                          |
      | subject | Prueba Automatizada                     |
      | message | Formulario diligenciado automaticamente |
      | file    | src/test/resources/ArchivoPrueba.pdf    |
    Then the success message should be displayed
    And he navigates back to the home page