package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.controllers.IGameController;
import com.shaunofthelive.MentalBlox.models.Game;

public class ConsoleGameView implements IGameView {
    private ConsoleBoardView boardView;

    public ConsoleGameView(IGameController controller, Game gameModel) {
        System.out.println("Console game view created");
    }

    public void setBoardView(ConsoleBoardView boardView) {
        this.boardView = boardView;
    }
}
