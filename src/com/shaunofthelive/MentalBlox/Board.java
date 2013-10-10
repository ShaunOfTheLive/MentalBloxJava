package com.shaunofthelive.MentalBlox;

import com.shaunofthelive.MentalBlox.Box.Box;

public class Board {
	private Box[] boxes;
	
	public Board() {
		boxes = new Box[9];
		
		for (int i = 0; i < 9; i++) {
			boxes[i] = new Box(i+3);
		}
	}
	
	//TODO: custom exception for out of bounds
	public Box getBox(int number) {
		return boxes[number-3];
	}
}
