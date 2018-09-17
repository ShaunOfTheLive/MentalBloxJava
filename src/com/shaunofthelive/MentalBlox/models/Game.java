package com.shaunofthelive.MentalBlox.models;

import com.shaunofthelive.MentalBlox.IObserver;

import java.util.ArrayList;

public class Game {
    private Board board;
    private Die[] dice;
    private Player currentPlayer;
    private Player[] players;

    private ArrayList<IObserver> observers;
    private IObserver.State state;

    public Game() {
        board = new Board();
        dice = new Die[2];
        dice[0] = new Die(6);
        dice[1] = new Die(6);
        players = new Player[2];
        players[0] = new Player(1);
        players[1] = new Player(2);
        currentPlayer = null;

        observers = new ArrayList<IObserver>();
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
        state = IObserver.State.ROLL_FOR_FIRST;
        notifyObservers();

        getBoard().getBox(3).getHole(3).capture(1);
        getBoard().getBox(4).getHole(5).capture(2);
        state = IObserver.State.PEG_PLACED;
        notifyObservers();
    }

    public void registerObserver(IObserver o) {
        observers.add(o);
    }

    public void removeObserver(IObserver o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(state);
        }
    }
}
