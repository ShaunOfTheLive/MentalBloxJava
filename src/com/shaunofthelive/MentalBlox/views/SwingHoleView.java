package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.models.Hole;

import java.awt.*;

public class SwingHoleView {
    private SwingBoxView parent;
    private Hole holeModel;
    private Point centre;
    private int width;
    private int radius;
    private int boxWidth;

    public SwingHoleView(Hole holeModel, SwingBoxView parent) {
        this.holeModel = holeModel;
        this.centre = new Point(0, 0);
        this.width = 0;
        this.radius = 10;
        this.parent = parent;
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
        // draw dot or peg
        Color oldColor = g2d.getColor();
        int holeOwner = holeModel.getOwner();
        Color color;
        switch (holeOwner) {
            case 0:
                color = new Color(45, 74, 106);
                break;
            case 1:
                color = Color.yellow;
                break;
            case 2:
                color = Color.red;
                break;
            default:
                color = Color.white;
                break;
        }
        g2d.setColor(color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(centre.x - radius, centre.y - radius, 2*radius, 2*radius);
        g2d.setColor(oldColor);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_OFF);

        // draw number
        int holeNumber = holeModel.getNumber();
        String holeNumberS = Integer.toString(holeNumber);
        int boxWidth = parent.getWidth();
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());

        int textX = Math.round((float)(centre.x - 0.1*boxWidth));
        int textY = Math.round((float)(centre.y - 0.1*boxWidth) + metrics.getAscent() - metrics.getDescent() - metrics.getLeading() - 5);

        if (holeNumber != 7) {
            g2d.drawString(holeNumberS, textX, textY);
        }
        if (holeNumber == 6 || holeNumber == 9) {
            SwingBoxView.drawUnderline(g2d, textX + 1, textY + 4, textX + g2d.getFontMetrics(g2d.getFont()).stringWidth(holeNumberS) - 1, textY + 4);
        }
    }
}
