package com.bridgelabz.gamblingSimulator;

import java.util.Iterator;

public class GamblingSimulator {
	
	public static final int STARTING_STAKE = 100;
	public static final int EVERY_GAME_BET = 1;
	public static final int DAYS_PLAYED = 20;
	public static int currentStake;
	
	//uc2 - As a Gambler make $1 bet so either win or loose $1
	public static void makeBet() {
		
		if(Math.random() > 0.5) {
			currentStake+=EVERY_GAME_BET;
			//System.out.println("Won $"+EVERY_GAME_BET);
		}
		else {
			currentStake-=EVERY_GAME_BET;
			//System.out.println("Lost $"+EVERY_GAME_BET);
		}
		
	}
	
	//uc3 As a Calculative Gambler if won or lost 50% of the stake, would resign for the day
	public static void checkResignGame() {
		Boolean shouldResign=false;
		while(!shouldResign) {
			makeBet();
			if(currentStake >= STARTING_STAKE*1.5 || currentStake <= STARTING_STAKE*0.5) {
				shouldResign= true;
			}
			else
				shouldResign= false;
		}
		
	}
	
	//uc4 - After 20 days of playing every day would like to know the total amount won or lost.
	public static void playFor20Days() {
		int totalWinnings = 0;
		for (int i = 1; i <= DAYS_PLAYED; i++) {
			currentStake = STARTING_STAKE;
			checkResignGame();
			totalWinnings+=currentStake;
			System.out.println("Resigning Day "+i+" with $"+currentStake);
		}
		System.out.println("Total winnings after "+DAYS_PLAYED+" days: "+totalWinnings);
	}
	public static void main(String[] args) {
		
		playFor20Days();
		
	}

}
