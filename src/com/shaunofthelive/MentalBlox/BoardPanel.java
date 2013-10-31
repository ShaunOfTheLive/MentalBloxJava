package com.shaunofthelive.MentalBlox;

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

        g2d.setColor(Color.white);

    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        draw(g);
    }
}
