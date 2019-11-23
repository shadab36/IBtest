package APIClient.endpoints;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EndPointBase {
   
   protected static Logger logger;

   public EndPointBase() {

      logger = LogManager.getLogger(this);
      logger.info("Initialised");

   }
}
