@smoke

Feature: As a user I want to get the address from the epam contacts page
  Scenario: The address should be received
    Given The epam contacts page is open
    When getting text from "Contact Us" section
    And get the address from the string
    Then the address is successfully extracted