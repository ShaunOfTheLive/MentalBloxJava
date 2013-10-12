package com.shaunofthelive.MentalBlox;

public class Game {
	public Board getBoard() {
		return board;
	}

	private void setBoard(Board board) {
		this.board = board;
	}

	public Die[] getDice() {
		return dice;
	}

	private void setDice(Die[] dice) {
		this.dice = dice;
	}

	private Board board;
	private Die[] dice;
	
	public Game() {
		board = new Board();
		dice = new Die[2];
		dice[0] = new Die(6);
		dice[1] = new Die(6);
	}
}
