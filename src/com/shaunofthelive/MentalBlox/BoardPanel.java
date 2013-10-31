package com.shaunofthelive.MentalBlox;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BoardPanel extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BoardPanel() {
		setBackground(new Color(75,125,178));
	}

	private void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        BasicStroke gridStroke = new BasicStroke(
        		5,
        		BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f);
        
        g2d.setColor(Color.white);
        g2d.setStroke(gridStroke);
        // horizontal lines
        g2d.drawLine(  0,   0, 768,   0);
        g2d.drawLine(  0, 256, 768, 256);
        g2d.drawLine(  0, 512, 768, 512);
        g2d.drawLine(  0, 768, 768, 768);
        // vertical lines
        g2d.drawLine(  0,   0,   0, 768);
        g2d.drawLine(256,   0, 256, 768);
        g2d.drawLine(512,   0, 512, 768);
        g2d.drawLine(768,   0, 768, 768);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        draw(g);
    }
}
