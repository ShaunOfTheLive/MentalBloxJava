package com.shaunofthelive.MentalBlox;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		
		private Line() {
			this(0,0,0,0);
		}
		
		private Line(int x1, int y1, int x2, int y2) {
			setCoords(x1, y1, x2, y2);
		}
		
		private void setCoords(int x1, int y1, int x2, int y2) {
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
	private int panelWidth;
	private int panelHeight;
	
	private int strokeWidth;
	private int halfStroke;
	
	/* CONSTRUCTOR */
	public BoardPanel() {
		setBackground(new Color(75,125,178));
		
		linesHorz = new Line[4];
		linesVert = new Line[4];
		for (int i = 0; i < 4; i++) {
			linesHorz[i] = new Line();
		}
		for (int i = 0; i < 4; i++) {
			linesVert[i] = new Line();
		}
		
		strokeWidth = 5;
		
		halfStroke = (int)(strokeWidth/2);
		
	       addComponentListener(new ComponentAdapter() {

	            public void componentShown(ComponentEvent e) {
	            	System.out.println("componentShown");
	            }
	            
	       });
	       		
        addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
            	System.out.println("componentResized");
            	Component c = e.getComponent();

            	System.out.println("componentResized event from "
                        + c.getClass().getName()
                        + "; new size: "
                        + c.getSize().width
                        + ", "
                        + c.getSize().height);
          	
            	int height = getSize().height;
            	            	
            	((BoardPanel)c).resizePanel(height, height);
            	
            	//TODO: move this to GameWindow constructor, using pack and getInsets?
            	//setResizable(false) has 10-pixel bug!
            	//if we remove 10 pixels in here, window will keep resizing itself down to nothing
            	
            	System.out.println("RESIZED TO "
                        + c.getClass().getName()
                        + "; new size: "
                        + c.getSize().width
                        + ", "
                        + c.getSize().height);
            	
            	
            }

         });
	}

	private void resizePanel(int width, int height) {
		System.out.println("entering resizePanel");
		
    	JFrame frame = (JFrame) getTopLevelAncestor();
    	setPreferredSize(new Dimension(height, height));
    	frame.pack();
		
		panelWidth = width;
		panelHeight = height;
		
		double spacing = (width - halfStroke*2)/(double)3;
		linesHorz[0].setCoords(0, halfStroke,         width, halfStroke);
		linesHorz[1].setCoords(0, (int)(spacing+2),   width, (int)(spacing+2));
		linesHorz[2].setCoords(0, (int)(spacing*2+2), width, (int)(spacing*2+2));
		linesHorz[3].setCoords(0, (int)(spacing*3+2), width, (int)(spacing*3+2));
	
		linesVert[0].setCoords(halfStroke,         0, halfStroke,         height);
		linesVert[1].setCoords((int)(spacing+2),   0, (int)(spacing+2),   height);
		linesVert[2].setCoords((int)(spacing*2+2), 0, (int)(spacing*2+2), height);
		linesVert[3].setCoords((int)(spacing*3+2), 0, (int)(spacing*3+2), height);
	}
	
	private void draw(Graphics g) {
		System.out.println("entering draw()");

        Graphics2D g2d = (Graphics2D) g;

        BasicStroke gridStroke = new BasicStroke(
        		strokeWidth,
        		BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND,
                1.0f);
        
        g2d.setColor(Color.white);
        g2d.setStroke(gridStroke);

        for (int i = 0; i < 4; i++) {
        	System.out.println("calling draw on line " + linesHorz[i]);
        	linesHorz[i].draw(g2d);
        }

        for (int i = 0; i < 4; i++) {
        	linesVert[i].draw(g2d);
        }
        
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
