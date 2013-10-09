/**
 * 
 */
package com.shaunofthelive.MentalBlox;

/**
 * @author Shaun Hill
 *
 */
public class Box {
	private int number;
	private int owner;
	private Hole[] holes;
	
	public Box(int number) {
		this.number = number;
		holes = new Hole[9];
		
		for (int i = 0; i < 9; i++) {
			holes[i] = new Hole(i+3);
		}
	}
	
	public Hole getHole(int number) {
		return holes[number-3];
	}
	
	public boolean isCaptured() {
		return owner != 0;
	}
	
	public void capture(int player) {
		owner = player;
		for (int i = 0; i < 9; i++) {
			holes[i].capture(player);
		}
	}
	
	public int getOwner() {
		return owner;
	}

	public int getNumber() {
		return number;
	}
}
