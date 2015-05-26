package com.shaunofthelive.MentalBlox.models;

import java.util.Random;

public class Die {
	private int sides;
	private int lastRoll;
	
	public Die(int sides) {
		this.sides = sides;
		this.lastRoll = 0;
	}
	
	public int roll() {
		lastRoll = randInt(1, sides);
		return lastRoll;
	}
	
	//TODO: exception if lastRoll is 0
	public int getLastRoll() {
		return lastRoll;
	}
	
	public int getSides() {
		return sides;
	}
	
	public static int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
