package com.shaunofthelive.MentalBlox.models;

public class Game {
    private Board board;
    private Die[] dice;
    private Player currentPlayer;
    private Player[] players;

    public Game() {
        board = new Board();
        dice = new Die[2];
        dice[0] = new Die(6);
        dice[1] = new Die(6);
        players = new Player[2];
        players[0] = new Player(1);
        players[1] = new Player(2);
        currentPlayer = null;

    }

    public Board getBoard() {
        return board;
    }

    public Die[] getDice() {
        return dice;
    }

    public int rollBothDice() {
        int result = 0;
        result = dice[0].roll() + dice[1].roll();
        return result;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getPlayer(int playerNum) {
        return players[playerNum - 1];
    }

    public void start() {
        // players roll dice to see who goes first
        int player1roll = players[0].rollBothDice();
        int player2roll = players[1].rollBothDice();

        while (true) {
            if (player1roll > player2roll) {
                currentPlayer = players[0];
                break;
            } else if (player2roll > player1roll) {
                currentPlayer = players[1];
                break;
            }
        }

    }
}
