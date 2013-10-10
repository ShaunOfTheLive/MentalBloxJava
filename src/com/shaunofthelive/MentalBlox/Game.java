package com.shaunofthelive.MentalBlox;

public class Game {
	private Board board;
	private Die[] dice;
	
	public Game() {
		board = new Board();
		dice = new Die[2];
		dice[0] = new Die(6);
		dice[1] = new Die(6);
	}
}
