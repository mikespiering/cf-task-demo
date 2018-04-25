package com.example.demo;

import lombok.extern.java.Log;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import java.util.Map;
import java.time.Instant;
import org.springframework.boot.DefaultApplicationArguments;

@Log
@EnableTask
@SpringBootApplication
public class DemoApplication {
	
	@Bean
	    ApplicationRunner run(DefaultApplicationArguments args2) {


	    System.out.println("\nRead All Variables:-\n");
 
	    Map <String, String> map = System.getenv();
	    for (Map.Entry <String, String> entry: map.entrySet()) {
		System.out.println("Variable Name:- " + entry.getKey() + " Value:- " + entry.getValue());
	    }


	    for (String arg3 : args2.getSourceArgs()) {
		log.info(arg3);
	    
		if(arg3.compareTo("endpoint1")==0)
		   {
		       log.info("Should call endpoint 1");
		   }
		if(arg3.compareTo("endpoint2")==0)
		      {
			  log.info("should call endpoint 2");
		      }
	    
	    }
		return args -> log.info("running at " + Instant.now().toString());
	}

	public static void main(String[] args) {
	    log.info("test");
		SpringApplication.run(DemoApplication.class, args);
	}
}
