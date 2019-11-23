package com.intelligencebank.stepDefinitions.resources;




import java.awt.AWTException;



import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TransformationAdvanceOption extends StepDefinitionsBase {

	public TransformationAdvanceOption(CucumberTestContext context) throws Throwable {
		super(context);
	
	}

	@And("^I search the \"([^\"]*)\" and click on that $")
	public void click_on_users_admin_tab() throws InterruptedException {
		Pages(). transformationAdvancedOptionsPage().searchFoldername("Folder");
	}

	@Given("I selects multiple Image files")
	public void i_click_on_add_user_icon() throws InterruptedException {
		Pages(). transformationAdvancedOptionsPage().SelectMultiFolder();
	}
	
	@And("I select Bulk Download Action")
	public void i_set_into_the_email_field(String email) throws InterruptedException, AWTException {
		Pages(). transformationAdvancedOptionsPage().SelectDownlod();
	}

	 @And("^I selects Tranformation Options$")
	 public void i_select_status_of_user_as(String userStatus)throws Throwable {
		 Pages(). transformationAdvancedOptionsPage().clickTransformation();
	 }

	 @And("^user clicks on Add Preset Button$")
	 public void i_select_the_Groups()throws Throwable {
		 Pages(). transformationAdvancedOptionsPage().clickAddPreset();
	 }

	 @When("^I turns \"([^\"]*)\" on the Advanced Option $")
	 public void i_select_Divisons(String option)throws Throwable {
	    	  Pages(). transformationAdvancedOptionsPage().Enable_AdvanceOption("Advance");
	   	 
	 }

	 @Then("^I verify the \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" field$")
	 public void i_click_on_Save_button(String ColorSpace,String Rotate, String Flip )throws Throwable {
		  Pages(). transformationAdvancedOptionsPage().verify_AdvanceFiled("ColorSpace","Rotate","Flip");
		  Pages(). transformationAdvancedOptionsPage().Default_AdvanceOption("ColorSpace","Rotate","Flip");
	 }

	

}
