package com.intelligencebank.stepDefinitions.permissions;

import cucumber.api.java.en.When;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;

public class WhenSteps extends StepDefinitionsBase {
    public WhenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @When("^'(.*)' has navigated to '(.*)'$")
    public void has_navigated_to(String uname, String page) throws Throwable {
        Pages().homePage().logoutFromMenu();
        Pages().loginPage().login(cucumberTestContext, uname);
        switch (page.toLowerCase()) {
            case "resources":
                Pages().homePage().clickResourceButton();
                break;
            default:
                throw new cucumber.api.PendingException();
        }
    }
}
