@permissions12
Feature: Transformation Options - Advanced Options On/Off Toggle 
Background: 
	Given I am on the Resources page 
	
	@Trnasformation
Scenario: select the specfic folder and move to preset resource page 
	And I search the "Prajakta Test folder" and click on that 
	And I selects multiple Image files 
	And I select Bulk Download Action 
	And I selects Tranformation Options 
	And user clicks on Add Preset Button 
Scenario Outline: User turn ON/ OFF  advance option on Add preset page 
	When I turns "<status>" on the Advanced Option 
	Then I verify the "<Color Space>", "<Flip>" and "<Rotate>" field 
	Examples: 
		| status | Color Space |Rotate   | Flip    |
		| ON     | Visible     | Visible | Visible | 
		| OFF    | Hidden      | Hidden  | Hidden  |
     