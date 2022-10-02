package com.infosys.demo.springboot1;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Springboot1Application implements CommandLineRunner{
  private static final Log LOGGER=LogFactory.getLog(Springboot1Application.class);
  @Autowired
  private Environment env;	
  public static void main(String[] args) {
		SpringApplication.run(Springboot1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Hello");
		LOGGER.info(env.getProperty("message"));
		LOGGER.error("I am error");
		//LOGGER.debug("I am the debug");
		LOGGER.warn("I am the warn");
		LOGGER.fatal("I am the fatal");
		
	}

}
