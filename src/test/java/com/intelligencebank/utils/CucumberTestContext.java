package com.intelligencebank.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CucumberTestContext {

   private static WebDriverManager webDriverManager;
	private static PageObjectManager pageObjectManager;
	private static ScenarioContext scenarioContext;
	private static CredentialsManager credentialManager;
	protected static Logger logger;

	public void initialize() throws Throwable {

      logger = LogManager.getLogger(this);
      logger.info("Initialised");

		scenarioContext = new ScenarioContext();

		TestNGParameters parameters = new TestNGParameters(true);
		scenarioContext.setTestNGParameters(parameters);

		credentialManager = new CredentialsManager(parameters);

		webDriverManager = new WebDriverManager();
		webDriverManager.createDriver(parameters);

		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
   }
   	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public CredentialsManager getCredentialsManager() {
		return credentialManager;
	}

	public void tearDown() {
		if (webDriverManager != null) {
			webDriverManager.closeDriver();
			webDriverManager = null;
		}

		if (pageObjectManager != null) {
			pageObjectManager = null;
		}

		if (credentialManager != null) {
			credentialManager = null;
		}

		if (scenarioContext != null) {
			scenarioContext.clear();
			scenarioContext = null;
		}
	}
}
