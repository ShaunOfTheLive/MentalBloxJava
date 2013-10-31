package com.shaunofthelive.MentalBlox;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class GameWindow {
	
	private JFrame frame;

	public GameWindow() {
        
		frame = new JFrame();
		frame.setTitle("Mental Blox");
		frame.setSize(768, 768);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setBackground(new Color(75,125,178));
		
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
