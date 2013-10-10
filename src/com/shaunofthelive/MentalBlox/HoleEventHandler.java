package com.shaunofthelive.MentalBlox;

public class HoleEventHandler {
	public static void holeUpdated(Hole hole) {
		hole.getParentBox().updateHolesCaptured();
		checkIfBoxCaptured(hole);
	}
	private static void checkIfBoxCaptured(Hole hole) {
		Box box = hole.getParentBox();
		int owner = hole.getOwner();
		
		// check if five holes captured
		if (box.getHolesCaptured(owner) == 5) {
			box.capture(owner);
		}
		
		// check if three in a row
		//TODO: improve with matrix algorithms
		int[][] holeOwnerArray = box.getHoleOwnerArray();
		
		// check row
		int row = box.getHoleRow(hole);
		if (owner == holeOwnerArray[row][0] &&
			owner == holeOwnerArray[row][1] &&
			owner == holeOnwerArray[row][2]) {
			box.capture(owner);
		}
		
		// check column
		int col = box.getHoleCol(hole);
		if (owner == holeOwnerArray[0][col] &&
			owner == holeOwnerArray[1][col]] &&
			owner == holeOnwerArray[2][col]) {
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
