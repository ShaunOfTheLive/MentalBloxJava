/**
 * 
 */
package com.shaunofthelive.MentalBlox;

import com.shaunofthelive.MentalBlox.controllers.PlayerController;
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
        PlayerController playerController = new PlayerController(game);

        //debug
        game.getBoard().getBox(3).getHole(3).capture(1);
        game.getBoard().getBox(4).getHole(5).capture(2);


        System.out.println("Player 1 rolls " + game.getPlayer(1).getLastRoll());
        System.out.println("Player 2 rolls " + game.getPlayer(2).getLastRoll());
        System.out.println("Player " + game.getCurrentPlayer().getPlayerNum()
                                     + " starts.");
    }
}
