Feature: Registration Functionaliy
  As a person new to the system
  I want to be able to register
  So I can start using the system

Background: User is NOT logged in
  Given I am not logged in

@regression @registration
Scenario: Registration button on Login page
  Given I open the "Login" page
  When I click on the "Register" button
  Then I expect to be on the "Registration" page

@overnight @registration @ignore
Scenario Outline: Successful Registration
  Given I open the "Registration" page
    And I set the mandatory registration fields
    And I click on the "Register" button
  Then I expect to be on the "Verification Sent" page
    And I expect the user verification email to be sent to "<Email>"
    And I expect a user with "<Email>" to be created with status "Inactive"

  Examples:
  | FirstName | LastName | Email          | 
  | Test      | Test     | test@email.com | 
          
@overnight @registration @ignore
Scenario Outline: Registration error message
  Given user visits IB platform website 
    When user clicks on the login button for homepage
    And user clicks on the Register link on the login page
    And user enters the First Name as <firstname>
    And user enters the Last Name as <lastname>
    And user enters the email as <email>
    And user clicks on the Register button
  Then verify the correct errormessage is displayed for correct field type <errormessage>, <errorfield>
  
  Examples: 
    | firstname | lastname | email                    | errormessage                                                                                                                                                              | errorfield | 
    |           |          |                          | We found errors while submitting your registration request. Update the information below, or check that this email address has not been registered already and try again. | general    | 
    |           | Saraiya  | namreshsaraiya@gmail.com | Value is required and can't be empty                                                                                                                                      | firstname  | 
    | Namresh   |          | namreshsaraiya@gmail.com | Value is required and can't be empty                                                                                                                                      | lastname   | 
    | Namresh   | Saraiya  |                          | Value is required and can't be empty                                                                                                                                      | emailempty | 
    | Namresh   | Saraiya  | n@g.                     | The Email Address is in an invalid format, e.g. myemail@myaddress.com!                                                                                                    | wrongemail | 

