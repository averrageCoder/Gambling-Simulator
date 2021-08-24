package com.bridgelabz.gamblingSimulator;

public class GamblingSimulator {
	
	public static final int STARTING_STAKE = 100;
	public static final int EVERY_GAME_BET = 1;
	
	//uc2 - As a Gambler make $1 bet so either win or loose $1
	public static void makeBet() {
		
		if(Math.random() > 0.5) {
			System.out.println("Won $"+EVERY_GAME_BET);
		}
		else {
			System.out.println("Lost $"+EVERY_GAME_BET);
		}
		
	}
	
	public static void main(String[] args) {
		
		makeBet();
		
	}

}
