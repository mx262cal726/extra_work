package com.mx262cal726.Dodge.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.lang.System;

import com.mx262cal726.Dodge.window.Animation;
import com.mx262cal726.Dodge.window.Camera;
import com.mx262cal726.Dodge.window.Game;
import com.mx262cal726.Dodge.window.Handler;
import com.mx262cal726.Dodge.window.Window;
import com.mx262cal726.Dodge.framework.GameObject;
import com.mx262cal726.Dodge.framework.ObjectId;
import com.mx262cal726.Dodge.framework.Texture;

public class Player extends GameObject
{
    private float width=30, height=60;
    
    private float gravity= 0.5f;
    private final float MAX_SPEED = 10;
    private Handler handler;
    
    Texture tex = Game.getInstance();
    
    private Animation playerWalk;
    private Animation playerWalkBack;
    private Animation playerJump;
    private Animation playerLose;
    private Camera cam;
    private boolean collision;
    private boolean alive=true;
    private long past;
    private long future;
    
    
	public Player(float x, float y, Handler handler, Camera cam, ObjectId id) 
	{
		super(x, y, id);
		this.handler= handler;
		this.cam = cam;
	  playerWalk = new Animation(5, tex.player[0],tex.player[3],tex.player[2], tex.player[0], tex.player[1]);
	  playerWalkBack = new Animation(5, tex.player[4], tex.player[5], tex.player[6],tex.player[7]);
	  playerJump = new Animation(5, tex.player[1]);
	  playerLose = new Animation(100, tex.lose[0], tex.lose[1],tex.lose[2]);
	}

	public void tick(LinkedList<GameObject> object) 
	{
	  x += velX;
	  y += velY;
	  
	  if(falling || jumping)
	  {
		velY += gravity;
		if(velY > MAX_SPEED)
		{
	      velY = MAX_SPEED;
		}
	  }
	  Collision(object);
	    playerWalk.runAnimation();
	    playerWalkBack.runAnimation();
	    playerJump.runAnimation();
	    playerLose.runAnimation();
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
			  y= tempObject.getY() + (height/2);
			  velY=0;
			}
			
			  if(getBounds().intersects(tempObject.getBounds()))
			  {
				y=tempObject.getY()-height;
				velY=0;
				falling = false;
				jumping = false;
			  }
			
			
		  if(getBounds().intersects(tempObject.getBounds()))
		  {
			y=tempObject.getY()-height;
			velY=0;
			falling = false;
			jumping = false;
		  }
		  else
		  {
			falling =true;
		  }
		  
		  //Right collision 
		  if(getRightBounds().intersects(tempObject.getBounds()))
		  {
		    x= tempObject.getX() - width;
		  }
		  
		  //Left collision
		  if(getLeftBounds().intersects(tempObject.getBounds()))
		  {
			x= tempObject.getX()+33;
		  }
		}
		else if(tempObject.getId()==ObjectId.Flag)
		{
		  //change levels
			if(getWholeBounds().intersects(tempObject.getBounds()))
			{
				Game.LEVEL++;
				handler.switchLevel();	
			}
			
		}
		if(tempObject.getId() == ObjectId.Ball)
		{
			if(getTopBounds().intersects(tempObject.getBounds()))
			{
				collision =true;
				//playerLose.drawAnimation(g, x, y);
				//x=100;
				//y=100;
				//handler.removeObject(tempObject);
				//handler.addObject(new);
			}
          if(getBounds().intersects(tempObject.getBounds()))
          {
        		collision = true;
				//x=100;
				//y=100;
        		//handler.removeObject(tempObject);
          }
		  
		  //Right collision 
		  if(getRightBounds().intersects(tempObject.getBounds()))
		  {
			  collision = true;
				//x=100;
			//	y=100;
				//handler.removeObject(tempObject);
		  }
		  
		  //Left collision
		  if(getLeftBounds().intersects(tempObject.getBounds()) )
		  {
				collision = true;
				//x=100;
			  //  y=100;
				//handler.removeObject(tempObject);
		  }
		}
	  }
	}
	
	public void render(Graphics g) 
	{
		g.setColor(Color.blue);
		
		
		if(collision)
		{
			//g.drawImage(tex.lose[0], (int)x,(int)y,30,60,null);
            height = 120;
            width=40;
            g.drawImage(tex.silver[16],(int)x-75,(int)y-100,200,100,null);
	      playerLose.drawAnimation(g, (int)x, (int)y);
	      alive = false;
	      
		 
	     // collision= false;
		}
		if(alive)
		{
		if(jumping)
		{
			g.drawImage(tex.jump[0],(int)x,(int)y, 30,60,null);  
		}
		else{
		  if(velX < 0  )
		  {
			playerWalkBack.drawAnimation(g, (int)x, (int)y,30,60);
			setFacing(-1);
		  }
		  else if(velX != 0)//dirt block
	      {
			setFacing(1);
	    	playerWalk.drawAnimation(g, (int)x,(int)y,30,60);
	      }
	      if(getFacing()==-1 && velX == 0)
	      {
	    	g.drawImage(tex.player[4], (int)x, (int)y,30,60, null);
	      }
	      if( velX==0 && getFacing()==1)
	      {
	    	g.drawImage(tex.player[0], (int)x,(int)y,30,60,null);
	      }
		}
		}
	 // g.setColor(Color.BLUE);
	 // g.fillRect((int)x, (int)y, (int)width,(int)height);	
	  /**
	   * Code to see the collision bounds
	   */
	 /** 
	  Graphics2D g2d = (Graphics2D)g;
	  g.setColor(Color.RED);
	  g2d.draw(getBounds());
	  g2d.draw(getLeftBounds());
	  g2d.draw(getRightBounds());
	  g2d.draw(getTopBounds());
	  */
		}
	
    public Rectangle getWholeBounds()
    {
      return new Rectangle((int)(x), (int)y, 30,60);
    }
	public Rectangle getBounds() 
	{
      return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int) ((int)y+height/2), (int)width/2,(int)height/2);
	}
	
	public Rectangle getRightBounds() 
	{
      return new Rectangle((int) ((int)x+width-5), (int)y+5, (int)5,(int)height-10);
	}	
	
	public Rectangle getLeftBounds() 
	{
      return new Rectangle((int)x, (int)y+5, (int)5,(int)height-10);
	}	
	
	public Rectangle getTopBounds() 
	{
	  return new Rectangle((int) ((int)x+(width/2)-(width/2)/2), (int)y, (int)width/2,(int)height/2);
	}
	
}
