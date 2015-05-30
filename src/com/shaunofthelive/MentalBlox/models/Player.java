package com.shaunofthelive.MentalBlox.models;

public class Player {

    private int playerNum;
    private int lastRoll;
    private Die[] dice;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        this.lastRoll = 0;

        dice = new Die[2];
        dice[0] = new Die(6);
        dice[1] = new Die(6);
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int rollBothDice() {
        lastRoll = dice[0].roll() + dice[1].roll();
        return lastRoll;
    }

    public int getLastRoll() {
        return lastRoll;
    }

}
