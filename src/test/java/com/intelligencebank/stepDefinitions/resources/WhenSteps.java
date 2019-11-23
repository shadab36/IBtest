package com.intelligencebank.stepDefinitions.resources;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.resources.data.EndTime;
import com.intelligencebank.stepDefinitions.resources.data.Folder;
import com.intelligencebank.stepDefinitions.resources.data.Resources;
import com.intelligencebank.stepDefinitions.resources.data.StartTime;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.When;

public class WhenSteps extends StepDefinitionsBase {
    private Resources resources;

    public WhenSteps(CucumberTestContext context, Resources resources) throws Throwable {
        super(context);
        this.resources = resources;
    }

    @When("^I clone the folder '(.*)'$")
    public void i_clone_the_folder(String folderName) throws Throwable {
        Pages().resourceFoldersPage().clickFolderActionButton(folderName);
        Pages().resourceFoldersPage().clickFolderActionButton(folderName);
        Thread.sleep(1000);
        Pages().resourceFoldersPage().selectCloneStructure();
        Pages().cloneStructurePage().selectFolder("Resources");
        String clonedFolderName = String.format("%sclone", folderName);
        resources.folder = new Folder(clonedFolderName);
        Pages().cloneStructurePage().enterFolderName(clonedFolderName);
        Pages().cloneStructurePage().clickCloneButton();
        long start = System.currentTimeMillis();
        resources.startTime = new StartTime(start);
        Pages().cloneStructurePage().waitForDialogToDisapear();
        long end = System.currentTimeMillis();
        resources.endTime = new EndTime(end);
        Pages().resourceFoldersPage().goBack();
    }
}
