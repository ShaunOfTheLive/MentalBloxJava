package com.shaunofthelive.MentalBlox.controllers;

import com.shaunofthelive.MentalBlox.models.Game;
import com.shaunofthelive.MentalBlox.views.ConsoleGameView;
import com.shaunofthelive.MentalBlox.views.IGameView;

public class ConsoleGameController implements IGameController {
    private Game game;
    private IGameView gameView;

    public ConsoleGameController(Game game) {
        this.game = game;
        this.gameView = new ConsoleGameView(this, game);
    }

    public void start() {
        game.start();
    }
}

