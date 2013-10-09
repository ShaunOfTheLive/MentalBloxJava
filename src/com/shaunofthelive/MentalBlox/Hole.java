/**
 * 
 */
package com.shaunofthelive.MentalBlox;

/**
 * @author Shaun Hill
 *
 */
public class Hole {
	private int number;		// name this better?
	private int owner;	// name this better and change the type
	
	public Hole(int number) {
		this.number = number;
		this.owner = 0;
	}
	
	public boolean isCaptured() {
		return owner != 0;
	}
	
	public void capture(int player) {
		owner = player;
	}
	
	public int getOwner() {
		return owner;
	}

	public int getNumber() {
		return number;
	}
/*
	private void setNumber(int number) {
		this.number = number;
	}
*/
}
