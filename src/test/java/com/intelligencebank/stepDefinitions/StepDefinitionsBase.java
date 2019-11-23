package com.intelligencebank.stepDefinitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.intelligencebank.utils.CucumberTestContext;
import com.intelligencebank.utils.PageObjectManager;

public class StepDefinitionsBase {

   protected CucumberTestContext cucumberTestContext;
   protected static Logger logger;

   public StepDefinitionsBase(CucumberTestContext context) throws Throwable {
      cucumberTestContext = context;

      logger = LogManager.getLogger(this);
      logger.info("Initialised");
   }

   protected PageObjectManager Pages() {
      return cucumberTestContext.getPageObjectManager();
   }

   public CucumberTestContext getCucumberTestContext() {
      return cucumberTestContext;
   }
}
