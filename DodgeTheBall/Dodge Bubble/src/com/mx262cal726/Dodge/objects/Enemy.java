package com.mx262cal726.Dodge.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.mx262cal726.Dodge.window.Animation;
import com.mx262cal726.Dodge.window.Camera;
import com.mx262cal726.Dodge.window.Game;
import com.mx262cal726.Dodge.window.Handler;
import com.mx262cal726.Dodge.framework.GameObject;
import com.mx262cal726.Dodge.framework.ObjectId;
import com.mx262cal726.Dodge.framework.Texture;

public class Enemy extends GameObject
{
	private Animation enemyWalk;
	private Animation enemyWalkForward;
    Texture tex = Game.getInstance();
    private Handler handler;
    private Camera cam;
    private int width =40;
    private int height=70;
    private final float MAX_SPEED = 10;
    private float gravity= 0.5f;
    
    
    
    public Enemy(float x, float y,Handler handler,int velX, int velY,
    		ObjectId id) 
	{
		super(x, y, id);
		this.velX = velX;
		this.velY = velY;
		this.handler = handler;
		enemyWalk = new Animation(5, tex.silver[0], tex.silver[1], 
				tex.silver[2],tex.silver[3],tex.silver[4],tex.silver[5],
				tex.silver[6],tex.silver[7]);
		enemyWalkForward = new Animation(5,tex.silver[8], tex.silver[9], 
				tex.silver[10],tex.silver[11],tex.silver[12],tex.silver[13],
				tex.silver[14],tex.silver[15] );
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
	        	  velY=0;
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
		  }
		}
	public void tick(LinkedList<GameObject> object) 
	{
		x+= velX;
		y+=velY;
		
		  if(falling || jumping)
		  {
			velY += gravity;
			if(velY > MAX_SPEED)
			{
		      velY = MAX_SPEED;
			}
		  }
		
	  Collision(object);
	  enemyWalk.runAnimation();
	  enemyWalkForward.runAnimation();
	}

	public void render(Graphics g)
	{
		//g.setColor(Color.blue);
	    //enemyWalk.drawAnimation(g, (int)x,(int)y,40,70);
	    
		if(jumping)
		{
			g.drawImage(tex.jump[0],(int)x,(int)y, 40,70,null);  
		}
		else{
		  if(velX <0  )
		  {
			enemyWalk.drawAnimation(g, (int)x, (int)y,40,70);
			setFacing(-1);
		  }
		  else if(velX > 0)//dirt block
	      {
			setFacing(1);
	    	enemyWalkForward.drawAnimation(g, (int)x,(int)y,40,70);
	      }
	      if(getFacing()==-1 && velX == 0)
	      {
	    	g.drawImage(tex.player[4], (int)x, (int)y,40,70, null);
	      }
	      if( velX==0 && getFacing()==1)
	      {
	    	g.drawImage(tex.player[0], (int)x,(int)y,40,70,null);
	      }

		}
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
