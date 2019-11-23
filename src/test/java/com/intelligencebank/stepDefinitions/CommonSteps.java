package com.intelligencebank.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.intelligencebank.utils.CucumberTestContext;
import com.intelligencebank.utils.TestNGParameter;
import com.intelligencebank.utils.WebDriverManager;

public class CommonSteps extends StepDefinitionsBase {

   public CommonSteps(CucumberTestContext context) throws Throwable {
      super(context);
   }

   private String getPageURL(String page) {
      switch (page) {
      case "Home":
         return "";
      case "Login":
          return "";
      case "Admin":
         return "core/admin/index";
      }
      return null;
   }
   private WebElement findElement(String needle) throws Throwable {

      WebDriver driver = cucumberTestContext.getWebDriverManager().getDriver();
      WebElement found = null;

      Integer retry = 0;
      while (retry < 20) {
         if (found == null)
            try {
               found = driver.findElement(By.id(needle));
            } catch (Exception e) {
            }
         if (found == null)
            try {
               found = driver.findElement(By.name(needle));
            } catch (Exception e) {
            }
         if (found == null)
            try {
               found = driver.findElement(By.className(needle));
            } catch (Exception e) {
            }
         if (found == null)
            try {
               found = driver.findElement(By.xpath("//*[contains(text(),'" + needle + "')]"));
            } catch (Exception e) {
            }
         if (found != null)
            break;

         retry++;
         Thread.sleep(500);
      }

      return found;
   }

   @Given("^I open the \"([^\"]*)\" page$")
   public void i_open_the_param_page(String page) throws Throwable {

      WebDriver driver = cucumberTestContext.getWebDriverManager().getDriver();
      String baseURL = cucumberTestContext.getScenarioContext().getParameter(TestNGParameter.BaseURL).toString();
      String absoluteURL = baseURL;

      String predefinedURL = getPageURL(page);
      absoluteURL += "/" + predefinedURL;

      driver.get(absoluteURL);
   }

   @Given("^I open the url \"([^\"]*)\"$")
   public void i_open_the_url(String url) throws Throwable {

      WebDriver driver = cucumberTestContext.getWebDriverManager().getDriver();
      String baseURL = cucumberTestContext.getScenarioContext().getParameter(TestNGParameter.BaseURL).toString();
      String absoluteURL = baseURL;

      absoluteURL += "/" + url;

      driver.get(absoluteURL);
   }

   @When("^I (add|set) \"([^\"]*)\" into the \"([^\"]*)\" field$")
   public void i_addset_param_into_the_inputfield_param(String action, String value, String inputField)
         throws Throwable {

      WebElement input = findElement(inputField);

      if (action.toLowerCase().trim() == "add") {
         input.sendKeys(value);
      } else {
         input.clear();
         input.sendKeys(value);
      }
   }

   @When("I click on the {string} (link|button|element)")
   public void i_click_on_the_param_linkbuttonelement(String identifier) throws Throwable {
      WebElement element = findElement(identifier);
      element.click();
   }

   @When("I double click on the {string} (link|button|element)")
   public void i_double_click_on_the_param_linkbuttonelement(String identifier) throws Throwable {
      WebElement element = findElement(identifier);
      element.click();
      Thread.sleep(250);
      element.click();
   }

   @Then("^I take a screenshot \"([^\"]*)\"$")
   public void i_take_a_screenshot(String screenshotFilename) throws Throwable {

      String scenarioName = cucumberTestContext.getScenarioContext().getValue("ScenarioName").toString();

      WebDriverManager webDriverManager = cucumberTestContext.getWebDriverManager();
      webDriverManager.takeScreenshot(scenarioName, screenshotFilename);
   }
}