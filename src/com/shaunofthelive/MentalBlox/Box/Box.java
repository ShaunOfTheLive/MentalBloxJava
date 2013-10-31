/**
 * 
 */
package com.shaunofthelive.MentalBlox.Box;


/**
 * @author Shaun Hill
 *
 */
public class Box {
	private int number;
	private int owner;
	private Hole[] holes;
	private int[] holesCaptured = new int[]{0,0,0};
	
	public Box(int number) {
		this.number = number;
		holes = new Hole[9];
		
		for (int i = 0; i < 9; i++) {
			holes[i] = new Hole(i+3, this);
		}
	}
	
	//TODO: custom exception for out of bounds
	public Hole getHole(int number) {
		return holes[number-3];
	}
	
	public int[][] getHoleOwnerArray() {
		int[][] holeOwnerArray = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				holeOwnerArray[i][j] = holes[i*3+j].getOwner();
			}
		}
		return holeOwnerArray;
	}
	
	private int getHoleIndex(Hole hole) throws IndexOutOfBoundsException {
		int i = 0;
		for (; i < 9; i++) {
			if (holes[i] == hole) break;
		}
		if (i == 9) {
			throw new IndexOutOfBoundsException("Hole " + hole + " not found in box " + this);
		}
		return i;
	}
	
	public int getHoleRow(Hole hole) {
		int holeRow = getHoleIndex(hole) / 3;
		if (holeRow > 2) {
			throw new IndexOutOfBoundsException("holeRow = " + holeRow + "; index = " + getHoleIndex(hole));
		}
		return holeRow;
	}
	
	public int getHoleCol(Hole hole) {
		return getHoleIndex(hole) % 3;
	}
	
	public boolean isCaptured() {
		return owner != 0;
	}
	
	public void capture(int player) {
		owner = player;
		for (int i = 0; i < 9; i++) {
			holes[i].setOwner(player); //capture causes stack overflow
		}
	}
	
	public int getOwner() {
		return owner;
	}

	public int getNumber() {
		return number;
	}
	
	public int getHolesCaptured(int player) {
		return holesCaptured[player];
	}
	
	public void updateHolesCaptured() {
		//TODO: improve sloppy code
		holesCaptured[1] = 0;
		holesCaptured[2] = 0;
		
		for (int i = 0; i < 9; i++) {
			if (holes[i].isCaptured()) {
				holesCaptured[holes[i].getOwner()]++;
			}
		}
	}
}