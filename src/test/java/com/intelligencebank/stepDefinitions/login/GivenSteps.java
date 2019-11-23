package com.intelligencebank.stepDefinitions.login;

import com.intelligencebank.stepDefinitions.CommonSteps;
import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Given;

public class GivenSteps extends StepDefinitionsBase {
    public GivenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }
    @Given("I am logged in as an Admin")
    public void i_am_logged_in_as_an_Admin() throws Throwable {
        CommonSteps givenSteps = new CommonSteps(cucumberTestContext);
        givenSteps.i_open_the_param_page("Home");
        Pages().loginPage().loginAdmin(cucumberTestContext);
    }
}
