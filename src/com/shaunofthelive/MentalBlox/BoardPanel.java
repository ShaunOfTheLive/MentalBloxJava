package com.shaunofthelive.MentalBlox;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BoardPanel extends JPanel {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private class Line {
		private int x1;
		private int x2;
		private int y1;
		private int y2;
		
		private Line(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		
		private void draw(Graphics2D g2d) {
			g2d.drawLine(x1, y1, x2, y2);
		}
	}
	
	private Line[] linesHorz;
	private Line[] linesVert;
	
	private int strokeWidth;
	
	public BoardPanel() {
		setBackground(new Color(75,125,178));
		
		linesHorz = new Line[4];
		linesVert = new Line[4];
		
		strokeWidth = 5;
		
		int halfStroke = (int)(strokeWidth/2);
		
        addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
            	Component c = e.getComponent();

//            	System.out.println("componentResized event from "
//                        + c.getClass().getName()
//                        + "; new size: "
//                        + c.getSize().width
//                        + ", "
//                        + c.getSize().height);

            	JFrame frame = ((JFrame) ((JComponent) c).getTopLevelAncestor());
            	c.setPreferredSize(new Dimension(getSize().height, getSize().height));
            	frame.pack();
            	
            	//TODO: move this to GameWindow constructor, using pack and getInsets?
            	//setResizable(false) has 10-pixel bug!
            	//if we remove 10 pixels in here, window will keep resizing itself down to nothing
            	
//            	System.out.println("RESIZED TO "
//                        + c.getClass().getName()
//                        + "; new size: "
//                        + c.getSize().width
//                        + ", "
//                        + c.getSize().height);
            	
            	
            }

         });
	}

	private void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        BasicStroke gridStroke = new BasicStroke(
        		strokeWidth,
        		BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f);
        
        g2d.setColor(Color.white);
        g2d.setStroke(gridStroke);
        // horizontal lines
        g2d.drawLine(  0,   2, 768,   2);
        g2d.drawLine(  0, 256, 768, 256);
        g2d.drawLine(  0, 512, 768, 512);
        g2d.drawLine(  0, 766, 768, 766);
        // vertical lines
        g2d.drawLine(  2,   0,   2, 768);
        g2d.drawLine(256,   0, 256, 768);
        g2d.drawLine(512,   0, 512, 768);
        g2d.drawLine(766,   0, 766, 768);
        /*
         * TODO: decide whether we want fixed or dynamic layout
         * if fixed, decide whether coordinates are based on
         *   outer window size of 768 (in which case panel will be smaller)
         * 
         */
        
    }

    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        draw(g);
    }
}
