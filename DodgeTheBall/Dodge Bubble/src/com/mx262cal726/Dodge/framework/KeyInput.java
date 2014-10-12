package com.mx262cal726.Dodge.framework;


import java.awt.Event;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.mx262cal726.Dodge.window.Handler;
import com.mx262cal726.Dodge.objects.Bullet;

public class KeyInput extends KeyAdapter 
{
  Handler handler;
  
  
  public KeyInput(Handler handler)
  {
	this.handler = handler; 
  }
	
  public void keyPressed(KeyEvent e)
  {
	int key = e.getKeyCode();
	
	for(int i=0; i< handler.object.size(); i++)
	{
	  GameObject tempObject = handler.object.get(i);
	  
	  if(tempObject.getId() == ObjectId.Player)
	  {
		//Moves Player to the right
		if(key == KeyEvent.VK_D)
		{
	      tempObject.setVelX(5);
		}
		//Moves Player to the left
		if(key == KeyEvent.VK_A)
		{
	      tempObject.setVelX(-5);
		}
		//Allows the Player to jump
		if(key == KeyEvent.VK_SPACE && !(tempObject.isJumping()) )
		{
		  tempObject.setJumping(true);
	      tempObject.setVelY(-15);
		}
		if(key == KeyEvent.VK_F)
		{
	      handler.addObject(new Bullet(tempObject.getX(), tempObject.getY(), ObjectId.Bullet, tempObject.getFacing()*5));
		}
	  }
	}
	
	
	if(key == KeyEvent.VK_ESCAPE)
	{
      System.exit(1);
	}
	
  }
  
  public void keyReleased(KeyEvent e)
  {
	int key = e.getKeyCode();
		
	for(int i=0; i< handler.object.size(); i++)
	{
	  GameObject tempObject = handler.object.get(i);
	  
	  if(tempObject.getId() == ObjectId.Player)
	  {
		if(key == KeyEvent.VK_D)
		{
	      tempObject.setVelX(0);
		}
		if(key == KeyEvent.VK_A)
		{
	      tempObject.setVelX(0);
		}
	  }
	}
  }
}

  