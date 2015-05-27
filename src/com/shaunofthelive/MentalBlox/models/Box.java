/**
 * 
 */
package com.shaunofthelive.MentalBlox.models;



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
	
	public void updateHolesCaptured(Hole holeUpdated) {
		//TODO: improve sloppy code
		holesCaptured[1] = 0;
		holesCaptured[2] = 0;
		
		for (int i = 0; i < 9; i++) {
			if (holes[i].isCaptured()) {
				holesCaptured[holes[i].getOwner()]++;
			}
		}
		
		checkIfBoxCaptured(holeUpdated);
	}
	
	private void checkIfBoxCaptured(Hole holeUpdated) {
		int holeOwner = holeUpdated.getOwner();
		
		// check if five holes captured
		if (getHolesCaptured(holeOwner) == 5) {
			capture(holeOwner);
		}
		
		// check if three in a row
		//TODO: improve with matrix algorithms
		int[][] holeOwnerArray = getHoleOwnerArray();
		
		// check row
		int row = getHoleRow(holeUpdated);
		if (holeOwner == holeOwnerArray[row][0] &&
			holeOwner == holeOwnerArray[row][1] &&
			holeOwner == holeOwnerArray[row][2]) {
			capture(holeOwner);
		}
		
		// check column
		int col = getHoleCol(holeUpdated);
		if (holeOwner == holeOwnerArray[0][col] &&
			holeOwner == holeOwnerArray[1][col] &&
			holeOwner == holeOwnerArray[2][col]) {
				capture(holeOwner);
			}
		
		// check diagonal
		if (col == row || col + row == 2) { // if on diagonal
			if (holeOwner == holeOwnerArray[0][0] &&
				holeOwner == holeOwnerArray[1][1] &&
				holeOwner == holeOwnerArray[2][2]) {
				capture(holeOwner);
			}
			if (holeOwner == holeOwnerArray[0][2] &&
					holeOwner == holeOwnerArray[1][1] &&
					holeOwner == holeOwnerArray[2][0]) {
					capture(holeOwner);
			}
		}
	}
}
