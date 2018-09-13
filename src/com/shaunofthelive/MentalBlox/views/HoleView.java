package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.models.Hole;

import java.awt.*;

public class HoleView {
    private Hole holeModel;
    private Point centre;
    private int width;

    public HoleView(Hole holeModel) {
        this.holeModel = holeModel;
        this.centre = new Point(0, 0);
        this.width = 0;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void draw(Graphics2D g2d) {

    }
}
