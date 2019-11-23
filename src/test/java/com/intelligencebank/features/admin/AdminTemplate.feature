Feature: Admin Templates 
	As an admin user
	I want to be able to manage how my Site looks and Feels
	So that I can confifgure a nice user experience

Background: 
	Given I am logged in as an Admin 
	And I open the "Admin" page 
	And I click on the Templates tab 
	
@overnight @AdminTemplates 
Scenario: Configure Fonts 
	When I set "Title Font Size" to "16" 
	And I set "Primary Font Size" to "14" 
	And I click on the "Save" button 
	
@overnight @AdminTemplates @ignore 
Scenario: Configure Heading Banner 
	When I click the Add Headbanner Button on the Admin Templates page 
	And I select an image from my local download folder 
	And I click "Ok" 
	And I click on the "Save" button 
	Then I expect to see the selected Headbanner on the page 
	
	
