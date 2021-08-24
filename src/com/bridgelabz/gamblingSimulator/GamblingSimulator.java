package com.bridgelabz.gamblingSimulator;

public class GamblingSimulator {
	
	public static final int STARTING_STAKE = 100;
	public static final int EVERY_GAME_BET = 1;
	public static int currentStake;
	
	//uc2 - As a Gambler make $1 bet so either win or loose $1
	public static void makeBet() {
		
		if(Math.random() > 0.5) {
			currentStake+=EVERY_GAME_BET;
			System.out.println("Won $"+EVERY_GAME_BET);
		}
		else {
			currentStake-=EVERY_GAME_BET;
			System.out.println("Lost $"+EVERY_GAME_BET);
		}
		
	}
	
	//uc3 As a Calculative Gambler if won or lost 50% of the stake, would resign for the day
	public static Boolean checkResignGame() {
		
		if(currentStake >= STARTING_STAKE*1.5 || currentStake <= STARTING_STAKE*0.5) {
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		currentStake = STARTING_STAKE;
		Boolean shouldResign=false;
		while(!shouldResign) {
			makeBet();
			shouldResign=checkResignGame();
		}
		System.out.println("Resigning game with $"+currentStake);
	}

}
