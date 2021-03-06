package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.controllers.IGameController;
import com.shaunofthelive.MentalBlox.models.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SwingGameWindow {

    private JFrame frame;
    private Game gameModel;

    /**
     * Creates a frame, and sets its size, location, close operation, and
     * resizable status. Then creates a new SwingBoardView and adds the frame to it.
     */
    public SwingGameWindow(SwingGameView gameView, IGameController controller, Game gameModel) {
        frame = new JFrame();
        frame.setTitle("Mental Blox");

        GraphicsEnvironment env = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        System.out.println("Screen Bounds: " + bounds);
        frame.setSize(bounds.height - 10, bounds.height - 10);

        frame.setLocationRelativeTo(null);

        Point p = frame.getLocation();
        frame.setLocation(new Point(p.x, p.y));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // frame.pack();

        /*
         * we've created a SwingBoardView here as a local variable but we're adding
         * it to frame, so it belongs to frame.
         */
        SwingBoardView swingBoardView = new SwingBoardView(controller, gameModel);
        frame.add(swingBoardView);
        gameView.setBoardView(swingBoardView);
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Creates a SwingGameWindow class (inside a Runnable) and makes it visible.
     */
    public static void launch(SwingGameView gameView, IGameController controller, Game gameModel) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingGameWindow gw = new SwingGameWindow(gameView, controller, gameModel);
                gw.getFrame().setVisible(true);
                gw.getFrame().addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent we) {
                        gameModel.start();
                    }

                    @Override
                    public void windowActivated(WindowEvent we) {
                    }
                });
            }
        });
    }

}
