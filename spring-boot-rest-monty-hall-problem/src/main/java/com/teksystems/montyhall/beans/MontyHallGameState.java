package com.teksystems.montyhall.beans;

import java.util.*;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.JSONObject;
import com.teksystems.montyhall.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class MontyHallGameState {
	
	int iterations;
	int numOfDoors;	  
	String objectNameBehindTheDoorToWin;
	String objectNameBehindTheDoors;
	String winPercentage;
	int theDoorNumberToWin;
	int gameRunnerToOpenDoorNumber;		
	Map<Integer, String> gameStateMap = new HashMap<>();
	
	Random rand = new Random();
	Scanner scan = new Scanner (System.in);
	JSONObject jsonObject = new JSONObject();
	
	public MontyHallGameState() {
				
		jsonObject = MontyHallUtils.JSONReader();
		this.iterations = Integer.parseInt((String)jsonObject.get("numberOfiterations")); 		
		this.numOfDoors = Integer.parseInt((String)jsonObject.get("numberOfDoors"));         
		this.objectNameBehindTheDoors = (String)jsonObject.get("nonPrizedObject");
        this.objectNameBehindTheDoorToWin = (String)jsonObject.get("prizedObject");
        
        intializeGameDoors();   
		
	}
	public int getIterations() {
		return iterations;
	}
	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	public int getNumOfDoors() {
		return numOfDoors;
	}
	public void setNumOfDoors(int numOfDoors) {
		this.numOfDoors = numOfDoors;
	}	
	
	public String getObjectNameBehindTheDoors() {
		return objectNameBehindTheDoors;
	}
	public void setObjectNameBehindTheDoor(String objectNameBehindTheDoor) {
		this.objectNameBehindTheDoors = objectNameBehindTheDoor;
	}
	
	public String getObjectNameBehindTheDoorToWin() {
		return objectNameBehindTheDoorToWin;
	}
	public void setObjectNameBehindTheDoorToWin(String objectNameBehindTheDoorToWin) {
		this.objectNameBehindTheDoorToWin = objectNameBehindTheDoorToWin;
	}
	public void setObjectNameBehindTheDoors(String objectNameBehindTheDoors) {
		this.objectNameBehindTheDoors = objectNameBehindTheDoors;
	}
	
	public String getWinPercentage() {
		return winPercentage;
	}
	public void setWinPercentage(String winPercentage) {
		this.winPercentage = winPercentage;
	}
	public int getTheDoorNumberToWin() {
		return theDoorNumberToWin;
	}
	
	public int getGameRunnerToOpenDoorNumber() {
		return gameRunnerToOpenDoorNumber;
	}
	public void setGameRunnerToOpenDoorNumber(int gameRunnerToOpenDoorNumber) {
		this.gameRunnerToOpenDoorNumber = gameRunnerToOpenDoorNumber;
	}
	public void setTheDoorNumberToWin(int theDoorNumberToWin) {
		this.theDoorNumberToWin = theDoorNumberToWin;
	}
	public Map<Integer, String> getGameStateMap() {
		return gameStateMap;
	}
	public void setGameStateMap(Map<Integer, String> gameStateMap) {
		this.gameStateMap = gameStateMap;
	}
	public void intializeGameDoors() {
		
		for (int i = 0; i < numOfDoors; i++) {		            
			
			gameStateMap.put(i, objectNameBehindTheDoors);
		    
		}  		
		
		theDoorNumberToWin = rand.nextInt(numOfDoors); 
		gameStateMap.put(theDoorNumberToWin, objectNameBehindTheDoorToWin); 		
		
		gameStateMap.entrySet().forEach(entry -> System.out.println(
				  entry.getKey() + " " + entry.getValue()));
		
		
	}	
	
	public String getValueBehindTheGameDoor(int doorNumber) {		
		return gameStateMap.get(doorNumber);
	}
	
	public int randomGamerNotSelectedNoPrizeDoor(int gamerSelectedDoor) {
		
		int otherNonPrizeDoor;		
		
		while(true) {
			otherNonPrizeDoor = rand.nextInt(numOfDoors);			
			if(otherNonPrizeDoor!= gamerSelectedDoor && getValueBehindTheGameDoor(otherNonPrizeDoor) != objectNameBehindTheDoorToWin ) {				
				return otherNonPrizeDoor;
			}
		}
		
	}
	
	public String gameRunnerStep1ActionResponse(int gamerSelectedDoor) {
		gameRunnerToOpenDoorNumber = randomGamerNotSelectedNoPrizeDoor(gamerSelectedDoor);
		return ("*****    Door number: "+ Integer.toString(gameRunnerToOpenDoorNumber) + "   and Value behind door: "+objectNameBehindTheDoors);
		
	}
	
	
	
	/*
	 * This function is useful to prompt gamer to get game configuration values
	 */
	
	/*
	public void promptGamerForValues() {
		
		System.out.println("Please enter value for number of iterations:\n   ");
		this.iterations = Integer.parseInt(scan.next());             
		System.out.println("Please enter value for number of game doors:\n   ");
		this.numOfDoors = Integer.parseInt(scan.next());          
        System.out.println("Please enter object name behind the non winning doors:\n   ");
        objectNameBehindTheDoors = scan.next();        
		System.out.println("Please enter object name behind the winning door:\n   ");
		objectNameBehindTheDoorToWin  = scan.next();
        
		
	} */
	
	
	
}
	
