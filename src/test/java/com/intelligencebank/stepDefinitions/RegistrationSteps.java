package com.intelligencebank.stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import com.intelligencebank.utils.CucumberTestContext;

public class RegistrationSteps extends StepDefinitionsBase {

   public RegistrationSteps(CucumberTestContext context) throws Throwable {
      super(context);
   }

   @And("^user clicks on the Register button$")
   public void user_clicks_on_the_register_button() throws Throwable {
      Pages().registrationPage().clickRegisterbutton();
   }

   @Then("^verify the correct errormessage is displayed for correct field type (.+), (.+)$")
   public void verify_the_correct_errormessage_is_displayed_for_correct_field_type_(String errormessage,
         String errorfield) throws Throwable {
      throw new UnsupportedOperationException();
   }

   @And("^user enters the First Name as (.+)$")
   public void user_enters_the_first_name_as(String firstname) throws Throwable {
      Pages().registrationPage().setFirstname(firstname);
   }

   @And("^user enters the Last Name as (.+)$")
   public void user_enters_the_last_name_as(String lastname) throws Throwable {
      Pages().registrationPage().setLastname(lastname);
   }

   @And("^user enters the email as (.+)$")
   public void user_enters_the_email_as(String email) throws Throwable {
      Pages().registrationPage().setEmail(email);
   }
}
