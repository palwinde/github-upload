package config;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class LoggerClass {

		public static Logger getLogger(String name) {
			// TODO Auto-generated method stub
		    Logger logger = Logger.getLogger(name);

			System.out.println("hi in loggerr...."+System.getProperty("user.dir"));
	        String log4jConfigFile = System.getProperty("user.dir")
	                + File.separator + "log4j.properties";
	        PropertyConfigurator.configure(log4jConfigFile);
	        logger.debug("this is a debug log message");
	        logger.info("this is a information log message");
	        logger.warn("this is a warning log message");
			return logger;
		}
	    
}