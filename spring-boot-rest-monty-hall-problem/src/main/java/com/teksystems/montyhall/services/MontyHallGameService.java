/**
 * 
 */
package com.teksystems.montyhall.services;

/**
 * @author duggi
 * This is the service class - logic related to all needed actions to run the game.
 * @gamerDoorSelection: Game prompts gammer to choose door selection to win the game.
 * @validateGamerDoorSelection: This function validates gammer selection for winning prize.
 * @intermittentDialogByGameHost: During the process of game, Game host will promt gammer to change his selection.
 * Adding comments for testing purpose.
 * Adding second comment....
 * Adding third comment......
 */

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.teksystems.montyhall.beans.MontyHallGameState;



@Service
public class MontyHallGameService {
	
	int gamerSelectedDoor;
	int gamerChangeOfSelectedDoor;
	int initialSelectedDoor;
	String gamerSelectedDoorValue;
	String matchedSelection = "false";
	char gamerChangeOfSelectionYesOrNo;
	String [] resultOfTheGame = new String [7];
	
	Random rand = new Random();
	Scanner scan = new Scanner (System.in);
	@Autowired
	MontyHallGameState gameState =  new MontyHallGameState();
	int numOfDoorsOfTheGame; 
	String objectNameBehindTheDoorToWin;    
	
	

	/**
	 * 
	 */
	public MontyHallGameService() {			
		
		numOfDoorsOfTheGame = gameState.getNumOfDoors();
		objectNameBehindTheDoorToWin = gameState.getObjectNameBehindTheDoorToWin();
	}
	
	/*
	 * Game host prompts gammer to choose door selection to win the game out of system configured doors.
	 */
	public void gamerDoorSelection() {		
			
		this.gamerSelectedDoor = rand.nextInt(gameState.getNumOfDoors());
		this.initialSelectedDoor =  this.gamerSelectedDoor;     
     		
	}
	
	/*
	 * This function validates gammer selection for winning prize.
	 */
	 
	public void validateGamerDoorSelection() {
		
		if (gameState.getGameStateMap().containsKey(gamerSelectedDoor)) {
			
			 gamerSelectedDoorValue = gameState.getGameStateMap().get(gamerSelectedDoor);
			 
		}		
		if(gamerSelectedDoorValue.equalsIgnoreCase(objectNameBehindTheDoorToWin)) {		
			matchedSelection = "true";
		    System.out.println("Congratulations! Your selected door value is matching winning prize "+ objectNameBehindTheDoorToWin);
		} else 
			System.out.println("Sorry! Your selected door value is not matching winning prize "+ objectNameBehindTheDoorToWin);
		
	}	
	
	/*
	 * During the process of game, Game host will prompt gammer to change his selection to effect probability of winning prize.
	 */
	public void intermittentDialogByGameHost() {
		
		
				  
	    if(gamerChangeOfSelectionYesOrNo == 'y' || gamerChangeOfSelectionYesOrNo == 'Y' ) {    	
	    	
	    	this.gamerSelectedDoor = rand.nextInt(numOfDoorsOfTheGame);
	    	while(this.gamerSelectedDoor == gameState.getGameRunnerToOpenDoorNumber()) {
	    		this.gamerSelectedDoor = rand.nextInt(numOfDoorsOfTheGame);
	    	}	    	
	    	
	    	this.gamerChangeOfSelectedDoor = this.gamerSelectedDoor;
	    }	    
	    
	}	
	
	public String [] updateGameResult() {
    	
		resultOfTheGame[0]= "";
		resultOfTheGame[1]= gameState.getGameStateMap().get(0);
		resultOfTheGame[2]= gameState.getGameStateMap().get(1);
		resultOfTheGame[3]= gameState.getGameStateMap().get(2);
		resultOfTheGame[4]= String.valueOf(initialSelectedDoor);
		resultOfTheGame[5]= String.valueOf(gamerSelectedDoor);
		resultOfTheGame[6]= matchedSelection; 		
		return resultOfTheGame;
    	
    }
	
	
	

	public char getGamerChangeOfSelectionYesOrNo() {
		return gamerChangeOfSelectionYesOrNo;
	}

	public void setGamerChangeOfSelectionYesOrNo(char gamerChangeOfSelectionYesOrNo) {
		this.gamerChangeOfSelectionYesOrNo = gamerChangeOfSelectionYesOrNo;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub	

	}

}
