package com.shaunofthelive.MentalBlox.controllers;

import com.shaunofthelive.MentalBlox.models.Game;
import com.shaunofthelive.MentalBlox.views.IBoardView;
import com.shaunofthelive.MentalBlox.views.IGameView;
import com.shaunofthelive.MentalBlox.views.SwingGameView;

public class GameController implements IController {
    private Game game;
    private IGameView gameView;
    private IBoardView boardView;

    public GameController(Game game) {
        this.game = game;
        // this could use factory pattern
        // e.g. createGameView("swing")
        this.gameView = new SwingGameView(this, game);
    }

    public void setBoardView(IBoardView boardView) {
        this.boardView = boardView;
    }

    public void start() {
        game.start();
    }
}

