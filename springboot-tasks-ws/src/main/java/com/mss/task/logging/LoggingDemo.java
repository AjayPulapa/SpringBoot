package com.mss.task.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logging")
public class LoggingDemo {
   Logger logger=LoggerFactory.getLogger(LoggingDemo.class);
   
   @GetMapping("/message")
   public String GetMessage()
   {
	   logger.info("Info Message");
	   logger.warn("Warn Message");
	   logger.error("Error Message");
	   logger.trace("Trace Message");
	   logger.debug("Debug Message");
	return "Check the Console to see the Loggings";
   }
}
