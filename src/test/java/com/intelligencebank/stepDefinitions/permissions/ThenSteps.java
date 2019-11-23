package com.intelligencebank.stepDefinitions.permissions;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Then;

import java.util.List;
import java.util.Map;

public class ThenSteps extends StepDefinitionsBase {
    public ThenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Then("^'(?:.*)' (?:can|cannot) perform the following file actions:$")
    public void can_perform_the_following_file_actions(List<Map<String, String>> dataTable) throws Throwable {
        Pages().resourceFilePage().iterateOverFilesAssertingPermissions(dataTable);
    }

    @Then("^'(?:.*)' (?:can|cannot) perform the following folder actions:$")
    public void can_perform_the_following_folder_actions(List<Map<String, String>> dataTable) throws Throwable {
        Pages().resourceFoldersPage().iterateOverFoldersAssertingPermissions(dataTable);
    }
}
