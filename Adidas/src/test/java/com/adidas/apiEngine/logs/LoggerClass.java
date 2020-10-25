package com.adidas.apiEngine.logs;


import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/** Represents Logger Class to generate logs.
 * @author Palwinder
 * @version 1.0
 * @since 1.0
*/
public class LoggerClass {
	/** Represents the getLogger method called by classes for generating logs
	*/
		public static Logger getLogger(String name) {
		    Logger logger = Logger.getLogger(name);

	        String log4jConfigFile = System.getProperty("user.dir")
	                + File.separator + "log4j.properties";
	        PropertyConfigurator.configure(log4jConfigFile);
	        logger.debug("this is a debug log message");
	        logger.info("this is a information log message");
	        logger.warn("this is a warning log message");
			return logger;
		}
	    
}
