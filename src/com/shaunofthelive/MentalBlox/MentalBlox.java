/**
 * 
 */
package com.shaunofthelive.MentalBlox;

import com.shaunofthelive.MentalBlox.controllers.IGameController;
import com.shaunofthelive.MentalBlox.controllers.SwingGameController;
import com.shaunofthelive.MentalBlox.models.Game;

/**
 * @author Shaun Hill
 * 
 */
public class MentalBlox {

    /**
     * Main class. Creates the main model and main controller (which creates
     * the main view).
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();
        IGameController gameController = new SwingGameController(game);
        //IGameController gameController = new ConsoleGameController(game);
    }
}
