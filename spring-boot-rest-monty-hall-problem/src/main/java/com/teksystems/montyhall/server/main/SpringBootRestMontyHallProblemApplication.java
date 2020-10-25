package com.teksystems.montyhall.server.main;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class SpringBootRestMontyHallProblemApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestMontyHallProblemApplication.class, args);
	}
	
	
	  @Bean 
	  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		  return args -> {
	  
			  
			    //Gamer prompting messages
				System.out.println("*****    Game will follow the following steps to complete game ******");
				System.out.println("*****    Step 1: Gamer select the door");
				System.out.println("*****    Step 2: Game host open up one of the doors which is - non prize and not selcted by gamer door, to increase gamer probability     ******");
				System.out.println("*****    Step 2: Game host prompt gammer to switch his previous selection if he can  ******");
				System.out.println("*****    Step 3: Game host display final result.   ******");
				
				
						
				
	  
		  }; 
	  }
	 
	
	

}
