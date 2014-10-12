package com.mx262cal726.Dodge.window;


import java.awt.Dimension;

import javax.swing.JFrame;

 public class Window
 {
	Game game;

  public Window(int w, int h, String title, Game games)
  {
	game = games;
	games.setPreferredSize(new Dimension(w,h));
	games.setMaximumSize(new Dimension(w,h));
    games.setMinimumSize(new Dimension(w,h));
	
	JFrame frame = new JFrame(title);
	frame.add(games);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	
	games.start();
  }
  
  
  }
