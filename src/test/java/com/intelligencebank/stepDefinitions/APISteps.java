package com.intelligencebank.stepDefinitions;

import org.junit.Assert;

import APIClient.IB_V2_API;
import APIClient.messages.folder.FolderResponse;

import cucumber.api.java.en.Given;
import com.intelligencebank.utils.CucumberTestContext;
import com.intelligencebank.utils.TestNGParameter;

public class APISteps extends StepDefinitionsBase {

   private IB_V2_API _APIClient;

   public APISteps(CucumberTestContext context) throws Throwable {
      super(context);
   }

   private IB_V2_API APIClient() {
      if (_APIClient == null) {

         String username = cucumberTestContext.getCredentialsManager().getAdminUsername();         
         String password = cucumberTestContext.getCredentialsManager().getAdminPassword();

         String sitebaseurl = cucumberTestContext.getScenarioContext().getParameter(TestNGParameter.BaseURL).toString();
         String sitename = cucumberTestContext.getScenarioContext().getParameter(TestNGParameter.SiteName).toString();
   
         _APIClient = new IB_V2_API(username, password, sitebaseurl, sitename);   
      }

      return _APIClient;
   }

   @Given("The folder {string} exists")
   public void the_folder_param_exists(String folder_uuid) throws Throwable {

      logger.error("the_folder_param_exists");

      FolderResponse folder = APIClient().Resources.folderExists(folder_uuid);

      Assert.assertNotNull(folder);
      Assert.assertNotNull(folder.response);
      Assert.assertNotNull(folder.response.resource);
      Assert.assertNotNull(folder.response.folder);
      Assert.assertTrue(folder.response.folder.size() == 1);

   }
}
