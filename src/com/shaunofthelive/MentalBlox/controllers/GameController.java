package com.shaunofthelive.MentalBlox.controllers;

import com.shaunofthelive.MentalBlox.models.Game;
import com.shaunofthelive.MentalBlox.views.BoardPanel;
import com.shaunofthelive.MentalBlox.views.GameWindow;

public class GameController implements IController {
    private Game game;
    private BoardPanel boardPanel;

    public GameController(Game game) {
        this.game = game;
        GameWindow.launch(this, game);
        game.start();
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }
}

