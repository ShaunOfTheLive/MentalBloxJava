package com.shaunofthelive.MentalBlox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class GameWindow extends JFrame {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GameWindow() {
        
        setTitle("Simple example");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);        
     }
     

     public static void main(String[] args) {
         
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 GameWindow ex = new GameWindow();
                 ex.setVisible(true);
             }
         });
     }
     
}
