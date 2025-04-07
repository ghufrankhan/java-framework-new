Feature: Selenium web form tests

  Scenario: Interact with the UI elements on the Selenium web form page
    Given I have navigated to the Selenium web form page
    Then the page title should be 'Web form'
    When I enter 'random text' in the text input field
    And I enter 'complexpass' in the password field
    And I enter 'random text goes here' in the text area input
    And I select 'Three' from the dropdown select
    And I select 'Seattle' from the dropdown datalist
    When I click the submit button
    Then the page title should be 'Form submitted'
    And the message displayed should be 'Received!'
    And the URL should contain the following values
      | random text           |
      | complexpass           |
      | random text goes here |
      | 3                     |
      | Seattle               |