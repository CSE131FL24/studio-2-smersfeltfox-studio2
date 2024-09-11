package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How much money do you start with?");
		int startAmount = in.nextInt();
		System.out.println("What is your win chance?");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit?");
		int winLimit = in.nextInt();
		System.out.println("How many simulations would you like to do?");
		double totalSimulations = in.nextDouble();
		
		int totalLosses = 0;
		
		
		for (int simCount = 1; simCount <=totalSimulations; simCount++) {
			int playCount = 0;
			int currentTotal = startAmount;
			while (currentTotal>0&&currentTotal<winLimit) {
				playCount ++;
				double odds = Math.random();
				if (odds < winChance) {
					currentTotal++;
				}
				else {
					currentTotal --;
				}
			if (currentTotal >= winLimit) {
				System.out.println("Simulation " + simCount + " " + playCount + " " + " SUCCESS");
			}
			else if (currentTotal <= 0){
				System.out.println("Simulation " + simCount + " " + playCount + " " + " RUIN");
				totalLosses++;
			}
			
		}
		}
		double expectedRuin;
		double ruinRate = totalLosses/totalSimulations;
		if (winChance == 0.5) {
			expectedRuin = (1-(startAmount/winLimit));
		}
		else {
			double a = (1-winChance)/winChance;
			expectedRuin = ((Math.pow(a,startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit)));
		}
		System.out.println("Losses: "+totalLosses + " Simulations: "+totalSimulations);
		System.out.println("Ruin rate from simulation: "+ ruinRate + " Expected Ruin Rate "+ expectedRuin);
			
		
			
		}
		
	}

