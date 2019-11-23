package com.intelligencebank.stepDefinitions.resources;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Given;

public class GivenSteps extends StepDefinitionsBase {
    public GivenSteps(CucumberTestContext context) throws Throwable {
        super(context);
    }

    @Given("I am on the Resources page")
    public void i_am_on_the_Resources_page() throws Throwable {
        Pages().homePage().clickResourceButton();
    }
}
