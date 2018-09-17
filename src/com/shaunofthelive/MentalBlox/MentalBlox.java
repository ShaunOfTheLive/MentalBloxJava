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
     * Main class. Handles logic(?) and launches GameWindow.
     * TODO: move game logic into Game?
     * 
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        GameController gameController = new GameController(game);

        //debug
        game.getBoard().getBox(3).getHole(3).capture(1);
        game.getBoard().getBox(4).getHole(5).capture(2);


    }
}
