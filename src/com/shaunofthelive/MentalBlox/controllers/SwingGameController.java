package com.shaunofthelive.MentalBlox.controllers;

import com.shaunofthelive.MentalBlox.models.Game;
import com.shaunofthelive.MentalBlox.views.IGameView;
import com.shaunofthelive.MentalBlox.views.SwingGameView;

public class SwingGameController implements IGameController {
    private Game game;
    private IGameView gameView;

    public SwingGameController(Game game) {
        this.game = game;
        // this could use factory pattern
        // e.g. createGameView("swing")
        this.gameView = new SwingGameView(this, game);
    }

    public void start() {
        game.start();
    }
}

