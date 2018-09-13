package com.shaunofthelive.MentalBlox.views;

import com.shaunofthelive.MentalBlox.models.Box;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.AttributedString;

public class BoxView {
    private Box boxModel;
    private Point topLeft;
    private int width;
    private int strokeWidth;
    private HoleView[][] holeViews;

    public BoxView(Box boxModel) {
        this.boxModel = boxModel;
        this.topLeft = new Point(0, 0);
        this.width = 0;
        this.strokeWidth = 1;
    }

    public BoxView(Box boxModel, int strokeWidth) {
        this.boxModel = boxModel;
        this.topLeft = new Point(0, 0);
        this.width = 0;
        this.strokeWidth = strokeWidth;
        holeViews = new HoleView[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                holeViews[i][j] = new HoleView(boxModel.getHole(i*3+j+3), this);
            }
        }
    }

    public BoxView(Box boxModel, Point topLeft, int width) {
        this.boxModel = boxModel;
        this.topLeft = topLeft;
        this.width = width;
        this.strokeWidth = 1;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        resizeOrMove();
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
        resizeOrMove();
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
        p1.moveTo(x + perpDist - 1, y + parDist - 1);
        p1.lineTo(x + perpDist - 1, y + invPerpDist - 1);
        p1.lineTo(x + invParDist - 1, y + invPerpDist - 1);

        Path2D p2 = new Path2D.Double();
        p2.moveTo(x + parDist - 1, y + perpDist - 1);
        p2.lineTo(x + invPerpDist - 1, y + perpDist - 1);
        p2.lineTo(x + invPerpDist - 1, y + invParDist - 1);

        g2d.draw(p1);
        g2d.draw(p2);

        // draw box number
        int boxNumber = boxModel.getNumber();
        String boxNumberS = Integer.toString(boxNumber);

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
        BasicStroke underlineStroke = new BasicStroke(2);
        BasicStroke gridStroke = new BasicStroke(strokeWidth);
        float textX = (float)(x + perpDist - 3);
        float textY = (float)(y + perpDist + metrics.getAscent() - metrics.getDescent() - metrics.getLeading() - 5);
        g2d.drawString(boxNumberS, textX, textY);
        if (boxNumber == 6 || boxNumber == 9) {
            g2d.setStroke(underlineStroke);
            g2d.drawLine((int)(textX + 2), (int)(textY + 5), (int)(textX + g2d.getFontMetrics(theFont).stringWidth(boxNumberS)), (int)(textY + 5));
            g2d.setStroke(gridStroke);
        }

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(180), 0, 0);
        Font rotatedFont = theFont.deriveFont(affineTransform);
        g2d.setFont(rotatedFont);
        textX = (float)(x + invPerpDist + 3);
        textY = (float)(y + invPerpDist -(metrics.getAscent() - metrics.getDescent() - metrics.getLeading() - 5));
        g2d.drawString(Integer.toString(boxNumber), textX, textY);
        if (boxNumber == 6 || boxNumber == 9) {
            g2d.setStroke(underlineStroke);
            g2d.drawLine((int)(textX - 1), (int)(textY - 4), (int)(textX - g2d.getFontMetrics(theFont).stringWidth(boxNumberS) + 1), (int)(textY - 4));
            g2d.setStroke(gridStroke);
        }
        g2d.setFont(theFont);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                holeViews[i][j].draw(g2d);
            }
        }
    }

    private void resizeOrMove() {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                holeViews[i][j].setCentre(new Point(Math.round((float)(width*(0.2+0.3*j)) + topLeft.x),
                    Math.round((float)(width*(0.2+0.3*i)) + topLeft.y)));
            }
        }
    }

    public static void drawUnderline(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        BasicStroke underlineStroke = new BasicStroke(2);
        Stroke gridStroke = g2d.getStroke();

        g2d.setStroke(underlineStroke);
        g2d.drawLine(x1, y1, x2, y2);
        g2d.setStroke(gridStroke);
    }
}
