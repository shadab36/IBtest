package com.intelligencebank.stepDefinitions;

import com.intelligencebank.stepDefinitions.resources.data.Resources;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.intelligencebank.utils.CucumberTestContext;

public class Hooks extends StepDefinitionsBase {

   private Resources resources;

   public Hooks(CucumberTestContext context, Resources resources) throws Throwable {
      super(context);
      this.resources = resources;
   }

   @Before
   public void setUp(Scenario scenario) throws Throwable {
      cucumberTestContext.initialize();
      cucumberTestContext.getScenarioContext().setValue("ScenarioName", scenario.getName());
   }

   @After(value = "@DeleteFolders",order = 9999)
   public void deleteFolders() throws Throwable {
      String folderName = resources.folder.getName();
      if(folderName != null) {
         Pages().homePage().clickResourceButton();
         Pages().resourceFoldersPage().clickFolderActionButton(folderName);
         Pages().resourceFoldersPage().clickFolderActionButton(folderName);
         Thread.sleep(1000);
         Pages().resourceFoldersPage().selectDeleteFolder();
         Pages().deleteFolderDialog().clickDeleteFolder();
      }
   }

   @After(order = 10)
   public void tearDown() {
      if (cucumberTestContext == null)
         return;
      cucumberTestContext.tearDown();
   }
}
