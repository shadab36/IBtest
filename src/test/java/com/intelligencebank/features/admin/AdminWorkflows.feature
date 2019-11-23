Feature: Admin Create Workflows
  As an Admin
  I want to be able to create new Workflows
  So that I can automate my business processes 

Background: 
  Given I am logged in as an Admin
  
@overnight @AdminCreateWorkflows
Scenario Outline: Create New Default Workflows for Resources
	Given I open the "Admin" page
  When I click on Workflows Tab
    And I click on the "Create Workflow" button
    And I enter default values for a "<Workflow Type>" workflow for the "<Tool>" tool
    And I click on the Save New Workflow button
  Then verify the publish workflow is created

  Examples:
  | Workflow Type | Tool        |
  | Publish       | Resources   |
#  | Feedback      | Resources   |
#  | Download      | Resources   |
#  | Publish       | Databases   |
#  | Feedback      | Databases   |
#  | Publish       | Survey      |
#  | Feedback      | Survey      |
  