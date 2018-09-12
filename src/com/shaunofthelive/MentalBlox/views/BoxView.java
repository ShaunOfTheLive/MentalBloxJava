package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.models.Box;

import java.awt.*;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BoxView {
    private Box boxModel;
    private Point topLeft;
    private int width;

    public BoxView(Box boxModel) {
        this.boxModel = boxModel;
        this.topLeft = new Point(0, 0);
        this.width = 0;
    }

    public BoxView(Box boxModel, Point topLeft, int width) {
        this.boxModel = boxModel;
        this.topLeft = topLeft;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void draw(Graphics2D g2d) {
        // draw centre lines
        double perpDist = 0.4 * width;
        double parDist = 0.48 * width;
        double invPerpDist = (1 - 0.4) * width;
        double invParDist = (1 - 0.48) * width;

        double x = topLeft.x;
        double y = topLeft.y;

        Path2D p1 = new Path2D.Double();
        p1.moveTo(x + perpDist, y + parDist);
        p1.lineTo(x + perpDist, y + invPerpDist);
        p1.lineTo(x + invParDist, y + invPerpDist);

        Path2D p2 = new Path2D.Double();
        p2.moveTo(x + parDist, y + perpDist);
        p2.lineTo(x + invPerpDist, y + perpDist);
        p2.lineTo(x + invPerpDist, y + invParDist);

        g2d.draw(p1);
        g2d.draw(p2);

        // draw box number

        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Oxygen-Bold.ttf")));
        } catch (IOException |FontFormatException e) {
            //Handle exception
        }

        g2d.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

        Font theFont = new Font("Oxygen", Font.BOLD, 20);
        g2d.setFont(theFont);
        FontMetrics metrics = g2d.getFontMetrics(theFont);
        g2d.drawString(Integer.toString(boxModel.getNumber()), (float)(x - 2 + perpDist), (float)(y - 4 + perpDist + metrics.getAscent() - metrics.getDescent() - metrics.getLeading()));
    }
}
