package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.models.Hole;

import java.awt.*;

public class HoleView {
    private Hole holeModel;
    private Point centre;
    private int width;
    private int radius;

    public HoleView(Hole holeModel) {
        this.holeModel = holeModel;
        this.centre = new Point(0, 0);
        this.width = 0;
        this.radius = 10;
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
        Color oldColor = g2d.getColor();
        g2d.setColor(new Color(45, 74, 106));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(centre.x - radius, centre.y - radius, 2*radius, 2*radius);
        g2d.setColor(oldColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_OFF);
    }
}
