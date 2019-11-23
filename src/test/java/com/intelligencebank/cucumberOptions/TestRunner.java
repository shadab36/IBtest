package com.intelligencebank.cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/com/intelligencebank/features/",
		glue = {"com/intelligencebank/stepDefinitions/"},

	    plugin = {"pretty","html:target/report/cucumber","json:target/report/json/login.json", "unused:target/unused.log"})
public class TestRunner extends AbstractTestNGCucumberTests {
	
}