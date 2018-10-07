package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.controllers.IGameController;
import com.shaunofthelive.MentalBlox.models.Game;

public class SwingGameView implements IGameView {
    private SwingBoardView boardView;

    public SwingGameView(IGameController controller, Game gameModel) {
        SwingGameWindow.launch(this, controller, gameModel);
    }

    public SwingBoardView getBoardView() {
        return boardView;
    }

    public void setBoardView(SwingBoardView boardView) {
        this.boardView = boardView;
    }
}
