package com.shaunofthelive.MentalBlox;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameWindow {
	
	private JFrame frame;

	public GameWindow() {
        
		frame = new JFrame();
		frame.setTitle("Mental Blox");
		
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle bounds = env.getMaximumWindowBounds();
		System.out.println("Screen Bounds: " + bounds );
		frame.setSize(bounds.height, bounds.height);
				
		frame.setLocationRelativeTo(null);
		
		Point p = frame.getLocation();
		frame.setLocation(new Point(p.x, p.y+5));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.pack();
			
		BoardPanel boardPanel = new BoardPanel();
		frame.add(boardPanel);
     }
	
	public JFrame getFrame() {
		return frame;
	}
     

    public static void launch() {
         
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 GameWindow gw = new GameWindow();
                 gw.getFrame().setVisible(true);
             }
         });
     }
     
}
