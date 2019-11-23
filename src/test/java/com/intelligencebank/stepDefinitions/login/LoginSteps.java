package com.intelligencebank.stepDefinitions.login;

import com.intelligencebank.stepDefinitions.CommonSteps;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import com.intelligencebank.pageObjects.HomePage;
import com.intelligencebank.utils.CucumberTestContext;
import org.testng.Assert;

public class LoginSteps extends StepDefinitionsBase {

   public LoginSteps(CucumberTestContext context) throws Throwable {
      super(context);
   }

   @Given("^I am not logged in$")
   public void i_am_not_logged_in() throws Throwable {
      CommonSteps givenSteps = new CommonSteps(cucumberTestContext);
      givenSteps.i_open_the_param_page("Home");

      HomePage page = Pages().homePage();
      if (page.logoutLinkExists())
         page.LogoutLink.click();
   }

   @Then("^I expect to be logged in$")
   public void I_expect_to_be_logged_in() throws Throwable {
      Assert.assertEquals(Pages().homePage().logoutLinkExists(), true);
   }

   @Then("I expect the error message to be {string}")
   public void i_expect_the_error_message_to_be(String expected) throws Throwable {

      String errorMessage = Pages().loginPage().getErrorMessage();

      Assert.assertEquals(errorMessage, expected);
   }

   @When("^I set \"([^\"]*)\" into the username field$")
   public void i_set_param_into_the_username_field(String username) throws Throwable {

      String envVarUsername = "";
      switch (username) {
      case "{{DEFAULT}}":
         envVarUsername = cucumberTestContext.getCredentialsManager().getDefaultUsername();
         Pages().loginPage().setUsername(envVarUsername);
         return;
      case "{{ADMIN}}":
         envVarUsername = cucumberTestContext.getCredentialsManager().getAdminUsername();
         Pages().loginPage().setUsername(envVarUsername);
         return;
      }

      Pages().loginPage().setUsername(username);
   }

   @When("^I set \"([^\"]*)\" into the password field$")
   public void i_set_param_into_the_password_field(String password) throws Throwable {

      String envVarPassword = "";
      switch (password) {
      case "{{DEFAULT}}":
         envVarPassword = cucumberTestContext.getCredentialsManager().getDefaultPassword();
         Pages().loginPage().setPassword(envVarPassword);
         return;
      case "{{ADMIN}}":
         envVarPassword = cucumberTestContext.getCredentialsManager().getAdminPassword();
         Pages().loginPage().setPassword(envVarPassword);
         return;
      }

      Pages().loginPage().setPassword(password);
   }

   @When("^user clicks on the login button for homepage$")
   public void user_clicks_on_the_login_button_for_homepage() throws Throwable {
   }

   @And("^user clicks on the Register link on the login page$")
   public void user_clicks_on_the_register_link_on_the_login_page() throws Throwable {
      throw new UnsupportedOperationException();
   }
}
