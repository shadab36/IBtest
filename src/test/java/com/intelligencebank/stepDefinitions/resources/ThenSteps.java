package com.intelligencebank.stepDefinitions.resources;

import com.intelligencebank.stepDefinitions.StepDefinitionsBase;
import com.intelligencebank.stepDefinitions.resources.data.Resources;
import com.intelligencebank.utils.CucumberTestContext;
import cucumber.api.java.en.Then;
import org.testng.Assert;

public class ThenSteps extends StepDefinitionsBase {
    private Resources resources;

    public ThenSteps(CucumberTestContext context, Resources resources) throws Throwable {
        super(context);
        this.resources = resources;
    }

    @Then("^it should take less than (.*) seconds$")
    public void it_should_take_less_than_seconds(Integer expectedTime) {
        long startTime = resources.startTime.getTime();
        long endTime = resources.endTime.getTime();
        long timeElapsed = endTime - startTime;
        long expectedTimeConverted = Long.valueOf(expectedTime * 1000);
        boolean isTimely = false;
        if(timeElapsed < expectedTimeConverted) {
            isTimely = true;
        }
        Assert.assertTrue(isTimely, String.format("The clone took longer that %n", expectedTime));
    }
}
