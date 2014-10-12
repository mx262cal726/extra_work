package com.mx262cal726.Dodge.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Random;

import com.mx262cal726.Dodge.framework.GameObject;
import com.mx262cal726.Dodge.framework.ObjectId;
import com.mx262cal726.Dodge.objects.Ball;
import com.mx262cal726.Dodge.objects.Block;
import com.mx262cal726.Dodge.objects.Flag;
import com.mx262cal726.Dodge.objects.Player;

public class Handler 
{
  public LinkedList<GameObject> object= new LinkedList<GameObject>();
  private GameObject tempObject;
  private Camera cam;
  private BufferedImage level,level2,background;
  private Random rand;
  
  
  public Handler(Camera cam)
  {
	  this.cam = cam;
	  BufferedImageLoader loader = new BufferedImageLoader();
	  rand = new Random();
	     
      
	     
	  level = loader.loadImage("/level.png");//loading the level
	  level2 = loader.loadImage("/level2.png");
	  background = loader.loadImage("/landscape.png"); 
   
  }
  
  public void tick()
  {
	for(int i=0; i < object.size(); i++)
	{
      tempObject = object.get(i);
      tempObject.tick(object);
	}
  }
  
  public void LoadImageLevel(BufferedImage image)
  {
	  int w = image.getWidth();
		int h = image.getHeight();
		System.out.println("width, height: "+w+" "+h);
		
		for(int xx=0; xx < h; xx++)
		{
			for(int yy=0; yy< w; yy++)
			{
			  int pixel = image.getRGB(xx, yy);
			  int red = (pixel>>16) & 0xff;
			  int green = (pixel >>8) & 0xff;
			  int blue = (pixel) & 0xff;
			  
			  if(red==255 && green ==255 & blue==255)
			  {
				  addObject(new Block(xx*32, yy*32,0, ObjectId.Block));
			  }
			  if(red==0 && green ==0 & blue==255)
			  {
				//  addObject(new Player(100,100,this, cam, ObjectId.Player));
			  //addObject(new Player(xx*32, yy*32, this,cam,ObjectId.Player));
			  } 
			  if(red == 200 && green==200 & blue==0)
			  {
				  int velX = rand.nextInt(8)-4;
				  int velY = rand.nextInt(8)-4;
				  addObject(new Ball(xx*30, yy*30,velX,velY,ObjectId.Ball, this));
			  }
			  if(red ==0 && green ==255 & blue ==38)
			  {
				  addObject(new Flag(xx*30, yy*30, ObjectId.Flag));
			  }
			}
		}
  }
  public void switchLevel()
  {
	clearLevel();
	cam.setX(0);
	
	
	switch(Game.LEVEL)
	{
	case 1:
		LoadImageLevel(level);
		break;
	case 2:
		LoadImageLevel(level2);
		break;
	}
	
	  
  }
  
  private void clearLevel()
  {
	object.clear();
  }
  
  public void render(Graphics g)
  {
	for(int i=0; i < object.size(); i++)
	{
      tempObject = object.get(i);
	  tempObject.render(g);
	}
  }
  
  public void addObject(GameObject object)
  {
	this.object.add(object);
	
  }
  public void removeObject(GameObject object)
  {
	this.object.remove(object);
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
}
