/**
 * Using Simulated Annealing to attempt solving the Travelling 
 * Salesman Problem .. TSP
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it as you wish ONLY for legal and ethical purposes
 * 
 * Please watch my explanation:
 * https://www.youtube.com/watch?v=G90qXUDfUzE&list=PLea0WJq13cnCHBp2WW3jtNEEH2pPkwEKw
 * 
 * Code adapted from LeeJackobson's code:
 * http://www.theprojectspot.com/
 *
 * Copyright (C) 2015 
 * @author Dr Noureddin Sadawi 
 *  
 * I ask you only, as a professional courtesy, to cite my name, web page 
 * and my YouTube Channel!
 *  
 */  
 
 /*
  A Utility class with several methods
 */
//package simulated.annealing;
package simulated.annealing;

import java.util.Random;

public class Utility {


	/**
	 * Computes and returns the Euclidean distance between two cities
	 * @param city1 the first city
	 * @param city2 the second city
	 * @return distance the dist between city1 and city2
	 */
	public static int distance(City city1, City city2){
		int xDistance = Math.abs(city1.getX() - city2.getX());
		int yDistance = Math.abs(city1.getY() - city2.getY());
		int distance = (int) Math.round (Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) ));

		return distance;
	}
		
	/**
	 * Calculates the acceptance probability
	 * @param currentDistance the total distance of the current tour
	 * @param newDistance the total distance of the new tour
	 * @param temperature the current temperature
	 * @return value the probability of whether to accept the new tour
	 */
	public static double acceptanceProbability(int currentDistance, int newDistance, double temperature) {
		// If the new solution is better, accept it
		if (newDistance < currentDistance) {
			return 1.0;
		}
		// If the new solution is worse, calculate an acceptance probability
		//return (1 /(1+ Math.exp((currentDistance - newDistance) / (temperature)) ));
		return  0.0;//Math.exp((currentDistance - newDistance) / temperature);
		//return Math.exp((currentDistance - newDistance) / (temperature *0.1));
	}

	/**
	 * this method returns a random number n such that
	 * 0.0 <= n <= 1.0
	 * @return random such that 0.0 <= random <= 1.0
	 */
	// Create a uniformly distributed random double between a and b inclusive
/*	public static double UR(double a, double b) {
		if (rand == null) {
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		return ((b - a) * rand.nextDouble() + a);
	}*/
// Create a uniformly distributed random double between a and b inclusive
	static double randomDouble() {
		double a = 0.0;
		double b = 1.0;
		Random rand = new Random();
		if (rand == null) {
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		return ((b - a) * rand.nextDouble() + a);
	}
/*	static double randomDouble()
	{
		Random r = new Random();
		double rr =  r.nextInt(1000) / 1000.0;
		rr = Math.pow(rr,0.3);
		double ret =  0 + (1 - 0) * rr;
		return ret;
	}*/
	
	/**
	 * returns a random int value within a given range
	 * min inclusive .. max not inclusive
	 * @param min the minimum value of the required range (int)
	 * @param max the maximum value of the required range (int)
	 * @return rand a random int value between min and max [min,max)
	 */ 
	public static int randomInt(int min , int max) {
		Random r = new Random();
		double d = min + r.nextDouble() * (max - min);
		return (int)d;
	}
}
