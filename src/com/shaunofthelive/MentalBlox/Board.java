package com.shaunofthelive.MentalBlox;

public class Board {
	private Box[] boxes;
	
	public Board() {
		boxes = new Box[9];
		
		for (int i = 0; i < 9; i++) {
			boxes[i] = new Box(i+3);
		}
	}
	
	public Box getBox(int number) {
		return boxes[number-3];
	}
}