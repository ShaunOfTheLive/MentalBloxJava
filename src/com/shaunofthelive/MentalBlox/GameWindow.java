package com.shaunofthelive.MentalBlox;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GameWindow {
	
	private JFrame frame;

	public GameWindow() {
        
		frame = new JFrame();
		frame.setTitle("Mental Blox");
		frame.setSize(768, 768);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.pack();
			
		BoardPanel boardPanel = new BoardPanel();
		frame.add(boardPanel);
		
		frame.addComponentListener(new ComponentAdapter() {

            public void componentShown(ComponentEvent e) {
            	System.out.println("componentShown (frame)");
            }
            
       });
		
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
                 System.out.println("setVisible(true)");
             }
         });
     }
     
}
