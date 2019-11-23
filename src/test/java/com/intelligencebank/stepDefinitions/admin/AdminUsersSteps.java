package com.intelligencebank.stepDefinitions.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;

public class AdminUsersSteps extends StepDefinitionsBase {

	public AdminUsersSteps(CucumberTestContext context) throws Throwable {
		super(context);
	}

	@When("^I click on Users admin tab$")
	public void click_on_users_admin_tab() throws InterruptedException {
      Pages().adminUsersPage().clickUserTab();
	}

	@Given("I click on Add User icon")
	public void i_click_on_add_user_icon() throws InterruptedException {
		Pages().adminUsersPage().clickAddUserIcon();
	}
	
	@Given("I set {string} into the email field")
	public void i_set_into_the_email_field(String email) {
		Pages().adminUsersPage().setEmail(email);
	}

	 @And("^I set the status of the new user as \"([^\"]*)\"$")
	 public void i_select_status_of_user_as(String userStatus)throws Throwable {
		Pages().adminUsersPage().selectUserStatus(userStatus);
	 }

	 @And("^I select the Groups$")
	 public void i_select_the_Groups()throws Throwable {
		Pages().adminUsersPage().selectGroup("Preview");
	 }

	 @And("^I select Divisons$")
	 public void i_select_Divisons()throws Throwable {
		Pages().adminUsersPage(). select_division();
	 }

	 @And("^I click on Users Save button$")
	 public void i_click_on_Save_button()throws Throwable {
		Pages().adminUsersPage().save();
	 }

	 @When("^I search the created user by email \"([^\"]*)\"$")
	 public void i_serach_the_created_user_with_email(String email)throws Throwable {
		Pages().adminUsersPage().search_user(email);
	 }

	@Then("^I should see the created user in the search result \"([^\"]*)\"$")
	public void i_should_see_the_created_user_in_the_search_result(String email)throws Throwable {
		// TODO: Move to pageObject
		WebDriver driver = cucumberTestContext.getWebDriverManager().getDriver();
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='two columns']"));

		String message = ele.getText();
		try {
			if (message.equalsIgnoreCase("Active User")) {
				Assert.assertTrue(message.contains("Active User"));
			} else {
				Assert.assertTrue(message.contains("Suspended User"));	
			}
		}
			catch(Exception e) {
		}
		
		System.out.println(email);  
	}

	@Then("Verify the staus of the user")
	public void verify_the_staus_of_the_user()throws Throwable {   
		 
		 //Implement this method
	}

	@And("^I delete the created account$")
	public void i_delete_the_created_account()throws Throwable {
		Pages().adminUsersPage().Delete_record();
	     
	}

	@Then("^Verify the user account is deleted successfully$")
	public void verify_the_user_account_is_deleted_successfully() throws Throwable{
		 //Implement this method
	}

}
