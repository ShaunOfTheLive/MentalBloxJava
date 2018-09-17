package com.shaunofthelive.MentalBlox.views;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.shaunofthelive.MentalBlox.controllers.IController;
import com.shaunofthelive.MentalBlox.models.Game;

public class GameWindow {

    private JFrame frame;
    private Game gameModel;

    /**
     * Creates a frame, and sets its size, location, close operation, and
     * resizable status. Then creates a new BoardPanel and adds the frame to it.
     */
    public GameWindow(IController controller, Game gameModel) {
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
         * we've created a BoardPanel here as a local variable but we're adding
         * it to frame, so it belongs to frame.
         */
        BoardPanel boardPanel = new BoardPanel(controller, gameModel);
        frame.add(boardPanel);
        controller.setBoardPanel(boardPanel);
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Creates a GameWindow class (inside a Runnable) and makes it visible.
     */
    public static void launch(IController controller, Game gameModel) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameWindow gw = new GameWindow(controller, gameModel);
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
