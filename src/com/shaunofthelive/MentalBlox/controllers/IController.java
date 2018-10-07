package com.shaunofthelive.MentalBlox.controllers;

import com.shaunofthelive.MentalBlox.views.IBoardView;
import com.shaunofthelive.MentalBlox.views.SwingBoardView;

public interface IController {
    public void setBoardView(IBoardView boardView);
    public void start();
}

