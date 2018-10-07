package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.controllers.IController;
import com.shaunofthelive.MentalBlox.models.Game;

public class SwingGameView implements IGameView {
    public SwingGameView(IController controller, Game gameModel) {
        SwingGameWindow.launch(controller, gameModel);
    }
}
