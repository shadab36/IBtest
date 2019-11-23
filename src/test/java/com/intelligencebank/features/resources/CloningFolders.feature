Feature: Cloning folders
  As a user
  I want to be able to clone folders and delete the clones
  In a timely manner

  @DeleteFolders @Resources
  Scenario: Clone folders should take less than 1 minute
    Given I am logged in as an Admin
    And I am on the Resources page
    When I clone the folder 'Minute'
    Then it should take less than 60 seconds