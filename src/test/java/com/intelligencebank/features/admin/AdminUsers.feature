Feature: Admin Users 
	As an admin user
	I want to be able to manage the users for my Tenant
	So that I can confifgure who can access the Tenant and their permissions

Background: 
	Given I am logged in as an Admin

@overnight @UserManagement
Scenario Outline: Add a new user 
	Given I open the "Admin" page
		And I click on Users admin tab 
		And I click on Add User icon
		And I set "<Firstname>" into the "firstname" field 
		And I set "<Lastname>" into the "lastname" field 
		And I set "<Email>" into the email field 
		And I set the status of the new user as "<User Status>" 
		And I select the Groups 
		And I select Divisons 
		And I click on Users Save button 
	When I search the created user by email "<Email>"
	Then I should see the created user in the search result "<Email>" 
	Then Verify the staus of the user 
		And I delete the created account 
	Then Verify the user account is deleted successfully 
	
	Examples: 
		|Firstname |Lastname   |Email                       |User Status    |  
		|Test      |Automation |Seleniumact@getnada.com     |Active User    |
		|Test      |Automation |Seleniumsusp@getnada.com    |Suspended User |
		
		
		

		
