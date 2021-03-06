package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.IObserver;
import com.shaunofthelive.MentalBlox.controllers.IGameController;
import com.shaunofthelive.MentalBlox.models.Board;
import com.shaunofthelive.MentalBlox.models.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.Line2D;

public class SwingBoardView extends JPanel implements IObserver, IBoardView {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    public class ResizeListener implements ComponentListener {

        @Override
        public void componentHidden(ComponentEvent arg0) {
        }

        @Override
        public void componentMoved(ComponentEvent arg0) {
        }

        @Override
        public void componentResized(ComponentEvent arg0) {
            Component c = arg0.getComponent();

            System.out.println("componentResized event from "
                    + c.getClass().getName() + "; new size: "
                    + c.getSize().width + ", " + c.getSize().height);

            int height = getSize().height;

            ((SwingBoardView) c).resizePanel(height, height);

            // TODO: move this to SwingGameWindow constructor, using pack and
            // getInsets?
            // setResizable(false) has 10-pixel bug!
            // if we remove 10 pixels in here, window will keep resizing itself
            // down to nothing

            System.out.println("RESIZED TO " + c.getClass().getName()
                    + "; new size: " + c.getSize().width + ", "
                    + c.getSize().height);

        }

        @Override
        public void componentShown(ComponentEvent arg0) {
        }

    }

    private Line2D[] linesHorz;
    private Line2D[] linesVert;
    private SwingBoxView[][] swingBoxViews;
    private int panelWidth;
    private int panelHeight;

    private int strokeWidth;
    private int halfStroke;

    ResizeListener resizeListener;

    private Game gameModel;
    private Board boardModel;
    private IGameController controller;

    /* CONSTRUCTOR */
    public SwingBoardView(IGameController controller, Game gameModel) {
        this.controller = controller;
        this.gameModel = gameModel;
        this.boardModel = gameModel.getBoard();

        setBackground(new Color(75, 125, 178));

        linesHorz = new Line2D[4];
        linesVert = new Line2D[4];
        swingBoxViews = new SwingBoxView[3][3];

        for (int i = 0; i < 4; i++) {
            linesHorz[i] = new Line2D.Double();
        }
        for (int i = 0; i < 4; i++) {
            linesVert[i] = new Line2D.Double();
        }

        strokeWidth = 5;
        halfStroke = (int) (strokeWidth / 2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                swingBoxViews[i][j] = new SwingBoxView(boardModel.getBox(i*3+j+3), strokeWidth);
            }
        }

        resizeListener = new ResizeListener();
        addComponentListener(resizeListener);
        panelWidth = 0;
        panelHeight = 0;

        gameModel.registerObserver(this);
    }

    private void resizePanel(int width, int height) {
        JFrame frame = (JFrame) getTopLevelAncestor();

        //height = height - 10;
        width = height; // panel will always be square
        System.out.println("width: " + width);
        System.out.println("height: " + height);

        removeComponentListener(resizeListener);
        setPreferredSize(new Dimension(height, height));
        frame.pack();
        addComponentListener(resizeListener);

        panelWidth = width;
        panelHeight = height;

        double spacing = (width - halfStroke * 2) / (double) 3;
        linesHorz[0].setLine(0, halfStroke, width, halfStroke);
        linesHorz[1]
                .setLine(0, (int) (spacing + 2), width, (int) (spacing + 2));
        linesHorz[2].setLine(0, (int) (spacing * 2 + 2), width,
                (int) (spacing * 2 + 2));
        linesHorz[3].setLine(0, (int) (spacing * 3 + 2), width,
                (int) (spacing * 3 + 2));

        linesVert[0].setLine(halfStroke, 0, halfStroke, height);
        linesVert[1].setLine((int) (spacing + 2), 0, (int) (spacing + 2),
                height);
        linesVert[2].setLine((int) (spacing * 2 + 2), 0,
                (int) (spacing * 2 + 2), height);
        linesVert[3].setLine((int) (spacing * 3 + 2), 0,
                (int) (spacing * 3 + 2), height);

        // TODO: set box sizes every time panel is resized
        for (int i = 0; i < 3; i++) {
            int boxWidth = (int) (linesVert[i + 1].getX1() - linesVert[i] .getX1() - strokeWidth);
            for (int j = 0; j < 3; j++) {
                Point topLeft = new Point(Math.round((float)(linesHorz[i].getY1()) + halfStroke) + 1,
                        Math.round((float)(linesVert[j].getX1() + halfStroke)) + 1);
                // swingBoxViews.add(new BoxGraphics(topLeft, width));
                swingBoxViews[j][i].setTopLeft(topLeft);
                swingBoxViews[j][i].setWidth(boxWidth);
            }
        }
    }

    private void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        BasicStroke gridStroke = new BasicStroke(strokeWidth);

        g2d.setColor(Color.white);
        g2d.setStroke(gridStroke);

        for (int i = 0; i < 4; i++) {
            g2d.draw(linesHorz[i]);
        }

        for (int i = 0; i < 4; i++) {
            g2d.draw(linesVert[i]);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                swingBoxViews[i][j].draw(g2d);
            }
        }

        /*
         * TODO: decide whether we want fixed or dynamic layout if fixed, decide
         * whether coordinates are based on outer window size of 768 (in which
         * case panel will be smaller)
         */

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (!(panelHeight == getSize().height && panelWidth == getSize().width)) {
            panelHeight = getSize().height;
            panelWidth = getSize().width;
            resizePanel(panelWidth, panelHeight);
        }
        draw(g);
    }

    public void update(State state) {
        switch (state) {
            case ROLL_FOR_FIRST:
                System.out.println("Player 1 rolls " + gameModel.getPlayer(1).getLastRoll());
                System.out.println("Player 2 rolls " + gameModel.getPlayer(2).getLastRoll());
                System.out.println("Player " + gameModel.getCurrentPlayer().getPlayerNum()
                        + " starts.");
                break;
            case PEG_PLACED:
                // update pegs
        }

    }
}
