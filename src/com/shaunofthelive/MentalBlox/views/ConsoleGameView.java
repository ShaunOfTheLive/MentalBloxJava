package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.controllers.IGameController;
import com.shaunofthelive.MentalBlox.models.Game;

public class ConsoleGameView implements IGameView {
    private ConsoleBoardView boardView;
    final int ROWS = 24;
    final int COLS = 80;
    char[][] g = new char [ROWS][COLS];

    public ConsoleGameView(IGameController controller, Game gameModel) {
        System.out.println("Console game view created");
        this.boardView = new ConsoleBoardView();
        draw(g);
    }

    public void draw(char[][] g) {
        boardView.draw(g);
        for (int i = 0; i < g.length; ++i) {
            System.out.println(new String(g[i]));
        }
    }
}
