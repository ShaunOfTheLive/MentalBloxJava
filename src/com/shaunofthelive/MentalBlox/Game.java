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

	public int rollBothDice() {
		int result = 0;
		result = dice[0].roll() + dice[1].roll();
		return result;
	}
}
