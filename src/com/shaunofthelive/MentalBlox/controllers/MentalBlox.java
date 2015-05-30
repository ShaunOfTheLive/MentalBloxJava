/**
 * 
 */
package com.shaunofthelive.MentalBlox.controllers;

import com.shaunofthelive.MentalBlox.models.Game;
import com.shaunofthelive.MentalBlox.views.GameWindow;

/**
 * @author Shaun Hill
 * 
 */
public class MentalBlox {

    /**
     * Main class. Handles logic(?) and launches GameWindow.
     * TODO: move game logic into Game?
     * 
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();

        GameWindow.launch();
        game.start();

        System.out.println("Player 1 rolls " + game.getPlayer(1).getLastRoll());
        System.out.println("Player 2 rolls " + game.getPlayer(2).getLastRoll());
        System.out.println("Player " + game.getCurrentPlayer().getPlayerNum()
                                     + " starts.");
    }
}
