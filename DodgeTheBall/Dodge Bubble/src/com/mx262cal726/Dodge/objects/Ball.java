package com.mx262cal726.Dodge.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.Random;

import com.mx262cal726.Dodge.window.Animation;
import com.mx262cal726.Dodge.window.Game;
import com.mx262cal726.Dodge.window.Handler;
import com.mx262cal726.Dodge.framework.GameObject;
import com.mx262cal726.Dodge.framework.ObjectId;
import com.mx262cal726.Dodge.framework.Texture;

public class Ball extends GameObject
{
	private Handler handler;
    private float width=30,height=30;
	Texture tex = Game.getInstance();
	Animation ballMove;
	private boolean initialize=false;
	private int index=0;
	private Random random;
	private int xtemp,ytemp;
	public static boolean ballContact =false;
	
	public Ball(float x, float y,  int velX, int velY,ObjectId id, Handler handler) 
	{
	
		super(x, y, id);
		initialize=true;
		random = new Random();
		this.velX= velX;
		this.velY= velY;
	    this.handler = handler;
		ballMove = new Animation(2, tex.jump[2]);
	} 

	public void tick(LinkedList<GameObject> object)
	{
		x += velX;
		y += velY;
		
		  for(int i=0; i < handler.object.size(); i++)
		  {
			  GameObject tempObject = handler.object.get(i);
			  if(tempObject.getId()== ObjectId.Ball)
			  {
				  index++;
			  }
		  }
			Collision(object);
			ballMove.runAnimation();
	}

	public void render(Graphics g)
	{
	//	ballMove.drawAnimation(g, (int)x, (int)y);
       g.drawImage(tex.jump[2], (int)x, (int)y, null);
        
	}

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y+1, 30,30);
	}
	public Rectangle getTopBounds() 
	{
	  return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int)y-1, (int)width/2,(int)height/2);
	}
	
	public Rectangle getRightBounds() 
	{
      return new Rectangle((int) ((int)x+width), (int)y+5, (int)1,(int)height-5);
	}	
	
	public Rectangle getLeftBounds() 
	{
      return new Rectangle((int)x-1, (int)y+5, (int)5,(int)height-10);
	}	
	
	private void Collision(LinkedList<GameObject> object)
	{
	  for(int i=0; i < handler.object.size(); i++)
	  {
		GameObject tempObject = handler.object.get(i);
		
		if(tempObject.getId() == ObjectId.Block)
		{
			if(getTopBounds().intersects(tempObject.getBounds()))
			{
			  y= tempObject.getY() + (height);
			  velY=2;
			}
          if(getBounds().intersects(tempObject.getBounds()))
          {
        	  y=tempObject.getY()- (height);
        	  velY=-2;
          }
		  
		  //Right collision 
		  if(getRightBounds().intersects(tempObject.getBounds()))
		  {
		    x= tempObject.getX() -width;
		    velX = -2;
		  }
		  
		  //Left collision
		  if(getLeftBounds().intersects(tempObject.getBounds()) )
		  {
			x= tempObject.getX()+width;
			velX = 2;
		  }
		}
		/*if(tempObject.getId() == ObjectId.Player)
		{
			if(getTopBounds().intersects(tempObject.getBounds()))
			{
				ballContact=true;
				
			}
          if(getBounds().intersects(tempObject.getBounds()))
          {
        	ballContact=true;
        	  
          }
		  
		  //Right collision 
		  if(getRightBounds().intersects(tempObject.getBounds()))
		  {
	        ballContact=true;
		  }
		  
		  //Left collision
		  if(getLeftBounds().intersects(tempObject.getBounds()) )
		  {
			ballContact=true;
		  }
		}*/
	  }
	}
}
