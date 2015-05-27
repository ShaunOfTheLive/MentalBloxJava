/**
 * 
 */
package com.shaunofthelive.MentalBlox.models;


/**
 * @author Shaun Hill
 *
 */
public class Hole {
	private int number;		// name this better?
	private int owner;	// name this better and change the type
	private Box parentBox;
	
	Hole(int number, Box parentBox) {
		this.number = number;
		this.owner = 0;
		this.parentBox = parentBox;
	}
	
	public boolean isCaptured() {
		return owner != 0;
	}
	
	public void capture(int player) {
		owner = player;
		update();
	}
	
	public void setOwner(int player) {
		owner = player;
	}
	
	public int getOwner() {
		return owner;
	}

	public int getNumber() {
		return number;
	}
	
	public Box getParentBox() {
		return parentBox;
	}
/*
	private void setNumber(int number) {
		this.number = number;
	}
*/
	
	public void update() {
		getParentBox().updateHolesCaptured();
		checkIfBoxCaptured();
	}
	
	private void checkIfBoxCaptured() {
		Box box = getParentBox();
		int owner = getOwner();
		
		// check if five holes captured
		if (box.getHolesCaptured(owner) == 5) {
			box.capture(owner);
		}
		
		// check if three in a row
		//TODO: improve with matrix algorithms
		int[][] holeOwnerArray = box.getHoleOwnerArray();
		
		// check row
		int row = box.getHoleRow(this);
		if (owner == holeOwnerArray[row][0] &&
			owner == holeOwnerArray[row][1] &&
			owner == holeOwnerArray[row][2]) {
			box.capture(owner);
		}
		
		// check column
		int col = box.getHoleCol(this);
		if (owner == holeOwnerArray[0][col] &&
			owner == holeOwnerArray[1][col] &&
			owner == holeOwnerArray[2][col]) {
				box.capture(owner);
			}
		
		// check diagonal
		if (col == row || col + row == 2) { // if on diagonal
			if (owner == holeOwnerArray[0][0] &&
				owner == holeOwnerArray[1][1] &&
				owner == holeOwnerArray[2][2]) {
				box.capture(owner);
			}
			if (owner == holeOwnerArray[0][2] &&
					owner == holeOwnerArray[1][1] &&
					owner == holeOwnerArray[2][0]) {
					box.capture(owner);
			}
		}
	}
}
