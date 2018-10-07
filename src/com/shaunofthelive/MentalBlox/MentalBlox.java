/**
 * 
 */
package com.shaunofthelive.MentalBlox;

import com.shaunofthelive.MentalBlox.controllers.GameController;
import com.shaunofthelive.MentalBlox.models.Game;

/**
 * @author Shaun Hill
 * 
 */
public class MentalBlox {

    /**
     * Main class. Handles logic(?) and launches SwingGameWindow.
     * TODO: move game logic into Game?
     * 
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        GameController gameController = new GameController(game);
    }
}
