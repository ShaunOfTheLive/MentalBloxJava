/**
 * 
 */
package com.shaunofthelive.MentalBlox;

/**
 * @author Shaun Hill
 *
 */
public class MentalBlox {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		Board board = game.getBoard();
		Die[] dice = game.getDice();
		int currentPlayer = 0;
		
		// players roll dice to see who goes first
		int player1roll = game.rollBothDice();
		int player2roll = game.rollBothDice();
		
		while (true) {
			if (player1roll > player2roll) {
				currentPlayer = 1;
				break;
			} else if (player2roll > player1roll) {
				currentPlayer = 2;
				break;
			}
		}
		
		System.out.println("Player 1 rolls " + player1roll);
		System.out.println("Player 2 rolls " + player2roll);
		System.out.println("Player " + currentPlayer + " starts.");
		
		GameWindow.launch();
	}
}
