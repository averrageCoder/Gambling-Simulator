package com.bridgelabz.gamblingSimulator;

public class GamblingSimulator {
	
	public static final int STARTING_STAKE = 100;
	public static final int EVERY_GAME_BET = 1;
	public static final int DAYS_PLAYED = 30;
	public static final int MONTHS_PLAYED = 12;
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
	
	//uc5
	public static void playForAMonth() {
		int gamesWon=0, gamesLost=0, totalWinnings=0, totalLost=0;
		for (int i = 1; i <= DAYS_PLAYED; i++) {
			currentStake = STARTING_STAKE;
			checkResignGame();
			if(currentStake >= STARTING_STAKE*1.5) {
				gamesWon++;
				totalWinnings+=currentStake-STARTING_STAKE;
			}
			else {
				gamesLost++;
				totalLost+=STARTING_STAKE-currentStake;
			}
		}
		System.out.println("Games Won: "+gamesWon+". Won $"+totalWinnings);
		System.out.println("Games Lost: "+gamesLost+". Lost $"+totalLost);
	}
	
	//uc6
	//uc6
	public static void luckiestAndUnluckiestDay() {
		int totalEarning, maxWinnings=0, minWinnings=9999, luckiestMonth=0, unluckiestMonth=0;
		for (int i=1; i<= MONTHS_PLAYED; i++) {
			totalEarning=0;
			for (int j = 1; j <= DAYS_PLAYED; j++) {
				currentStake = STARTING_STAKE;
				checkResignGame();
				totalEarning+=currentStake;
			}
			System.out.println("Total Winnings for Month "+i+" is "+totalEarning);
			if(maxWinnings<totalEarning) {
				luckiestMonth = i;
				maxWinnings=totalEarning;
			}
			if(minWinnings>totalEarning) {
				unluckiestMonth = i;
				minWinnings=totalEarning;
			}
				
		}
		System.out.println("Luckiest Month : Month "+luckiestMonth);
		System.out.println("Unluckiest Month : Month "+unluckiestMonth);
	}
	
	//uc7
	public static void continueNextMonth() {
		
		int gamesWon=0, gamesLost=0, monthsPlayed=0;
		while(true) {
			monthsPlayed++;
			for (int i = 1; i <= DAYS_PLAYED; i++) {
				currentStake = STARTING_STAKE;
				checkResignGame();
				if(currentStake >= STARTING_STAKE*1.5) {
					gamesWon++;
				}
				else {
					gamesLost++;
				}
			}
			if(gamesWon<gamesLost)
				break;
		}
		
		System.out.println("Months played: "+monthsPlayed);
		
	}
	
	public static void main(String[] args) {

		continueNextMonth();
		
	}

}
