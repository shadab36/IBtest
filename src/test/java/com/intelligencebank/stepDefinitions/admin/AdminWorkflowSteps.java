package com.intelligencebank.stepDefinitions.admin;

import com.intelligencebank.pageObjects.admin.AddNewWorkflowPage;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

import com.intelligencebank.utils.CucumberTestContext;

public class AdminWorkflowSteps extends StepDefinitionsBase {

   public AdminWorkflowSteps(CucumberTestContext context) throws Throwable {
      super(context);
   }

   @And("^I click on Workflows Tab$")
   public void i_click_on_workflows_tab() throws Throwable {
      Pages().adminWorkflowsPage().clickWorkflowsTab();
   }

   @When("I enter default values for a {string} workflow for the {string} tool")
   public void i_enter_default_values_for_a_param_workflow(String workflowType, String tool)
         throws InterruptedException, Throwable {
      
      AddNewWorkflowPage page = Pages().addNewWorkflowPage();

      page.setName("TestPublishWorkFlow");
      page.selectWorkflow(workflowType);
      page.selectToolType(tool);

      if (workflowType.equalsIgnoreCase("Download") == false) {
         // Review process type doesn't exist for Download workflows
         page.selectReviewProcess("Standard");
         page.selectCommentSettings("Yes");
      }

      page.selectGlobalSettings("Yes");
      page.selectMandatory("Yes");
      page.selectReviewers("Requesters Choice");
      page.selectAutomCompleteSettings("Yes");

      page.selectRequireByFieldSettings("Yes");
      page.selectCommentOptionSettings("Yes");
      page.selectCommentFieldTypeSettings("Basic");
      page.selectUserNotificationSettings("Yes");

      // page.selectRequestFormType(requestformType);
   }

   @And("^I click on the Save New Workflow button$")
   public void user_clicks_on_the_save_button_on_workflow_page() throws Throwable {
      Pages().addNewWorkflowPage().clickSaveButton();
   }

   @Then("^verify the publish workflow is created$")
   public void verify_the_publish_workflow_is_created() throws Throwable {
      // TODO: Implement
      // throw new UnsupportedOperationException();
   }

}
