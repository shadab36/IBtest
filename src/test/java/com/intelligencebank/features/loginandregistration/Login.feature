Feature: Login Functionality
    As a user 
    I want to be able to login
    So I can use the system personalised to me

Background: User is NOT logged in
    Given I am not logged in

@smoke @login
Scenario Outline: Successful Login
    Given I open the "Login" page
	    And I set "<username>" into the username field  
	    And I set "<password>" into the password field  
    When I click on the "Login" button
	Then I expect to be logged in
    Then I take a screenshot "login success"

    Examples:
	    | username         | password       | 
        | {{DEFAULT}}      | {{DEFAULT}}    | 

@overnight @login
Scenario Outline: Unsuccessful login hows error message
  
    Given I open the "Login" page
	    And I set "<username>" into the username field  
	    And I set "<password>" into the password field  
    When I click on the "Login" button
    Then I expect the error message to be "<errormessage>"
  
    Examples: 
        | username                 | password              | errormessage                                                                                                                                                        | 
        | {{DEFAULT}}              | Incorrect_123**       | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the \"Forgot your Password?\" link below. | 
        | {{DEFAULT}}              | invalid               | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the \"Forgot your Password?\" link below. | 
        | {{DEFAULT}}              |                       | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the \"Forgot your Password?\" link below. | 
        |                          | {{DEFAULT}}           | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the \"Forgot your Password?\" link below. | 
        | doesnt.exist@gmail.com   | {{DEFAULT}}           | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the \"Forgot your Password?\" link below. | 
        | invalid                  | Incorrect_123**       | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the \"Forgot your Password?\" link below. | 
        | invalid                  | Invalid               | Invalid username or password, or you have exceeded the maximum allowed attempts. To request a password reset email, click the \"Forgot your Password?\" link below. | 
